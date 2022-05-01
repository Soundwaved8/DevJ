import React, {useState, useEffect} from 'react'
import {MapContainer, Marker, Popup, TileLayer} from 'react-leaflet';
import L from "leaflet";
import axios from 'axios';


// fonction qui permet de retourner une icone sur la ville en question
function GetIcon(_iconsize){
    return L.icon({
        iconUrl:require("./157354.png"),
        iconSize:[_iconsize]
    })
}
function AppFlights(){
    // créer des positions sur la carte pour les afficher dans la map
    // créer des données brut pour permettre de pouvoir afficher
    // une icone sur une des villes mentionnant le temps qu'il fait
    const postion = [1.35, 103.8]
   
    const locations = [
        {"name" : "west", "position":[1.35735, 103.05]},
        {"name":"ouest", "position": [1.35735, 103.94]},
    ]

    
    return(
        <MapContainer className="map"
            center={postion}
            zoom={10}
            style={{height:300, width:"100%"}}
        >
            

            <TileLayer
                attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
                url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            />
            {locations.map((location)=>(
                <Marker position={location.position} icon={GetIcon(40)}>
                    <Popup>
                        {location.name}
                    </Popup>
                </Marker>
            ))}

        </MapContainer>
    )
}
export default AppFlights;