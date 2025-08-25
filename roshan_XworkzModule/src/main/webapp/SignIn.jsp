<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SignIn.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous"></script>

<nav class="navbar bg-body-tertiary shadow-sm p-3 mb-5">
    <div class="container">
        <a class="navbar-brand" href="/">
            <img src="images/x-workzLogo.png" alt="Bootstrap" width="160" height="70">
        </a>
    </div>
    <div>
        <form class="container-fluid justify-content-start">
            <a href="SignUp.jsp" class="btn btn-outline-warning me-2 btn-lg shadow-sm">Sign Up</a>
        </form>
    </div>
</nav>

<div class="container my-5 d-flex justify-content-center">
    <h2>Sign In</h2>
</div>

<div class="container-fluid d-flex justify-content-center align-items-center ">
    <div>
        <span style="color:red">${error}</span>
        <span style="color:green">${success}</span>
        <span style="color:green">${updatedPassword}</span>
        <form action="signIn" method="post">

            <div class="mb-3">
                <label class="form-label">User Name</label>
                <input type="text" class="form-control" name="userName">
            </div>
            <div class="mb-3">
                <label class="form-label">Password</label>
                <input type="password" class="form-control" name="password">
            </div>

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-primary">Submit</button>
            </div>

            <div class="text-center mt-2">
                <a href="ForgotPassword.jsp" class="text-decoration-none">Forgot Password?</a>
            </div>

        </form>

    </div>
</div>

</body>
</html>