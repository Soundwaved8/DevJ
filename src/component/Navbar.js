import React from 'react'
import './Navbar.css';
import * as Icons from 'react-icons/fa';
import {Navitems} from './Navitems';
import Button from './Button';

function Navbar(){
    return(
        <div className="navbar">
            <a href="/acceuil" className="navbar-logo">
                TRACKER PLANE
                <Icons.FaPlane></Icons.FaPlane>
            </a>
            <ul className="nav-items">
                {Navitems.map(item =>{
                    return(
                        <li key={item.id} className={item.className}>
                            <a href={item.path}>{item.title}</a>
                        </li>
                    );
                })}
            </ul>
            <Button/>
        </div>
    )
}
export default Navbar;