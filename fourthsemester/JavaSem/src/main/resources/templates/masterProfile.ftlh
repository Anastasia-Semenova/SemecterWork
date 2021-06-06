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
<form name="profile" method="get" id="userForm" class="form-profile" action="/profile/${user.id}">
    <table>
        <tbody>
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Login</td>
            <td>Email</td>

            <td>Position</td>
            <td>Information</td>
            <td>Favourite by</td>
            <td>Add to favourites</td>
        </tr>
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

            <td><#if master.position??>${master.position}</#if></td>
            <td><#if master.information??>${master.information}</#if></td>
            <td><#if liked??>${liked}</#if></td>
            <td>
                <form method="post" action="/addToFavourites/${master.id}">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                    <input type="submit" value="Add to favourites">
                </form>
            </td>
        </tr>

        </tbody>

    </table>
</form>
</body>
</html>
