import React from 'react';
import { useNavigate } from 'react-router-dom';

function Signout() {
    sessionStorage.clear();
    let navigate = useNavigate();
    navigate('/main.jsx');

}

export default Signout;