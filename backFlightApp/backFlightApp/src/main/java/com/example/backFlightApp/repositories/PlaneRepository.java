package com.example.backFlightApp.repositories;

import com.example.backFlightApp.models.Plane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaneRepository extends JpaRepository<Plane, String> {
}
