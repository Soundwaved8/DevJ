package com.example.backFlightApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "flight")
public class Flight {
    // classe qui contiendra notre modèle de données
    @Id
    @Column(name = "id_flight")
    private String hex;
    @Column(name = "flight_number")
    private String flightNumber;
    private String status;
    private String departure_airport;
    private String arrival_airport;
    @Column(name = "id_plane")
    private String icao24;

    // constructeur

    public Flight(){

    }

    public Flight(String hex, String flightNumber, String status, String departure_airport, String arrival_airport, String icao24){
        this.hex = hex;
        this.flightNumber = flightNumber;
        this.status = status;
        this.departure_airport = departure_airport;
        this.arrival_airport = arrival_airport;
        this.icao24 = icao24;
    }

    public String getHex() {
        return hex;
    }

    public void setId(String hex) {
        hex = hex;
    }



    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public String getArrival_airport() {
        return arrival_airport;
    }

    public void setArrival_airport(String arrival_airport) {
        this.arrival_airport = arrival_airport;
    }
    public String getIcao24(){
        return icao24;
    }
    public void setIcao24(String icao24){
        this.icao24 = icao24;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "hex='" + hex + '\'' +
                ", flightNumber=" + flightNumber +
                ", status='" + status + '\'' +
                ", departure_airport='" + departure_airport + '\'' +
                ", arrival_airport='" + arrival_airport + '\'' +
                ", icao24='" + icao24 + '\'' +
                '}';
    }
}
