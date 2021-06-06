<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>My appointments</title>
</head>
<body>
<div>
    <table>
        <tr>
            <th>userId</th>
            <th>Date</th>
        </tr>
        <#if appointments??>
            <#list appointments as appointment>
                <tr>
                    <td>
                        ${appointment.userId}
                    </td>
                    <td>
                        ${appointment.time}
                    </td>
                </tr>
            </#list>
        </#if>
    </table>

</div>
</body>
</html>
