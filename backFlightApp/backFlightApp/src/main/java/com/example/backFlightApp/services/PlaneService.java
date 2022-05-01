package com.example.backFlightApp.services;

import com.example.backFlightApp.models.Plane;
import com.example.backFlightApp.repositories.PlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlaneService {

    PlaneRepository planeRepository;

    @Autowired
    public PlaneService(PlaneRepository planeRepository){
        this.planeRepository = planeRepository;
    }

    public void insertAllPlanes(Iterable<Plane> planes){

        planeRepository.saveAll(planes);
    }
}
