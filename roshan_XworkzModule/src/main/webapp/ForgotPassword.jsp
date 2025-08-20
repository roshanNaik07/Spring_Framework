<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>ForgotPassword.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous"></script>
<script src="signup-validation.js"></script>

<nav class="navbar bg-body-tertiary">
    <div class="container">
        <a class="navbar-brand" href="/">
            <img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Bootstrap" width="30" height="24">
        </a>
    </div>
    <div>
        <form class="container-fluid justify-content-start">
            <a href="SignUp.jsp" class="btn btn-outline-success me-2">Sign Up</a>
        </form>
    </div>
</nav>

<div class="container my-5 d-flex justify-content-center">
    <h2>Forgot Password</h2>
</div>

<div class="container-fluid d-flex justify-content-center align-items-center ">
    <div>
        <span style="color:red">${error}</span>
        <form action="forgotPassword" method="post">

            <div class="mb-3">
                <label class="form-label">email</label>
                <input type="text" class="form-control" name="email" placeholder="Enter registered email" required/>
            </div>
            <div class="mb-3">
                <label class="form-label">New Password</label>
                <input type="password" class="form-control" name="password" id="password" oninput="validatePassword()" required>
                <div id="passwordError" class="form-text text-danger"></div>
            </div>

            <div class="mb-3">
                <label class="form-label">Confirm Password</label>
                <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" oninput="validateConfirmPassword()" required>
                <div id="confirmPasswordError" class="form-text text-danger"></div>
            </div>

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary ">Submit</button>
            </div>

        </form>

    </div>
</div>

</body>
</html>