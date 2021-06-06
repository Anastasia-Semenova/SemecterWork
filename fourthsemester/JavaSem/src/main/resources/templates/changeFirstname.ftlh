<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Change first name</title>
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
<body class="change-first-name">
<form name="changeProfile" method="get" id="userForm" class="form-profile">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <table>
        <tbody>
        <tr>
            <td>First Name</td>
            <td>Last Name</td>
            <td>Login</td>
            <td>Email</td>
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
            <td>
                <form></form>
            </td>
        </tr>
        </tbody>
    </table>
    <form name="changeFirstname" method="post" id="userForm" class="form-profile" action="/changeFirstname">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <label for="firstName">First Name</label>
        <input name="firstName" id="firstName" placeholder="First Name" class="form-control">
        <button>Send</button>
    </form>
</form>
</body>
</html>
