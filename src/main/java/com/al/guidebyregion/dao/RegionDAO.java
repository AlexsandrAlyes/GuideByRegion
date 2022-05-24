package com.al.guidebyregion.dao;

import com.al.guidebyregion.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegionDAO extends JpaRepository<Region, Integer> {


}
