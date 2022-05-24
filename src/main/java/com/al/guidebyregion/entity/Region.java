package com.al.guidebyregion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "region")
@Data
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "regionname")
    private String regionName;
    @Transient
    @JsonIgnore
    private String districtName;
    @Transient
    @JsonIgnore
    private City city;
//    @JsonIgnore
//    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinColumn(name = "district_id")
//    private District district;
    @JsonIgnore
    @OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}/** , mappedBy = "region"*/)
    @JoinColumn(name = "region_id")
    private List<City> cityInRegion;

    public void addCityInRegion(City city) {
        if (cityInRegion == null) {
            cityInRegion = new ArrayList<>();
        }
        cityInRegion.add(city);
//        city.setRegion(this);
    }

    @Override
    public String toString() {
        return "Region={" + regionName + ", incoming cities:\n" + cityInRegion + "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(regionName, region.regionName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(regionName);
    }
}
