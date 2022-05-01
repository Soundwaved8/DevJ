package com.example.APIFlightApp.services;

import com.example.APIFlightApp.models.Historic;
import com.example.APIFlightApp.repositories.HistoricPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoricPlaneService {

    HistoricPlaneRepository historicPlaneRepository;

    @Autowired
    public HistoricPlaneService(HistoricPlaneRepository historicPlaneRepository){
        this.historicPlaneRepository = historicPlaneRepository;
    }

    public List<Historic> getAllHistoricFlights(){

        return historicPlaneRepository.findAll();
    }
    public Historic getHistoricFlightById(String id){
        return historicPlaneRepository.findById(id).get();
    }
}
