package ru.fomina;

import org.hibernate.SessionFactory;
import ru.fomina.DAO.EmployeeDAO;
import ru.fomina.DAO.EmployeeDAOImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();

            Employee employee = new Employee("Ольга", "Журавлева", "female", 36, 1);

            employeeDAO.addEmployee(employee);

            System.out.println(employeeDAO.getById(2));

            List<Employee> list = new ArrayList<>(employeeDAO.getAllEmployees());
            for(Employee empl : list){
                System.out.println(empl);
            }

            employeeDAO.updateEmployeeById(3, "Степан", "Логинов", "male", 49, 2);

            employeeDAO.deleteEmployee(employee);

        }
    }