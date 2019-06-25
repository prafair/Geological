package com.task.geological.repository;

import com.task.geological.model.GeoClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeoClassRepository extends CrudRepository<GeoClass, Long> {
    List<GeoClass> findByGeoId(Long geoId);

    Optional<GeoClass> findByIdAndGeoId(Long id, Long geoId);
}