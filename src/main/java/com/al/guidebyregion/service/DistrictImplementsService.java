package com.al.guidebyregion.service;

import com.al.guidebyregion.dao.DistrictDAO;
import com.al.guidebyregion.entity.District;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DistrictImplementsService implements DistrictService{
    private final DistrictDAO districtDAO;

    @Override
    public List<District> getAllInfo() {
        return districtDAO.findAll();

    }

    @Override
    public void saveOrUpdate(District district) {
        districtDAO.save(district);

    }

    @Override
    public District getById(int id) {
        return districtDAO.findById(id).get();
    }

    @Override
    public void deleteById(int id) {
        districtDAO.deleteById(id);
    }
}
