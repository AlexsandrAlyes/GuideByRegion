package com.al.guidebyregion.service;

import com.al.guidebyregion.dao.RegionDAO;
import com.al.guidebyregion.entity.Region;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegionImplementService implements RegionService {


    private final RegionDAO regionDAO;



    @Override
    public Region getRegionById(int id) {
        return regionDAO.findById(id).get();
    }


}
