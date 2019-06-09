package restAPI.Geological.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import restAPI.Geological.dao.GeoDAO;
import restAPI.Geological.model.Geo;

import java.util.List;

@Service
public class GeoServiceImpl implements GeoService {

    private GeoDAO geoDAO;

    @Autowired
    public void setGeoDAO(GeoDAO geoDAO) {
        this.geoDAO = geoDAO;
    }

    @Transactional
    @Override
    public List<Geo> allGeo() {
        return geoDAO.allGeo();
    }

    @Transactional
    @Override
    public void add(Geo geo) {
        geoDAO.add(geo);
    }

    @Transactional
    @Override
    public void delete(Geo geo) {
        geoDAO.delete(geo);
    }

    @Transactional
    @Override
    public void edit(Geo geo) {
        geoDAO.edit(geo);
    }

    @Transactional
    @Override
    public Geo getById(int id) {
        return geoDAO.getById(id);
    }
}
