package kowszymon.ownProjects.myCar.dao;

import kowszymon.ownProjects.myCar.entities.Income;
import kowszymon.ownProjects.myCar.hibernate.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;

public class IncomeDaoImpl implements IncomeDao {

    private static Logger logger = Logger.getLogger(IncomeDaoImpl.class);

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public List<Income> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select i from Income i");
        return (List<Income>)query.list();
    }

    @Override
    public Optional<Income> findById(Long id) {
        Session session = sessionFactory.openSession();
        Income income = null;
        try {
            Transaction transaction = session.beginTransaction();
            income = session.find(Income.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Problem during getting income by id " + income.getId() + " " + e.getMessage());
        } finally {
            return Optional.ofNullable(income);
        }
    }

    @Override
    public void save(Income income) {

        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(income);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Problem during inserting income " + income.toString() + " " + e.getMessage());
        }

    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Income income = session.find(Income.class, id);
            session.remove(income);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Problem during deleting income with id " + id + " " + e.getMessage());
        }

    }
}
