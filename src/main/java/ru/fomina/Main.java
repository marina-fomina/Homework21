package ru.fomina;

import ru.fomina.DAO.CityDAO;
import ru.fomina.DAO.CityDAOImpl;
import ru.fomina.DAO.EmployeeDAO;
import ru.fomina.DAO.EmployeeDAOImpl;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
            EmployeeDAO employeeDAO = new EmployeeDAOImpl();
            City city1 = new City(1, "Пермь");
            City city2 = new City(2, "Владивосток");

            Employee employee = new Employee("Ольга", "Журавлева", "female", 36, city1);

            employeeDAO.addEmployee(employee);

            System.out.println(employeeDAO.getEmployeeById(2));

            List<Employee> list = new ArrayList<>(employeeDAO.getAllEmployees());
            for(Employee empl : list){
                System.out.println(empl);
            }

            employeeDAO.updateEmployeeById(3, "Степан", "Логинов", "male", 49, city2);

            employeeDAO.deleteEmployee(employee);

            CityDAO cityDAO = new CityDAOImpl();

            City newCity = new City(6, "Екатеринбург");
            cityDAO.addCity(newCity);

            System.out.println(cityDAO.getCityById(3));

            List<City> cities = new ArrayList<>(cityDAO.getAllCities());
            for (City cityFromList : cities) {
            System.out.println(cityFromList);
            }

            cityDAO.updateCityById(4, "Новосибирск");

            cityDAO.deleteCity(newCity);
        }
    }