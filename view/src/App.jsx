import React from 'react';

function App() {
    const map = L.map("map1");

    const attrib = "Map data copyright OpenStreetMap contributors, Open Database Licence";

    L.tileLayer
    ("https://%7Bs%7D.tile.openstreetmap.org/%7Bz%7D/%7Bx%7D/%7By%7D.png",
        {attribution: attrib}).addTo(map);

    map.setView([1, 1], 14);

    map.on("click", async (e) => {
        const lat = e.latlng.lat;
        const lon = e.latlng.lon;
        const name = prompt("Name");
        const username = prompt("Username");
        const description = prompt("Description");
        const image = prompt("image link");

        const response = await fetch('/upload', {
            method: 'POST',
            body: lat, lon, image, username, name, description
        });
        return (

        <div id="map1" style="width:800px; height:600px"></div>
    )
        ;
    });
}

export default App;