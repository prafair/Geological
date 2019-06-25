package com.task.geological.controller;

import com.task.geological.exception.ResourceNotFoundException;
import com.task.geological.model.Geo;
import com.task.geological.repository.GeoRepository;
import com.task.geological.service.ImportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class GeoController {


    private final GeoRepository geoRepository;

    private final ImportService importService;

    public GeoController(ImportService importService, GeoRepository geoRepository) {
        this.importService = importService;
        this.geoRepository = geoRepository;
    }

    @GetMapping("/geo")
    public Iterable<Geo> getAllGeoWithGeoClasses() {
        return geoRepository.findAll();
    }

    @PostMapping("/geo")
    public Geo createGeo(@Valid @RequestBody Geo geo) {
        return geoRepository.save(geo);
    }

    @PutMapping("/geo/{geoId}")
    public Geo updateGeo(@PathVariable Long geoId, @Valid @RequestBody Geo geoRequest) {
        return geoRepository.findById(geoId).map(geo -> {
            geo.setName(geoRequest.getName());
            return geoRepository.save(geo);
        }).orElseThrow(() -> new ResourceNotFoundException("GeoId " + geoId + " not found"));
    }

    @DeleteMapping("/geo/{geoId}")
    public ResponseEntity<?> deleteGeo(@PathVariable Long geoId) {
        return geoRepository.findById(geoId).map(geo -> {
            geoRepository.delete(geo);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("GeoId " + geoId + " not found"));
    }

    @PostMapping("/import")
    public List<Map<String, String>> importGeo (@RequestParam("file") MultipartFile file) throws IOException {
        return importService.importGeo(file);
    }


}