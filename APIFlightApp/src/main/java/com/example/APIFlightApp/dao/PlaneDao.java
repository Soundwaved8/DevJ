package com.example.APIFlightApp.dao;


import com.example.APIFlightApp.models.Plane;

import java.util.List;

public interface PlaneDao {

    List<Plane> getAll();

    Plane getById(String id);
}
