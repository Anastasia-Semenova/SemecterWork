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
            <th>first name</th>
            <th>last name</th>
            <th>information</th>
            <th>free date</th>
        </tr>
        <#list masterList as master>
            <tr>
                <td>${master.id}</td>
                <td>
                    <form method="get" action="/profile/${master.id}">
                        <a href="/profile/${master.id}">${master.firstName}</a>
                    </form>
                </td>
                <td><#if master.lastName??>${master.lastName}</#if></td>
                <td>information</td>
                <td>

                </td>
                <td>
                    <form method="post" action="/schedule/${master.id}">
                        <select name="date">
                            <#list masterDateList as freeDate>
                                <#if freeDate.masterId = master.id>
                                <option value="${freeDate.time?string["dd.MM.yyyy, HH:mm:ss.SSS"]}">${freeDate.time?string["dd.MM.yyyy, HH:mm:ss.SSS"]}</option>
                                </#if>
                            </#list>
                        </select>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
                        <input type="submit" class="btn btn-danger" value="make an appointment">
                    </form>
                </td>
            </tr>
        </#list>
    </table>

</div>
</body>
</html>
