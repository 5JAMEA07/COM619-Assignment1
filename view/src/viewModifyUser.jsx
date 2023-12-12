import react from 'react'
import Navbar from "./navbar.jsx";

function ModifyUser() {

    return (
        <div>
        <Navbar />
        <form action="" method="POST">
        <table class="table">
            <thread>
                <tbody>
                <tr>
                    <td>User ID</td>
                    <td>${sessionStorage.getItem('user.id')}</td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td>${sessionStorage.getItem('user.username')}</td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value=${sessionStorage.getItem('user.firstName')}/></td>
                </tr>
                <tr>
                    <td>Second Name</td>
                    <td><input type="text" name="firstName" value=${sessionStorage.getItem('user.secondName')}/></td>
                </tr>
                <tr>
                    <td>House Number</td>
                    <td><input type="text" name="firstName" value=${sessionStorage.getItem('user.address.houseNumber')}/></td>
                </tr>
                <tr>
                    <td>Address Line 1</td>
                    <td><input type="text" name="addressLine1" value=${sessionStorage.getItem('user.address.addressLine1')}/></td>
                </tr>
                <tr>
                    <td>Address Line 2</td>
                    <td><input type="text" name="addressLine2" value=${sessionStorage.getItem('user.address.addressLine2')}/></td>
                </tr>
                <tr>
                    <td>city</td>
                    <td><input type="text" name="county" value=${sessionStorage.getItem('user.address.city')}/></td>
                </tr>
                <tr>
                    <td>county</td>
                    <td><input type="text" name="county" value=${sessionStorage.getItem('user.address.county')}/></td>
                </tr>
                <tr>
                    <td>country</td>
                    <td><input type="text" name="country" value=${sessionStorage.getItem('user.address.country')}/></td>
                </tr>
                <tr>
                    <td>postcode</td>
                    <td><input type="text" name="postcode" value=${sessionStorage.getItem('user.address.postcode')}/></td>
                </tr>
                <tr>
                    <td>telephone</td>
                    <td><input type="text" name="telephone" value=${sessionStorage.getItem('user.address.telephone')}/></td>
                </tr>
                <tr>
                    <td>mobile</td>
                    <td><input type="text" name="mobile" value=${sessionStorage.getItem('user.address.mobile')}/></td>
                </tr>
                </tbody>
            </thread>
        </table>

        <c:if test=${sessionStorage.getItem('user.userRole') !='ADMINISTRATOR'}>
            <p>User Status and role</p>
            <table class="table">
                <thread>
                    <tbody>
                    <tr>
                        <td>Role</td>
                        <td>${sessionStorage.getItem('user.userRole')}</td>
                    </tr>
                    <tr>
                        <td>enabled</td>
                        <td><c:if test=${sessionStorage.getItem('user.enabled')}>ENABLED</c:if><c:if test=${!sessionStorage.getItem('user.enabled')}>DISABLED</c:if></td>
                    </tr>
                    </tbody>
                </thread>
            </table>
        </c:if>

        <c:if test=${sessionStorage.getItem('user.userRole') =='ADMINISTRATOR'}>
            <p>Manage User Status and Role</p>
            <table class="table">
                <thread>
                    <tbody>
                    <tr>
                        <td>Role</td>
                        <td>
                            <select class="form-control" name="userRole" >
                                <c:forEach var="value" items=${UserRole.values()}>
                                    <option value=${value}> <c:if test=${sessionStorage.getItem('user.userRole') == value}> selected </c:if> ${value}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    </tbody>
                </thread>
            </table>
        </c:if>

        <input type="hidden" name="username" value=${sessionStorage.getItem('user.username')}/>
        <button class="btn" type="submit" >Update User ${sessionStorage.getItem('user.username')}</button>
        </form>
        <p>Update Password</p>
        <form action="" method="post">
            <input type="hidden" name="username" value=${sessionStorage.getItem('user.username')}/>
            <input type="hidden" name="action" value="updatePassword"/>
            <p>Password <input type="password" name="password" ></input></p>
            <p>Re Enter Password <input type="password" name="password2" ></input></p>
            <button class="btn" type="submit" >Update ${sessionStorage.getItem('user.username')} Password</button>
        </form>
        <c:if test=${sessionStorage.getItem('user.userRole') =='ADMINISTRATOR'}>
            <BR>
                <form action="">
                    <button class="btn" type="submit" >Return To Users</button>
                </form>
            </BR>
        </c:if>

        </div>
    )
}