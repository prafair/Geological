package com.task.geological.repository;

import com.task.geological.model.Geo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GeoRepository extends CrudRepository<Geo, Long> {

}
