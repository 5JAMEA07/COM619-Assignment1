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
                {mapPoints.map((point, index) => (
                    <tr key={index}>
                        <td>{point.name}</td>
                        <td>{point.latitude}</td>
                        <td>{point.longitude}</td>
                        <td>{point.description}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
    };

export default viewMapPoints();