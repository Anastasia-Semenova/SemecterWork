<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <title>Profile</title>
</head>


<style>
    tbody {
        display: flex;
    }

    tr {
        display: flex;
        flex-direction: column;
        flex-wrap: wrap;
    }
</style>
<body>
<form name="profile" method="get" id="userForm" class="form-profile" action="/profile">
    <table>
        <tbody>
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Login</td>
            <td>Email</td>
            <#if user.role==role_user>
                <td>My appointments</td>
                <td>Liked masters</td>
            <#elseif user.role==role_master>
                <td>Position</td>
                <td>Information</td>
                <td>Favourite by</td>
                <td>My appointments</td>
            </#if>

        </tr>
        <#if user.image??>
        <img src="/media?name=${user.image}" width="100" height="111">
        </#if>
        <tr>
            <td>
                <#if user.firstName??>
                    ${user.firstName}
                </#if>
            </td>
            <td>
                <#if user.lastName??>
                    ${user.lastName}
                </#if>
            </td>
            <td>
                <#if user.login??>
                    ${user.login}
                </#if>
            </td>
            <td>
                <#if user.email??>
                    ${user.email}
                </#if>
            </td>
            <#if user.role==role_user>
                <td>My appointments</td>
                <td><a href="/favouritesMasters">Liked masters</a></td>
            </#if>
            <#if user.role==role_master>
                <td><#if master.position??>${master.position}</#if></td>
                <td><#if master.information??>${master.information}</#if></td>
                <td><#if liked??>${liked}</#if></td>
                <td>
                    <form method="get" action="/myAppointments">
                        <a href="/myAppointments">My appointments</a>
                    </form>
                </td>
            </#if>
        </tr>
        <tr>
            <td>
                <form></form>
            </td>
            <td>
                <form method="get" action="/changeFirstName">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-danger" value="Change">
                </form>
            </td>
            <td>
                <form method="get" action="/changeLastName">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-danger" value="Change">
                </form>
            </td>
            <td>
                <form method="get" action="/changeEmail">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" class="btn btn-danger" value="Change">
                </form>
            </td>
        </tr>
        </tbody>

    </table>
</form>
    <a href="/logout">Log out</a>
</body>
</html>
