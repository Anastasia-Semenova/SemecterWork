<!doctype html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Registration</title>

    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/common.css" rel="stylesheet">

</head>

<body>
<form name="registration" method="post" id="userForm" class="form-signin" enctype="multipart/form-data" action="/registration">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
    <label for="firstName">First Name</label>
    <input name="firstName" id="firstName" placeholder="First Name" class="form-control">
    <label for="login">Login</label>
    <input name="login" id="login" placeholder="Login" class="form-control">
    <label for="image">Login</label>
    <input class="form-control" type="file" name="image" accept="image/png, image/jpeg" placeholder="Выберите файл"/>
    <label for="hashPassword">Password</label>
    <input name="password" id="hashPassword" type="password" placeholder="Password" class="form-control">
    <label for="confirmPassword">Confirm Password</label>
    <input name="confirmPassword" id="confirmPassword" type="password" placeholder="Repeat Password"
           class="form-control">

    <input type="submit">Send</input>
</form>
</body>
</html>

