import React from 'react';
import { MapContainer, TileLayer, Marker, Popup } from 'react-leaflet';
import { useMapEvents } from 'react-leaflet';

const MapEvents = ({ onMapClick }) => {
    useMapEvents({
        click(e) {
            onMapClick(e.latlng.lat, e.latlng.lng);
        }
    });
    return null;
};

const MapView = ({ positions, position, onMapClick }) => (
    <MapContainer center={position} zoom={13} style={{ height: '80vh' }}>
        <TileLayer
            url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"
            attribution='&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
        />
        {positions.map((point, index) => (
            <Marker key={index} position={[point.latitude, point.longitude]}>
                <Popup>
                    {point.name}<br/>{point.description}
                </Popup>
            </Marker>
        ))}
        <MapEvents onMapClick={onMapClick} />
    </MapContainer>
);

export default MapView;
