package com.task.geological.controller;

import com.task.geological.exception.ResourceNotFoundException;
import com.task.geological.model.GeoClass;
import com.task.geological.repository.GeoClassRepository;
import com.task.geological.repository.GeoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GeoClassController {

    private final GeoClassRepository geoClassRepository;

    private final GeoRepository geoRepository;

    @Autowired
    public GeoClassController(GeoClassRepository geoClassRepository, GeoRepository geoRepository) {
        this.geoClassRepository = geoClassRepository;
        this.geoRepository = geoRepository;
    }

    @GetMapping("/geo/{geoId}/geoClass")
    public List<GeoClass> getAllGeoClassesByGeoId(@PathVariable(value = "geoId") Long geoId) {
        return geoClassRepository.findByGeoId(geoId);
    }

    @PostMapping("/geo/{geoId}/geoClass")
    public GeoClass createGeoClass(@PathVariable(value = "geoId") Long geoId,
                                   @Valid @RequestBody GeoClass geoClass) {
        return geoRepository.findById(geoId).map(geo -> {
            geoClass.setGeo(geo);
            return geoClassRepository.save(geoClass);
        }).orElseThrow(() -> new ResourceNotFoundException("GeoId " + geoId + " not found"));
    }

    @PutMapping("/geo/{geoId}/geoClass/{geoClassId}")
    public GeoClass updateGeoClass(@PathVariable(value = "geoId") Long geoId,
                                   @PathVariable(value = "geoClassId") Long geoClassId,
                                   @Valid @RequestBody GeoClass geoClassRequest) {
        if (!geoRepository.existsById(geoId)) {
            throw new ResourceNotFoundException("GeoId " + geoId + " not found");
        }

        return geoClassRepository.findById(geoClassId).map(geoClass -> {
            geoClass.setName(geoClassRequest.getName());
            geoClass.setCode(geoClassRequest.getCode());
            return geoClassRepository.save(geoClass);
        }).orElseThrow(() -> new ResourceNotFoundException("GeoClassId " + geoClassId + " not found"));
    }

    @DeleteMapping("/geo/{geoId}/geoClass/{geoClassId}")
    public ResponseEntity<?> deleteGeoClass(@PathVariable(value = "geoId") Long geoId,
                                            @PathVariable(value = "geoClassId") Long geoClassId) {
        return geoClassRepository.findByIdAndGeoId(geoClassId, geoId).map(geoClass -> {
            geoClassRepository.delete(geoClass);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("Geo class not found with id " + geoClassId + " and geoId " + geoId));
    }
}
