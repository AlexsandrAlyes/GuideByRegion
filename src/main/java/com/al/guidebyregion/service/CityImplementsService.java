package com.al.guidebyregion.service;


import com.al.guidebyregion.dao.CityDAO;
import com.al.guidebyregion.entity.City;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
@RequiredArgsConstructor
public class CityImplementsService implements CityService {

    private final CityDAO cityDAO;


    @Override
    public List<City> getAllInfo() {
        return cityDAO.findAll();
    }

    @Override
    public void saveOrUpdate(City city) {
        cityDAO.save(city);
    }

    @Override
    public City getById(int id) {
        return cityDAO.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        cityDAO.deleteById(id);
    }
}
