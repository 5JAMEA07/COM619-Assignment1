const useAuth = () => {
    const userToken = sessionStorage.getItem('authToken');
    const user = JSON.parse(sessionStorage.getItem('user'));

    const isLoggedIn = userToken !== null;

    return {
        isLoggedIn,
        userToken,
        user
    };
};

export default useAuth;
