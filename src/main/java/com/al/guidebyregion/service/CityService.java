package com.al.guidebyregion.service;

import com.al.guidebyregion.entity.City;

import java.util.List;

public interface CityService {
    List<City> getAllInfo();

    void saveOrUpdate(City city);

    City getById(int id);

    void deleteById(int id);

}
