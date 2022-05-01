import React from 'react';
import './Tracker.css'

function Tracker({hex, dep_icao, arr_icao, status}){
    return(
        <div className="trakcer-container">
            <div className="tracker-row">
                <div className="tracker">
                    <h1>{hex}</h1>
                    <p className="departure-data">{dep_icao}</p>
                    <p className="arrival-airport">{arr_icao}</p>
                    <p className="status">{status}</p>
                </div>
            </div>
        </div>
    )
}

export default Tracker;