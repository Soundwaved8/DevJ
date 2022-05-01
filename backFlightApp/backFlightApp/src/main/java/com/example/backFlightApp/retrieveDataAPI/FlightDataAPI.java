package com.example.backFlightApp.retrieveDataAPI;


import com.example.backFlightApp.models.Flight;
import com.example.backFlightApp.models.Historic;
import com.example.backFlightApp.models.Plane;
import com.example.backFlightApp.services.FlightService;
import com.example.backFlightApp.services.HistoricPlaneService;
import com.example.backFlightApp.services.PlaneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Component
public class FlightDataAPI {

    @Autowired
    PlaneService planeService;
    @Autowired
    FlightService flightService;
    @Autowired
    HistoricPlaneService historicPlaneService;

    private static HttpURLConnection connection;

    @Scheduled(fixedDelay = 3600000)
    public void getFilghtsDatasFromAPI(){
        BufferedReader reader;
        String line;
        StringBuilder builder =  new StringBuilder();
        //String keyCode = "7353fa0a-8f9a-4db6-80fa-336a0902534a";
        try{
            URL url = new URL("https://airlabs.co/api/v9/flights?api_key=7353fa0a-8f9a-4db6-80fa-336a0902534a");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(60000);
            connection.setReadTimeout(60000);
            int status =  connection.getResponseCode();
            if(status > 299){
                reader =  new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while((line = reader .readLine()) != null){
                    builder.append(line);
                }
                reader.close();
            }else{
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while((line = reader.readLine()) != null){
                    builder.append(line);
                }
                reader.close();
            }
            // fonction parse
            parseData(builder.toString());
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            connection.disconnect();
        }
    }

    public void parseData(String response) {
        List<Plane> listPlanes = new ArrayList<>();
        List<Flight> listFlights = new ArrayList<>();
        List<Historic> listHistoricPlanes = new ArrayList<>();
        JSONObject jsonData =  new JSONObject(response);
        JSONArray flights =  new JSONArray(jsonData.getJSONArray("response"));
        DateTimeFormatter gestiondate = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        LocalDate ld = LocalDate.now();

        for(int i = 0; i < flights.length(); i++){
            JSONObject flight = flights.getJSONObject(i);
            String hex = getString(flight, "hex", null);
            UUID id_historic = UUID.randomUUID();
            String model_plane = getString(flight, "reg_number", null);
            String icao24 = getString(flight, "flight_icao", flight.getString("hex"));
            String date = gestiondate.format(ld);
            int speed = flight.getInt("speed");
            Float latitude = flight.getFloat("lat");
            Float longitude = flight.getFloat("lng");
            String departure_airport = getString(flight, "dep_icao", null);
            String arrival_airport = getString(flight, "arr_icao", null);
            String status = flight.getString("status");
            String flight_number = getString(flight, "flight_number", null);

            // nous associons chaque champs ou attributs à sa table et classe correspondante
            Plane planeObject = new Plane(hex, icao24, model_plane);
            listPlanes.add(planeObject);
            Flight FLightObject = new Flight(hex, flight_number, status, departure_airport, arrival_airport, icao24);
            listFlights.add(FLightObject);
            Historic historicPlaneObject = new Historic(id_historic, hex, date, speed, latitude, longitude);
            listHistoricPlanes.add(historicPlaneObject);
        }

        // gestion du temps d'insertion des données dans les tables respectives
        LocalTime start = LocalTime.now();
        LocalTime end = LocalTime.now();
        System.out.println("starting insert datas to BDD  at " + start);

        flightService.insertAllFlights(listFlights);
        System.out.println("insert all flights into table in " + (end.getMinute() - start.getMinute()) + " minutes " + (end.getMinute() - start.getMinute()) + " secondes ");

        planeService.insertAllPlanes(listPlanes);
        System.out.println("insert all planes into table in " + (end.getMinute() - start.getMinute()) + " minutes " + (end.getMinute() - start.getMinute()) + " secondes ");

        historicPlaneService.insertAllPlaneHistoric(listHistoricPlanes);
        System.out.println("insert all historic planes into table in " + (end.getMinute() - start.getMinute()) + " minutes " + (end.getMinute() - start.getMinute()) + " secondes ");

        System.out.println("Ending Save" + end);
        System.out.println("This task spend : " + (end.getMinute() - start.getMinute()) + "minutes" + (end.getSecond() - start.getSecond()) + "seconds");

    }

    // fonction getString qui permet de palier un cas de string null
    public static String getString(JSONObject data, String key, String defaultValue){
        try{
            return data.getString(key);
        }catch (Exception e){
            return defaultValue;
        }
    }
}
