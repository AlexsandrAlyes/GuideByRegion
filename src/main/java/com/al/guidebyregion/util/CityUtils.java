package com.al.guidebyregion.util;

import com.al.guidebyregion.entity.City;
import com.al.guidebyregion.entity.District;
import com.al.guidebyregion.entity.Region;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CityUtils {

    public List<District> parse() {

        List<District> districtsList = new ArrayList<>();
        List<Region> regionList = new ArrayList<>();


        try (Scanner scanner = new Scanner(new File("src/main/resources/excel.guide/city_ru.csv"))) {
            while (scanner.hasNextLine()) {
                District district = parseFromCSVinObject(scanner.nextLine());

                if (regionList.contains(district.getRegion())) {
                    regionList.forEach(region -> {
                        if (region.equals(district.getRegion())) {
                            region.addCityInRegion(district.getRegion().getCity());
                        }
                    });
                } else {
                    district.getRegion().addCityInRegion(district.getRegion().getCity());
                    regionList.add(district.getRegion());
                }

                if (!(districtsList.contains(district))) {
                    districtsList.add(district);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for (District district : districtsList) {
            for (Region region : regionList) {
                if (district.getDistrictName().equals(region.getDistrictName())) {
                    district.addRegionInDistrict(region);
                }
            }
        }

        return districtsList;
    }

    private District parseFromCSVinObject(String line) {
        District district = new District();
        Region region = new Region();
        City city = new City();

        try (Scanner scanner = new Scanner(line)) {
            scanner.useDelimiter(";");
            scanner.skip("\\d*");
            city.setName(scanner.next());
            region.setRegionName(scanner.next());
            district.setDistrictName(scanner.next());
            city.setPopulation(scanner.nextInt());
            if (scanner.hasNext()) {
                city.setFoundation(scanner.next());
            }
        }
        city.setRegionName(region.getRegionName());
        region.setDistrictName(district.getDistrictName());
        region.setCity(city);
        district.setRegion(region);
        return district;
    }
}
