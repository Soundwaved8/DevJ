package com.example.APIFlightApp.dao;

import com.example.APIFlightApp.models.Historic;
import com.example.APIFlightApp.models.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ImpPlaneDao implements PlaneDao{

    @Autowired
    JdbcTemplate jdbcTemplate;


    @Override
    public List<Plane> getAll() {
        return jdbcTemplate.query("SELECT * FROM plane", new BeanPropertyRowMapper<Plane>(Plane.class));
    }

    @Override
    public Plane getById(String id) {
        return jdbcTemplate.queryForObject("SELECT * FROM plane WHERE id=?", new BeanPropertyRowMapper<Plane>(Plane.class), id);
    }
}
