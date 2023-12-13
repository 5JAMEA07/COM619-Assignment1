import React from 'react';
async function PoiList() {
    const [results, setResults] = React.useState([]);
    const username = sessionStorage.getItem('user.username');

    React.useEffect( () => {
        fetch(`/api/getAllMapPointsForUser`,{
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                username
        })

    })
            .then(setResults);
    })
    //modify above code to get POI's if endpoint is added
    //modify below form action to edit POI once endpoint is added

    const PoisHtml = results.map(Poi => <form action='/api/updateMapPointWithImage' method="POST"> <li key={Poi.id}><input type="hidden" id="say" value={Poi.id} /> <input type="text" id="name" value={Poi.id}/>, <input type="text" id="description" value={Poi.description}/>, <input type="text" id="lat" value={Poi.lat}/>, <input type="text" id="lng" value={Poi.lng}/>, <input value = {Poi.PhotoUrl} type="file" id="img" name="img" accept="image/*"/> <input type="submit" value="Submit"/></li> </>);


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