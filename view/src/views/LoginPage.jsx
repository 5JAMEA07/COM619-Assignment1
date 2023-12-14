import React, { useState } from 'react';
import axios from 'axios';
import './styles/LoginPage.css';

const LoginPage = ({ onLoginSuccess, onLoginFail }) => {

    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');

    const handleLoginClick = async () => {
        const loginDetails = {
            username: username,
            password: password
        };

        try {
            const response = await axios.post("/api/login", loginDetails);
            // If successful, save the token and user data to session storage
            sessionStorage.setItem('authToken', response.data.token);
            sessionStorage.setItem('user', JSON.stringify(response.data.user));
            onLoginSuccess(response.data); // Execute the callback function passed from the parent component
        } catch (error) {
            // Handle errors
            if (error.response && error.response.status === 400) {
                setErrorMessage('Invalid login credentials. Please try again.');
            } else {
                setErrorMessage('An error occurred. Please try again later.');
            }
            onLoginFail(); // Execute the callback function passed from the parent component
        }
    };

    return (
        <div className="login-container">
            <div className="login-form">
                <h2>Log In</h2>
                {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}
                <input
                    type="text"
                    placeholder="Username"
                    value={username}
                    onChange={(e) => setUsername(e.target.value)}
                />
                <input
                    type="password"
                    placeholder="Password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                />
                <button onClick={handleLoginClick}>Log In</button>
            </div>
        </div>
    );
};

export default LoginPage;
