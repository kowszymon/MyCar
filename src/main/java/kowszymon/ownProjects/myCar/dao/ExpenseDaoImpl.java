package kowszymon.ownProjects.myCar.dao;

import kowszymon.ownProjects.myCar.entities.Expense;
import kowszymon.ownProjects.myCar.hibernate.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class ExpenseDaoImpl implements ExpenseDao {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Logger logger = Logger.getLogger(ExpenseDaoImpl.class);


    @Override
    public List<Expense> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from Expense e");
        return (List<Expense>)query.list();
    }

    @Override
    public Optional<Expense> findById(Long id) {
        Session session = sessionFactory.openSession();
        Expense expense = null;
        try {
            Transaction transaction = session.beginTransaction();
            expense = session.find(Expense.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Problem with getting expense by id="+id+" "+e.getMessage());
        } finally {
            return Optional.ofNullable(expense);
        }
    }

    @Override
    public void save(Expense expense) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(expense);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Problem with inserting expense "+ expense.toString()+" message"+e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Expense expense = session.find(Expense.class, id);
            session.remove(expense);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Problem with deleting expense with id "+id + e.getMessage());
        }
    }
}
