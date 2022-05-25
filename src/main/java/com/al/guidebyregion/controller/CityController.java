package com.al.guidebyregion.controller;

import com.al.guidebyregion.entity.City;
import com.al.guidebyregion.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/test/json")
public class CityController {

    private final CityService cityService;

    @GetMapping("/cities")
    public List<City> showAllInfoDistricts(){
        return cityService.getAllInfo();
    }
    @GetMapping("/cities/{id}")
    public City getCityById(@PathVariable int id){
        return cityService.getById(id);
    }
    @PostMapping("/cities")
    public void saveCity (@RequestBody City city){
        cityService.saveOrUpdate(city);
    }
    @PutMapping("/cities")
    public void updateCity (@RequestBody City city){
        cityService.saveOrUpdate(city);
    }
    @DeleteMapping("cities/{id}")
    public void deleteCityById(@PathVariable int id){
        cityService.deleteById(id);
    }
    @GetMapping("/cities/find/{name}")
    public City getByName(@PathVariable String name){
        return cityService.findByName(name);
    }

}
