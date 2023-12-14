// components/TopNavbarView.jsx

import React from 'react';
import useAuth from '../utils/useAuth';

const TopNavbarView = ({ onLoginClick, onSignUpClick}) => {
    const { isLoggedIn, user } = useAuth();

    return (
        <nav className="navbar navbar-expand navbar-light bg-light">
            <div className="container-fluid">
                {/* Other elements */}
                <div className="d-flex">
                    {!isLoggedIn ? (
                        <>
                            <button className="btn btn-outline-primary me-2" onClick={onLoginClick}>LogIn</button>
                            <button className="btn btn-primary" onClick={onSignUpClick}>SignUp</button>
                        </>
                    ) : (
                        <>
                            <button className="btn btn-outline-secondary me-2">Add Map Point</button>
                            <button className="btn btn-outline-secondary me-2" type="button">Edit Map Point</button>
                            <button className="btn btn-outline-secondary me-2" type="button">View All Points</button>
                            <span className="navbar-text">
                                {`Welcome, ${user ? user.username : 'User'}`}
                            </span>
                        </>
                    )}
                </div>
            </div>
        </nav>
    );
};

export default TopNavbarView;
