package restAPI.Geological.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import restAPI.Geological.model.Geo;

import java.util.*;

@Repository
public class GeoDAOImpl implements GeoDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Geo> allGeo() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Geo").list();
    }

    @Override
    public void add(Geo geo) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(geo);
    }

    @Override
    public void delete(Geo geo) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(geo);
    }

    @Override
    public void edit(Geo geo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(geo);
    }

    @Override
    public Geo getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Geo.class, id);
    }

}
