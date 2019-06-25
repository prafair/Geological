package com.task.geological.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "geo_section")
public class Geo {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", unique = true)
    private String name;

    //@Size(min = 1, message = "Should be not empty")
    @OneToMany(mappedBy = "geo",
            fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<GeoClass> geoClasses;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<GeoClass> getGeoClasses() {
        return geoClasses;
    }

    public void setGeoClasses(List<GeoClass> geoClasses) {
        this.geoClasses = geoClasses;
    }
}
