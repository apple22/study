import React from "react";
import {Link} from "react-router-dom";
import "../component/Navigation.css";



function Navigation(){
    return (
    <div className="sul_div">
        <Link className="sul" to="/">Home</Link>
        <Link to="/about">About</Link>
        
    </div>
    );
}

export default Navigation;