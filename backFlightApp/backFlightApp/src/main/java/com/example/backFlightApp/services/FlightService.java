package com.example.backFlightApp.services;

import com.example.backFlightApp.models.Flight;
import com.example.backFlightApp.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    FlightRepository flightRepository;

    @Autowired
    public FlightService(FlightRepository flightRepository){

        this.flightRepository = flightRepository;
    }

    public void insertAllFlights(Iterable<Flight> flights){

        flightRepository.saveAll(flights);
    }


}
