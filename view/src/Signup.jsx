import React from 'react';

function Signup() {
    return (
        <div className="Signup">
            <form>
                <label for="firstname">First name:</label>
                <input type='text' id='firstname' />
                <label for="lastname">Last name:</label>
                <input type='text' id='lastname' />
                <label for="usernamename">Username:</label>
                <input type='text' id='username' />
                <label for="password">password:</label>
                <input type='password' id='password' />
                <input type="submit" value="Submit" />
            </form>
        </div>
    );
}

export default Signup;