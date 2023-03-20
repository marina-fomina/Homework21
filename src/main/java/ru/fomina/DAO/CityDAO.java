package ru.fomina.DAO;

import ru.fomina.City;

import java.util.List;

public interface CityDAO {
    void addCity (City city);

    City getCityById (Integer city_id);

    List<City> getAllCities ();

    void updateCityById(Integer city_id, String city_name);

    void deleteCity (City city);
}
