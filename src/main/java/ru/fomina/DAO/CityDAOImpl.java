package ru.fomina.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.fomina.City;
import ru.fomina.HibernateSessionFactoryUtil;

import java.util.List;

public class CityDAOImpl implements CityDAO {

    public CityDAOImpl() {
    }

    @Override
    public void addCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
    }

    @Override
    public City getCityById(Integer city_id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(City.class, city_id);
    }

    @Override
    public List <City> getAllCities() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("FROM City").getResultList();
    }

    @Override
    public void updateCityById(Integer city_id, String city_name) {
        City city = new City(city_id, city_name);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
    }

    @Override
    public void deleteCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
    }
}
