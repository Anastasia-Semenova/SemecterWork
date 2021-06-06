<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Admin</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>email</th>
            <th>state</th>
            <th>BAN</th>
        </tr>
        <#list usersList as user>
            <tr>
                <td>${user.id}</td>
                <td>${user.login}</td>
                <td>${user.state}</td>
                <td>
                    <#if user.state!="BANNED">
                        <form method="post" action="/ban/${user.id}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input type="submit" class="btn btn-danger" value="BAN">
                        </form>
                    <#else>
                        <form method="post" action="/unban/${user.id}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input type="submit" class="btn btn-danger" value="UNBAN">
                        </form>
                    </#if>
                </td>
            </tr>
        </#list>
    </table>

</div>
</body>
</html>

