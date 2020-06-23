
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Register Here!</title>
        <style><%@include file = "/WEB-INF/css/rstyle.css"%></style>
    </head>
    <body>
        <div class="container">
            <h3 class="label">New User Registration!</h3>
            <form class="register_form" action="Registration" name="form" method="post" onsubmit="return validated()">
                <div class="font">User Name</div>
                <input autocomplete="off" type="text" name="username">
                <div id="username_error">Please enter username</div>
                <div class="font font2">Password</div>
                <input type="password" name="password">
                <div id="pass_error">Please enter minimum 8 characters</div>
                <div class="font font2">Re-enter Password</div>
                <input type="password" name="pwd">
                <div id="pass_error2">Please enter same password</div>
                <div class="font font3">Phone Number</div>
                <input type="text" name="phoneNumber">
                <div id="phone_error"> Enter valid phone number</div>
                <button type="submit">Register</button>
            </form>

        </div>
        <script src="rvalid.js"></script>
    </body>
</html>