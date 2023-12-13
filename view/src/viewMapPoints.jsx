import react from 'react'
import App from "./App.jsx";
import Navbar from "./navbar.jsx";
import React, { useState, useEffect } from 'react';

const viewMapPoints = () => {
    const [mapPoints, setMapPoints] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const username = sessionStorage.getItem('user.username');
                const token = sessionStorage.getItem('token')

                const response = await fetch('api/userMapPoints', {
                    method: 'GET',
                    headers: {
                        'Content-Type': 'application/json',
                        "Authorization": `Bearer ${sessionStorage.getItem('token')}`
                    },
                    body: JSON.stringify({
                        username
                    })
                });

            const data = await response.json();
            setMapPoints(data);
            } catch (error) {
                console.error('Error getting map points', error);
            }
        }
        fetchData();
    }, []);

    return (
        <div>
            <Navbar />
            <h1>
                Map Points
            </h1>
            <table>
                <thread>
                    <tr>
                        <th>Name</th>
                        <th>Latitude</th>
                        <th>Longitude</th>
                        <th>Description</th>
                    </tr>
                </thread>
                <tbody>
                {mapPoints.map((Poi, index) => (
                    <tr key={index}>
                        <form action='/api/updateMapPointWithImage' method="POST">
                            <input type="hidden" id="id" value={Poi.id} />
                        <td><input type="text" id="name" value={Poi.id}/></td>
                        <td><input type="text" id="description" value={Poi.description}/></td>
                        <td><input type="text" id="lat" value={Poi.latitude}/></td>
                        <td><input type="text" id="lng" value={Poi.longitude}/></td>
                        <td><input value = {Poi.PhotoUrl} type="file" id="img" name="img" accept="image/*"/></td>
                            <td><input type="submit" value="Submit"/></td>
                        </form>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
    };

export default viewMapPoints();