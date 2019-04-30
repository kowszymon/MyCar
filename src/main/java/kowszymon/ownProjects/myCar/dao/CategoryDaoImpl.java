package kowszymon.ownProjects.myCar.dao;

import kowszymon.ownProjects.myCar.entities.Category;
import kowszymon.ownProjects.myCar.hibernate.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class CategoryDaoImpl implements CategoryDao {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
    Logger logger = Logger.getLogger(CategoryDaoImpl.class);

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Category c");
        return (List<Category>)query.list();
    }

    @Override
    public Optional<Category> findById(Long id) {
        Session session = sessionFactory.openSession();
        Category category = null;
        try {
            Transaction transaction = session.beginTransaction();
            category = session.find(Category.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Problem with getting category by id="+id+" "+e.getMessage());
        } finally {
            return Optional.ofNullable(category);
        }
    }

    @Override
    public void save(Category category) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(category);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Problem with inserting category "+ category.toString()+" message"+e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            Category category = session.find(Category.class, id);
            session.remove(category);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Problem with deleting category with id "+id + e.getMessage());
        }

    }
}
