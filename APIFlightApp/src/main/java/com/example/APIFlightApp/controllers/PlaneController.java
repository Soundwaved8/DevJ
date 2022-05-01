package com.example.APIFlightApp.controllers;


import com.example.APIFlightApp.dao.PlaneDao;
import com.example.APIFlightApp.models.Plane;
import com.example.APIFlightApp.repositories.PlaneRepository;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlaneController {

    @Autowired
    private PlaneDao planeDao;

    @RequestMapping(path = "/planes")
    public List<Plane> getAllPlanes() {
        return planeDao.getAll();
    }

    @RequestMapping(path = "/planes/{id}")
    public Plane getPlaneById(@PathVariable String id) {
        return planeDao.getById(id);
    }


}
