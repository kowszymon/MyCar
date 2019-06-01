package kowszymon.ownProjects.myCar.dao;

import kowszymon.ownProjects.myCar.entities.Car;
import kowszymon.ownProjects.myCar.hibernate.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;
import java.util.Optional;

import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CarDaoImpl implements CarDao {

    SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    Logger logger = Logger.getLogger(CarDaoImpl.class);

    @Override
    public List<Car> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Car c");
        return (List<Car>)query.list();
    }

    @Override
    public List<Car> findActiveCars() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Car c where status = 'ACTIVE'");
        return (List<Car>)query.list();
    }

    @Override
    public List<Car> findArchivedCars() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select c from Car c where status = 'ARCHIVED'");
        return (List<Car>)query.list();
    }


    @Override
    public Optional<Car> findById(Long id) {
        Session session = sessionFactory.openSession();
        Car car = null;
        try {
            Transaction transaction = session.beginTransaction();
            car = session.find(Car.class, id);
            transaction.commit();
        } catch (HibernateException e) {
            logger.error("Problem during getting car by Id=" + id + " " + e.getMessage());
        } finally {
            return Optional.ofNullable(car);
        }
    }

    @Override
    public void save(Car car) {
        Transaction transaction = null;
        try {
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(car);
            transaction.commit();
        } catch (HibernateException e) {
            transaction.rollback();
            logger.error("Problem during inserting car " + car.toString() + " message " + e.getMessage());
        }

    }

}
