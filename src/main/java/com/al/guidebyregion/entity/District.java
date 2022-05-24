package com.al.guidebyregion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "district")
@Data
public class District {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "districtname")
    private String districtName;
    @Transient
    @JsonIgnore
    private Region region;

    @OneToMany(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "district_id")
    private List<Region> regionInDistrict;

    public void addRegionInDistrict(Region region) {
        if (regionInDistrict == null) {
            regionInDistrict = new ArrayList<>();
        }
        regionInDistrict.add(region);
//        region.setDistrict(this);
    }

    @Override
    public String toString() {
        return "District={" + districtName + ", incoming regions:\n" + regionInDistrict + "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        District district = (District) o;
        return Objects.equals(districtName, district.districtName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(districtName);
    }


}
