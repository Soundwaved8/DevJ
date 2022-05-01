import React from 'react';
import {useState, useEffect} from 'react';
import axios from 'axios'
import Tracker from './Tracker';
import './Tracker.css'


function Data(){

    const [flight, setFlight] = useState([])
    const [search, setSearch] = useState('')

    useEffect(()=>{
        axios.get("http://localhost:8080/flight")
            .then(res =>{
                setFlight(res.data)
            })
            .catch(err =>{
                console.log(err)
            })
    }, [])

    const Search = e => {
        setSearch(e.target.value)
    }

    const filteredAirplanes = flight.filter(fl => 
            fl.hex.toLowerCase().includes(search.toLowerCase())
        )
    return(
        <div className="flght-app">
            <div className="flight-search">
                <h1 className="text">Search an airplane</h1>
                <form>
                    <input type="text" placeholder='Search' className="tracker-input"
                    onChange={Search}></input>
                </form>
            </div>
            {filteredAirplanes.map(flights =>{
                return(
                    <Tracker 
                    hex={flights.hex}
                    dep_icao={flights.dep_icao}
                    arr_icao={flights.arr_icao}
                    status={flights.status}
                    />
                )
            })}
        </div>
    )
}
export default Data;