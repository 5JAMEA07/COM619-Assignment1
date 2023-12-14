import React, { useState } from 'react';
import useMapModel from "../models/useMapModel";
import MapView from '../views/MapView';
import MapPointForm from '../views/MapPointForm.jsx';
const MapController = ({ mapPoints }) => {
    const { positions, addPosition } = useMapModel();
    const [position, setPosition] = useState([51.0, -0.09]); // Default position
    const [showForm, setShowForm] = useState(false);
    const [clickedCoords, setClickedCoords] = useState(null);

    const handleMapClick = (lat, lng) => {
        setClickedCoords({ latitude: lat, longitude: lng });
        setShowForm(true);
    };


    return (
        <>
            <MapView
                positions={mapPoints}
                position={position}
                onMapClick={handleMapClick}
            />
            {showForm && (
                <MapPointForm
                    latitude={clickedCoords.latitude}
                    longitude={clickedCoords.longitude}
                />
            )}
        </>
    );
};

export default MapController;
