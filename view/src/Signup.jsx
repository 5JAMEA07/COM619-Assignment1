import React from 'react';

function Signup() {
    return (
        <div className="Signup">
            <form>
                <label htmlFor="firstname">First name:</label>
                <input type='text' id='firstname' />
                <label htmlFor="lastname">Last name:</label>
                <input type='text' id='lastname' />
                <label htmlFor="username">Username:</label>
                <input type='text' id='username' />
                <label htmlFor="password">password:</label>
                <input type='password' id='password' />
                <input type="submit" value="Submit" id="submit" />
            </form>
        </div>
    );
}

export default Signup;