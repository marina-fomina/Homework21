package ru.fomina.DAO;

import ru.fomina.City;
import ru.fomina.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee (Employee employee);

    Employee getEmployeeById(Integer id);

    List<Employee> getAllEmployees ();

    void updateEmployeeById (Integer id, String first_name, String last_name, String gender, int age, City city);

    void deleteEmployee (Employee employee);
}
