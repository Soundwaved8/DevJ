package com.example.APIFlightApp.dao;

import com.example.APIFlightApp.models.Historic;

import java.util.List;

public interface HistoricFlightsDao {

    List<Historic> getAll();

    Historic getById(String id);
}
