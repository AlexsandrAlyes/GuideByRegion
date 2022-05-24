package com.al.guidebyregion.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "City")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "population")
    private int population;
    @Column(name = "foundation")
    private String foundation;
    @Transient
    @JsonIgnore
    private String regionName;
//    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    @JoinColumn(name = "region_id")
//    private Region region;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return population == city.population && Objects.equals(name, city.name) && Objects.equals(foundation, city.foundation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, population, foundation);
    }
}
