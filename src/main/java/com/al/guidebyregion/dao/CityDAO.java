package com.al.guidebyregion.dao;

import com.al.guidebyregion.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityDAO extends JpaRepository<City, Integer> {

    City getByName(String name);



}
