import React from "react";
import { Link } from "react-router-dom";

function Navbar() {

    return (
            <ul id='navigation'>
                <li>
                    <Link to="/main.jsx">Home</Link>
                </li>
                <li>
                    <Link to="/contact.jsx">Contact</Link>
                </li>
                <li>
                    <Link to="/about.jsx">About</Link>
                </li>
                <li style="float:right">
                    <Link to="./login.jsx">Login / </Link>
                </li>
                <li style="float:right">
                    <Link to="./Signup.jsx">Signup / </Link>
                </li>
                <li style="float:right">
                    <Link to="./Signout.jsx">Signout</Link>
                </li>
            </ul>
    )
}

export default Navbar;