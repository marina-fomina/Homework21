package ru.fomina.DAO;

import ru.fomina.City;
import ru.fomina.Employee;

import java.util.List;

public interface EmployeeDAO {
    void addEmployee (Employee employee);

    Employee getById (int id);

    List<Employee> getAllEmployees ();

    void updateEmployeeById (int id, String first_name, String last_name, String gender, int age, int city);

    void deleteEmployee (Employee employee);
}
