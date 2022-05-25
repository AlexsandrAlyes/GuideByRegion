package com.al.guidebyregion.controller;

import com.al.guidebyregion.service.CityService;
import com.al.guidebyregion.service.DistrictService;
import com.al.guidebyregion.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping(value = "/test/view")
public class GuideController {

    private final DistrictService districtService;
    private final RegionService regionService;
    private final CityService cityService;

    @Autowired
    public GuideController(DistrictService districtService, RegionService regionService, CityService cityService) {
        this.districtService = districtService;
        this.regionService = regionService;
        this.cityService = cityService;
    }

    @GetMapping("/districts")
    public String showAll(Model model) {
        var listDistrict = districtService.getAllInfo();
        model.addAttribute("listDistrict", listDistrict);
        return "all-districts";
    }

    @GetMapping("district/{id}")
    public String showRegionInDistrict(@PathVariable("id") int id, Model model) {
        model.addAttribute("district", districtService.getById(id));
        return "regionsInDistrict";
    }

    @GetMapping("district/region/{id}")
    public String showCitiesInRegion(@PathVariable("id") int id, Model model) {
        model.addAttribute("region", regionService.getRegionById(id));
        return "citiesInRegion";
    }

    @GetMapping("/find-city")
    public String findCityByName(HttpServletRequest request, Model model) {
        model.addAttribute("City",cityService.findByName(request.getParameter("cityName")));
        return "showCity";
    }

}
