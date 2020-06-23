<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Login Here!</title>
        <style><%@include file = "/WEB-INF/css/style.css"%></style>
    </head>
    <body>
        <div class="container">
            <h3 class="label">User Login</h3>
            <form class="login_form" action="LoginPage" name="form" method="post" onsubmit="return validated()">
                <div class="font">User Name</div>
                <input autocomplete="off" type="text" name="username">
                <div id="username_error">Please enter username</div>
                <div class="font font2">Password</div>
                <input type="password" name="password">
                <div id="pass_error">Please enter password</div>
                <button type="submit">Login</button>

            </form>

        </div>
        <script src="valid.js"></script>
    </body>
</html>