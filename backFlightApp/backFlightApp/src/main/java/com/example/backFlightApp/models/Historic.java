package com.example.backFlightApp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "historic")
public class Historic {

    @Id
    @Column(name = "id_historic")
    private UUID id_historic;
    @Column(name = "id_flight")
    private String hex;
    private String date;
    private int speed;
    private Float latitude;
    private Float longitude;

    public Historic(){

    }

    public Historic(UUID id_historic, String hex, String date, int speed, Float latitude, Float longitude){
        this.id_historic = id_historic;
        this.hex = hex;
        this.date = date;
        this.speed = speed;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public UUID getId_historic() {
        return id_historic;
    }

    public void setId_historic(UUID id_historic) {
        this.id_historic = id_historic;
    }

    public String getHex() {
        return hex;
    }

    public void setHex(String hex) {
        this.hex = hex;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "HistoricPlane{" +
                "id_historic=" + id_historic +
                ", hex='" + hex + '\'' +
                ", date='" + date + '\'' +
                ", speed=" + speed +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
