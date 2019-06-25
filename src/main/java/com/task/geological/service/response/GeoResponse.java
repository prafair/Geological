package com.task.geological.service.response;

import com.task.geological.model.Geo;

import java.util.ArrayList;
import java.util.List;

public class GeoResponse {
    private Boolean done;
    private List<Geo> imported = new ArrayList<Geo>();
    private List<String> errors = new ArrayList<String>();

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public List<Geo> getImported() {
        return imported;
    }

    public void setImported(List<Geo> imported) {
        this.imported = imported;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
