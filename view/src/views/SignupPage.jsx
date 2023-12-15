// components/SignUpPage.jsx
import React, { useState } from 'react';
import axios from 'axios';
import './styles/SignupPage.css'; // Ensure this path is correct

const SignUpPage = ({ onSignUpSuccess, onSignUpFail }) => {
    const [formData, setFormData] = useState({
        username: '',
        password: '',
        retypePassword: '',
        firstName: '',
        lastName: '',
        address: {
            houseNumber: '',
            addressLine1: '',
            addressLine2: '',
            county: '',
            city: '',
            postcode: '',
            mobilePhoneNumber: '',
            country: ''
        }
    });
    const [errorMessage, setErrorMessage] = useState('');

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            [name]: value
        }));
    };

    const handleAddressChange = (e) => {
        const { name, value } = e.target;
        setFormData(prevState => ({
            ...prevState,
            address: {
                ...prevState.address,
                [name]: value
            }
        }));
    };

    const handleSignUpClick = async () => {
        if (formData.password !== formData.retypePassword) {
            setErrorMessage("Passwords do not match.");
            return;
        }

        try {
            const response = await axios.post('http://localhost:8080/api/signup', formData);
            // On successful signup, store the token and user data
            sessionStorage.setItem('authToken', response.data.token);
            sessionStorage.setItem('user', JSON.stringify(response.data.user));
            onSignUpSuccess(); // Call the onSignUpSuccess passed from the parent component
        } catch (error) {
            if (error.response && error.response.status === 400) {
                setErrorMessage(error.response.data || "Error during registration.");
            } else {
                setErrorMessage('An error occurred during signup. Please try again later.');
            }

            onSignUpFail(); // Call the onSignUpFail passed from the parent component
        }
    };

    return (
        <div className="signup-container">
            <div className="signup-form">
                <h2>Sign Up</h2>
                {errorMessage && <div className="alert alert-danger">{errorMessage}</div>}

                <input type="text" placeholder="Username" name="username" value={formData.username} onChange={handleChange} />
                <input type="password" placeholder="Password" name="password" value={formData.password} onChange={handleChange} />
                <input type="password" placeholder="Retype Password" name="retypePassword" value={formData.retypePassword} onChange={handleChange} />
                <input type="text" placeholder="First Name" name="firstName" value={formData.firstName} onChange={handleChange} />
                <input type="text" placeholder="Last Name" name="lastName" value={formData.lastName} onChange={handleChange} />

                {/* Address Inputs */}
                <input type="text" placeholder="House Number" name="houseNumber" value={formData.address.houseNumber} onChange={handleAddressChange} />
                <input type="text" placeholder="Address Line 1" name="addressLine1" value={formData.address.addressLine1} onChange={handleAddressChange} />
                <input type="text" placeholder="Address Line 2" name="addressLine2" value={formData.address.addressLine2} onChange={handleAddressChange} />
                <input type="text" placeholder="County" name="county" value={formData.address.county} onChange={handleAddressChange} />
                <input type="text" placeholder="City" name="city" value={formData.address.city} onChange={handleAddressChange} />
                <input type="text" placeholder="Postcode" name="postcode" value={formData.address.postcode} onChange={handleAddressChange} />
                <input type="text" placeholder="Mobile Phone Number" name="mobilePhoneNumber" value={formData.address.mobilePhoneNumber} onChange={handleAddressChange} />
                <input type="text" placeholder="Country" name="country" value={formData.address.country} onChange={handleAddressChange} />

                <button onClick={handleSignUpClick}>Sign Up</button>
            </div>
        </div>
    );
};

export default SignUpPage;