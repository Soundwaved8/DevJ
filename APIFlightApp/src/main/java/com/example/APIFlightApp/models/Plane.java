package com.example.APIFlightApp.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plane")
public class Plane {

    @Id
    @Column(name = "id_flight")
    private String hex;
    @Column(name = "plane_number")
    private String icao24;
    private String model_plane;

    public Plane(){

    }

    public Plane(String hex, String icao24, String model_plane){
        this.hex = hex;
        this.icao24 = icao24;
        this.model_plane = model_plane;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getIcao24() {
        return icao24;
    }

    public void setIcao24(String icao24) {
        this.icao24 = icao24;
    }

    public String getModel_plane() {
        return model_plane;
    }

    public void setModel_plane(String model_plane) {
        this.model_plane = model_plane;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "hex='" + hex + '\'' +
                ", plane_number=" + icao24 +
                ", model_plane='" + model_plane + '\'' +
                '}';
    }
}
