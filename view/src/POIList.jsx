import React from 'react';
async function PoiList() {
    const [results, setResults] = React.useState([]);

    React.useEffect( () => {
        fetch(`/api/?`)
            .then(setResults);
    })

    //modify above code to get POI's if endpoint is added

    const PoisHtml = results.map(Poi => <li
        key={Poi.id}>{Poi.name}, {Poi.description}, {Poi.lat}, {Poi.lng}, {Poi.PhotoUrl}</li>);

    return (
        <div>

            <h1>POI's</h1>
            <ul>
                {PoisHtml}
            </ul>

        </div>
    );
}

export default PoiList;