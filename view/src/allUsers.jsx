import react from 'react'
import App from "./App.jsx";
import Navbar from "./navbar.jsx";
import React, { useState, useEffect } from 'react';

const allUsers = () => {
    const [allUsers, setAllUsers] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            try {
                const token = sessionStorage.getItem('token')

                const response = await fetch('api/allUsers', {
                    method: 'GET',
                    headers: {
                        "Authorization": `Bearer ${sessionStorage.getItem('token')}`
                    }
                });

                const data = await response.json();
                setAllUsers(data);
            } catch (error) {
                console.error('Error getting users', error);
            }
        }
        fetchData();
    }, []);

    return (
        <div>
            <Navbar />
            <h1>
                Users
            </h1>
            <table>
                <thread>
                    <tr>
                        <th>First name</th>
                        <th>Second name</th>
                        <th>Username</th>
                        <th>Address</th>
                        <th>Role</th>
                    </tr>
                </thread>
                <tbody>
                {allUsers.map((user, index) => (
                    <tr key={index}>
                        <td>{user.firstName}</td>
                        <td>{user.secondName}</td>
                        <td>{user.username}</td>
                        <td>{user.address}</td>
                        <td>{user.role}</td>
                    </tr>
                ))}
                </tbody>
            </table>
        </div>
    );
};

export default allUsers();