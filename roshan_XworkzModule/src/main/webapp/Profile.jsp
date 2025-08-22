<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Profile.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>

<nav class="navbar bg-body-tertiary">
    <div class="container">
        <a class="navbar-brand" href="/">
            <img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Bootstrap" width="30" height="24">
        </a>
    </div>
    <div>
        <form class="container-fluid justify-content-start d-flex">

            <div class="dropdown me-2 ">
                <button class="btn btn-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">
                    Menu
                </button>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="openUpdatePage">Update Profile</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="Profile.jsp">Help</a></li>
                </ul>
            </div>

            <a href="SignIn.jsp" class="btn btn-outline-success me-2">Log out</a>

        </form>
    </div>
</nav>

<div class="d-flex justify-content-center my-5">
    <h1>Profile Page</h1>
</div>

<h3 style="color:green">${logInSuccess}</h3>
<h3 style="color:green">${success}</h3>

</body>
</html>