package com.example.APIFlightApp.controllers;


import com.example.APIFlightApp.dao.FlightsDao;
import com.example.APIFlightApp.models.Flight;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FlightController  {

    @Autowired
    private FlightsDao flightsDao;


    @RequestMapping("/flights")
    public List<Flight> getEmployees(){
        return flightsDao.getAll();
    }

    // méthode qui va permettre de retourne l'employé vua l'id passer en paramètre
    @RequestMapping("/flights/{id}")
    public Flight getFlightById(@PathVariable String id){
        return flightsDao.getById(id);
    }
}
