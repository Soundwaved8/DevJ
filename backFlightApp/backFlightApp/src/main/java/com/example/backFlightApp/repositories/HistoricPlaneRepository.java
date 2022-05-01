package com.example.backFlightApp.repositories;

import com.example.backFlightApp.models.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricPlaneRepository extends JpaRepository<Historic, String> {
}
