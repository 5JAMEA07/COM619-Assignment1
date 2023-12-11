import react from 'react'

function Login() {
    return(
        <div className="loginForm">
            <form>
                <label for="username">Username:</label>
                <input type='text' id='username' />
                <label for="password">Password:</label>
                <input type='password' id='password' />
                <input type="submit" value="Submit" />
            </form>
        </div>
    )
}

export default loginForm;