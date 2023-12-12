import react from 'react'

function Login() {
    document.getElementById('loginButton').addEventListener("click", async e => {
        const username = document.getElementById('username')
        const password = document.getElementById('password')

        const response = await fetch('/login', {
            method: 'POST',
            body: username, password
        });
    });
    return(
        <div className="loginForm">
            <form>
                <label htmlFor="username">Username:</label>
                <input type='text' id='username' />
                <label htmlFor="password">Password:</label>
                <input type='password' id='password' />
                <input id='loginButton' type="submit" value="Submit" />
            </form>
        </div>
    )
}

export default Login;