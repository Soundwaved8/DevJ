package com.example.APIFlightApp.repositories;

import com.example.APIFlightApp.models.Historic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoricPlaneRepository extends JpaRepository<Historic, String> {
}
