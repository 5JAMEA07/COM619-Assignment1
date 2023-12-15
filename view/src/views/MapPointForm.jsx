import React, { useState } from 'react';
import axios from 'axios';
import useAuth from '../utils/useAuth';
import './styles/MapPointForm.css';


const MapPointForm = ({ latitude, longitude, handleMapPointSubmit }) => {

    const [name, setName] = useState('');
    const [description, setDescription] = useState('');
    const { userToken, user } = useAuth();

    const handleSubmit = async () => {
        const data = {
            latitude,
            longitude,
            username: user.username,
            name,
            description
        };

        try {
            const response = await axios.post(`https://kryptonite.uksouth.cloudapp.azure.com/api/uploadWithoutImage`, data, {
                headers: {
                    Authorization: `Bearer ${userToken}`,
                    'Content-Type': 'application/json'
                }

            });
            handleMapPointSubmit(response.data)
        } catch (error) {
            console.error('Error uploading map point:', error);
        }
    };

    return (
        <div className="map-point-form-container">
            <input type="text" value={latitude} readOnly />
            <input type="text" value={longitude} readOnly />
            <input type="text" value={name} onChange={(e) => setName(e.target.value)} placeholder="Name of the Map Point" />
            <textarea value={description} onChange={(e) => setDescription(e.target.value)} placeholder="Description" />
            <button onClick={handleSubmit}>Submit</button>
        </div>
    );
};

export default MapPointForm;
