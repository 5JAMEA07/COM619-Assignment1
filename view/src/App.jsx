import React, { useState } from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import MapController from './controllers/mapController';
import SidebarView from './views/Sidebar';
import TopNavbarView from './views/TopNavBar';
import LoginPage from './views/LoginPage';
import SignUpPage from './views/SignupPage';
import MapPointForm from './views/MapPointForm';
import UsersList from './views/UserList';
import 'leaflet/dist/leaflet.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import useAuth from './utils/useAuth';

const App = () => {
    const [mapPoint, setMapPoint] = useState({ latitude: null, longitude: null });
    const [showMapPointForm, setShowMapPointForm] = useState(false);
    const [showLoginPage, setShowLoginPage] = useState(false);
    const [showSignupPage, setShowSignupPage] = useState(false);
    const [mapPoints, setMapPoints] = useState([]);
    const { isLoggedIn, user } = useAuth();

    const handleMapPointSubmit = (data) => {
        setMapPoints(prevPoints => [...prevPoints, {
            latitude: data.latitude,
            longitude: data.longitude,
            name: data.name,
            description: data.description
        }]);
        alert('Map point uploaded successfully');
        setShowMapPointForm(false);
    };

    const handleMapPointClick = (lat, lng) => {
        if (isLoggedIn) {
            setMapPoint({ latitude: lat, longitude: lng });
            setShowMapPointForm(true);
        }
    };

    const handleLoginSuccess = () => {
        setShowLoginPage(false);
    };

    const handleLoginFail = () => {
        setShowLoginPage(false); // Close login form on fail
    };

    const handleLoginClick = () => {
        setShowLoginPage(true);
        setShowSignupPage(false); // Close signup form when opening login form
    };

    const handleSignUpClick = () => {
        setShowSignupPage(true);
        setShowLoginPage(false); // Close login form when opening signup form
    };

    const handleSignUpSuccess = () => {
        setShowSignupPage(false);
    };

    const handleSignUpFail = () => {
        setShowSignupPage(false); // Close signup form on fail
    };

    return (
        <Router>
            <TopNavbarView
                onLoginClick={handleLoginClick}
                onSignUpClick={handleSignUpClick}
                isLoggedIn={isLoggedIn}
            />
            <div className="d-flex" id="content-wrapper">
                <SidebarView user={user} />
                <div className="main-content">
                    <Routes>
                        <Route path="/users" element={<UsersList />} />
                        <Route path="/" element={
                            <>
                                <MapController mapPoints={mapPoints} onMapPointClick={handleMapPointClick} />
                                {isLoggedIn && showMapPointForm && (
                                    <MapPointForm
                                        latitude={mapPoint.latitude}
                                        longitude={mapPoint.longitude}
                                        handleMapPointSubmit={handleMapPointSubmit}
                                    />
                                )}
                            </>
                        } />
                    </Routes>
                    {showLoginPage && (
                        <div className="login-overlay">
                            <LoginPage onLoginSuccess={handleLoginSuccess} onLoginFail={handleLoginFail} />
                        </div>
                    )}
                    {showSignupPage && (
                        <div className="signup-overlay">
                            <SignUpPage onSignUpSuccess={handleSignUpSuccess} onSignUpFail={handleSignUpFail} />
                        </div>
                    )}
                </div>
            </div>
        </Router>
    );
};

export default App;