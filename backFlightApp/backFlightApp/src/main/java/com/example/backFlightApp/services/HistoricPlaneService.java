package com.example.backFlightApp.services;

import com.example.backFlightApp.models.Historic;
import com.example.backFlightApp.repositories.HistoricPlaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricPlaneService {

    HistoricPlaneRepository historicPlaneRepository;

    @Autowired
    public HistoricPlaneService(HistoricPlaneRepository historicPlaneRepository){
        this.historicPlaneRepository = historicPlaneRepository;
    }

    public void insertAllPlaneHistoric(Iterable<Historic> historicPlanes){
        historicPlaneRepository.saveAll(historicPlanes);
    }
}
