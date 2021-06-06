<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Masters</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>id</th>
            <th>Delete</th>
        </tr>
        <#if favouriteMasterList??>
            <#list favouriteMasterList as master>
                <tr>
                    <td>
                        <form method="get" action="/profile/${master.getMaster().user.id}">
                            <a href="/profile/${master.getMaster().user.id}">${master.getMaster().user.id}</a>
                        </form>
                    </td>

                    <td>
                        <form method="post" action="/delete/${master.id}">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                            <input type="submit" class="btn btn-danger" value="delete from favourites">
                        </form>
                    </td>
                </tr>
            </#list>
        </#if>
    </table>

</div>
</body>
</html>
