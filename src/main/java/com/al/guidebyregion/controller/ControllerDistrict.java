package com.al.guidebyregion.controller;

import com.al.guidebyregion.entity.District;
import com.al.guidebyregion.service.DistrictService;
import com.al.guidebyregion.util.CityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
@RequestMapping(value = "/test/json")
@RequiredArgsConstructor
public class ControllerDistrict {
    private final DistrictService districtService;
    private final CityUtils cityUtils;

    @PostConstruct
    public void addInDBH2DistrictsAndRegionsAndCities(){
        cityUtils.parse().forEach(this::saveDistrict);
    }

    @GetMapping("/districts")
    public List<District> showAllInfoDistricts(){
        return districtService.getAllInfo();
    }

    @GetMapping("/districts/{id}")
    public District getDistrictById(@PathVariable int id){
        return districtService.getById(id);
    }

    @PostMapping("/districts")
    public void saveDistrict(@RequestBody District district){
        districtService.saveOrUpdate(district);
    }

    @PutMapping("/districts")
    public void updateDistrict(@RequestBody District district){
        districtService.saveOrUpdate(district);
    }


}
