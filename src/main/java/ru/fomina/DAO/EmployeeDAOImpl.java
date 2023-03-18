package ru.fomina.DAO;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.fomina.Employee;
import ru.fomina.HibernateSessionFactoryUtil;

import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {

    public EmployeeDAOImpl() {
    }

    @Override
    public void addEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
    }

    @Override
    public Employee getById(int id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(Employee.class, id);
    }

    @Override
    public List <Employee> getAllEmployees() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().
                createQuery("From Employee").list();
    }

    @Override
    public void updateEmployeeById(int id, String first_name, String last_name, String gender, int age, int city) {
        Employee employee = new Employee(id, first_name, last_name, gender, age, city);
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
    }

    @Override
    public void deleteEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
        }
}
