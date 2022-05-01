package com.example.APIFlightApp.controllers;


import com.example.APIFlightApp.dao.HistoricFlightsDao;
import com.example.APIFlightApp.models.Historic;
import com.example.APIFlightApp.repositories.HistoricPlaneRepository;
import com.example.APIFlightApp.services.HistoricPlaneService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HistoricPlaneController {

    @Autowired
    HistoricPlaneService historicPlaneService;

    @Autowired
    public HistoricPlaneController(HistoricPlaneService historicPlaneService){
        this.historicPlaneService = historicPlaneService;
    }

    /*@RequestMapping(path = "/historic")
    public List<Historic> getAllHistoricPlane(){
        return historicFlightsDao.getAll();
    }

    @RequestMapping(path = "/historic/{id}")
    public Historic getHistoricPlaneById(@PathVariable String id){
        return historicFlightsDao.getById(id);
    }*/

    @RequestMapping(path = "/historic")
    public String getFlight() {
        JSONArray jsonArray = new JSONArray(historicPlaneService.getAllHistoricFlights());
        return jsonArray.toString();
    }

    @RequestMapping(path = "/historic/{id}")
    public String getFlightById(@PathVariable("id") String id) {
        JSONObject jsonObject = new JSONObject(historicPlaneService.getHistoricFlightById(id));
        return jsonObject.toString();
    }
}
