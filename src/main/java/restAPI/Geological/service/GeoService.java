package restAPI.Geological.service;

import restAPI.Geological.model.Geo;

import java.util.List;

public interface GeoService {
    List<Geo> allGeo();
    void add (Geo geo);
    void delete (Geo geo);
    void edit (Geo geo);
    Geo getById(int id);
}
