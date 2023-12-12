import react from 'react'
import Navbar from "./navbar.jsx";

function Login() {
    document.getElementById('loginButton').addEventListener("click", async e => {
        const username = document.getElementById('username')
        const password = document.getElementById('password')

        const response = await fetch('/api/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                username,
                password,
            })
        })
        sessionStorage.setItem('token', response.token);
        sessionStorage.setItem('user', response.user);
    })
    return(
        <div>
            <Navbar />
        <div className="loginForm">
            <form>
                <label htmlFor="username">Username:</label>
                <input type='text' id='username' />
                <label htmlFor="password">Password:</label>
                <input type='password' id='password' />
                <input id='loginButton' type="submit" value="Submit" />
            </form>
        </div>
        </div>
    )
}

export default Login;