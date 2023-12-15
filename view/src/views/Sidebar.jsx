import React from 'react';
import { Link } from 'react-router-dom';
import './styles/SidebarView.css';

const SidebarView = ({ user }) => {
    return (
        <div className="sidebar">
            <div className="sidebar-header">
                <h2>Kryptonite</h2>
            </div>
            <Link to="/" className="nav-link">
                Main Page
            </Link>

            <a href="https://kryptonite.uksouth.cloudapp.azure.com/api/swagger-ui/index.html#/" className="nav-link" target="_blank" rel="noopener noreferrer">

                Swagger API
            </a>
            {user && user.userRole === 'ADMINISTRATOR' && (
                <Link to="/users" className="nav-link">
                    View All Users
                </Link>
            )}
            <a href="https://www.google.com" className="nav-link" target="_blank" rel="noopener noreferrer">
                Monitoring
            </a>
        </div>
    );
};

export default SidebarView;
