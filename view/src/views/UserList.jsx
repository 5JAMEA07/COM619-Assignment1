import React, { useState, useEffect } from 'react';
import axios from 'axios';
import useAuth from "../utils/useAuth.js";

const UsersList = () => {
    const [users, setUsers] = useState([]);
    const [error, setError] = useState('');
    const { userToken, user } = useAuth();

    useEffect(() => {
        const fetchUsers = async () => {
            const data = {
                username: user.username
            };

            try {
                const config = {
                    headers: { Authorization: `Bearer ${userToken}` }
                };

                // Using POST instead of GET
                const response = await axios.post('backend-container:8080/api/allUsers', data, config);
                setUsers(response.data);
            } catch (err) {
                setError('Error fetching users');
                console.error(err);
            }
        };

        fetchUsers();
    }, [userToken, user.username]); // Added dependencies to useEffect

    if (error) {
        return <div>{error}</div>;
    }

    return (
        <div>
            <h2>All Users</h2>
            <ul>
                {users.map(user => (
                    <li key={user.id}>{user.username} - {user.userRole}</li>
                ))}
            </ul>
        </div>
    );
};

export default UsersList;
