package com.example.APIFlightApp.dao;

import com.example.APIFlightApp.models.Historic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ImpHistoricFlightsDao implements HistoricFlightsDao{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Historic> getAll() {
        return jdbcTemplate.query("SELECT * FROM historic", new BeanPropertyRowMapper<Historic>(Historic.class));
    }

    @Override
    public Historic getById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM historic WHERE id=?", new BeanPropertyRowMapper<Historic>(Historic.class), id);
    }
}
