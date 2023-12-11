import React from 'react';

function App() {
    const map = L.map ("map1");

    const attrib="Map data copyright OpenStreetMap contributors, Open Database Licence";

    L.tileLayer
    ("https://%7Bs%7D.tile.openstreetmap.org/%7Bz%7D/%7Bx%7D/%7By%7D.png",
        { attribution: attrib } ).addTo(map);

    map.setView([1,1], 14);
    return (
        <div id="map1" style="width:800px; height:600px"> </div>
    );
}

export default App;