package ru.fomina;

import ru.fomina.DAO.EmployeeDAO;
import ru.fomina.DAO.EmployeeDAOImpl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(Paths.get("db.properties").toFile()));

        try (Connection connection = DriverManager.getConnection(properties.getProperty("url"),
                properties.getProperty("user"), properties.getProperty("password"))) {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT * FROM employee INNER JOIN city ON employee.city_id = city.city_id WHERE id=1");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getString("id") + ". "
                        + "Имя - " + resultSet.getString("first_name") + ". "
                        + "Фамилия - " + resultSet.getString("last_name") + ". "
                        + "Пол - " + resultSet.getString("gender") + ". "
                        + "Возраст - " + resultSet.getString("age") + ". "
                        + "Город - " + resultSet.getString("city_name") + ".");
            }

            EmployeeDAO employeeDAO = new EmployeeDAOImpl(connection);

            City city = new City(1, "Пермь");
            Employee employee = new Employee("Ольга", "Журавлева", "female", 36, city);

            employeeDAO.addEmployee(employee);

            System.out.println(employeeDAO.getById(2));

            List<Employee> list = new ArrayList<>(employeeDAO.getAllEmployees());
            for(Employee empl : list){
                System.out.println(empl);
            }

            employeeDAO.updateEmployeeById(3, "Степан", "Логинов", "male", 49, 2);

            employeeDAO.deleteById(4);
        }
    }
}