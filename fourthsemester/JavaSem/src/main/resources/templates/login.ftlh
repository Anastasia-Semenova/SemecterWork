<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Login</title>

    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/common.css" rel="stylesheet">

</head>

<body>
<div class="container">
    <form name="login" method="post" id="userForm" class="form-signin" action="/login">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
        <label for="login">Login</label>
        <input name="login" id="login" placeholder="Login" class="form-control">
        <label for="password">Password</label>
        <input name="password" id="password" type="password" placeholder="Password" class="form-control">
        <label>
            <input type="checkbox" name="remember-me"> Запомнить меня
        </label>
        <button>Send</button>
    </form>
</div>
</body>
</html>
