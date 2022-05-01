package com.example.APIFlightApp.dao;

import com.example.APIFlightApp.models.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImpFlightDao implements FlightsDao{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Flight> getAll() {
        return jdbcTemplate.query("SELECT * FROM flight", new BeanPropertyRowMapper<Flight>(Flight.class));
    }

    @Override
    public Flight getById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM flight WHERE id=?", new BeanPropertyRowMapper<Flight>(Flight.class), id);
    }
}
