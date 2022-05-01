package com.example.APIFlightApp.dao;

import com.example.APIFlightApp.models.Flight;
import com.example.APIFlightApp.models.Historic;

import java.util.List;

public interface FlightsDao {

    List<Flight> getAll();

    Flight getById(String id);
}
