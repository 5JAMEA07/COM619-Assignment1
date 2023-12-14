import { useState } from 'react';

const useMapModel = () => {
    const [positions, setPositions] = useState([]);

    const addPosition = (position, description) => {
        setPositions(prevPositions => [...prevPositions, { position, description }]);
    };

    return {
        positions,
        addPosition,
    };
};

export default useMapModel;
