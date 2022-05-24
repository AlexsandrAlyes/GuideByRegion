package com.al.guidebyregion.service;

import com.al.guidebyregion.entity.District;

import java.util.List;

public interface DistrictService {
    List<District> getAllInfo();

    void saveOrUpdate(District district);

    District getById(int id);

    void deleteById(int id);
}
