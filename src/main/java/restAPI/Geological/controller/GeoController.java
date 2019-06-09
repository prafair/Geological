package restAPI.Geological.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import restAPI.Geological.model.Geo;
import restAPI.Geological.service.GeoService;

import java.util.List;

@RestController
public class GeoController {

    private GeoService geoService;

    @Autowired
    public void setGeoService(GeoService geoService) {
        this.geoService = geoService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allGeo() {
        List<Geo> geos = geoService.allGeo();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("geo");
        modelAndView.addObject("geoList", geos);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editGeoPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addGeo(@RequestBody @ModelAttribute("geo") Geo geo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        geoService.add(geo);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editGeoPage(@PathVariable int id) {
        Geo geo = geoService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editGeoPage");
        modelAndView.addObject("geo", geo);
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editGeo(@ModelAttribute("geo") Geo geo) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        geoService.edit(geo);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteGeo(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        Geo geo = geoService.getById(id);
        geoService.delete(geo);
        return modelAndView;
    }
}
