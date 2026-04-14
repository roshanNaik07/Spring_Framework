<!doctype html>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

<nav class="navbar bg-body-tertiary px-5 py-4 shadow p-3 mb-5">
    <div class="container-fluid">
        <a class="navbar-brand fs-3 fw-bold ms-5" href="index">
            <img src="images/HospitalLogo.png" alt="Logo" width="50" height="50"
                 class="d-inline-block align-text-top me-2">
            MedCare
        </a>
        <div class="d-flex">
            <a href="index" class="btn btn-success me-5">Home</a>
            <a href="userRegister" class="btn btn-success">User Register</a>
        </div>
    </div>
</nav>

<div class="container-fluid d-flex justify-content-center align-items-center ">

    <div>
        <form action="send-otp" method="post" class="border border-success-subtle shadow-lg p-3 mb-5 py-5 px-4 rounded border-3">

            <div class="d-flex justify-content-center">
                <h2 style="font-family:popins">User Login</h2>
            </div>

            <div class="form-text text-danger">${error}</div>

            <div class="my-3">
                <label class="form-label" style="font-family:popins">Enter Email</label>
                <input type="text" name="email" placeholder="Enter email" id="emailId" required class="form-control">
            </div>

            <div class="mb-3">
                <label class="form-label" style="font-family:popins">Enter Password</label>
                <input type="text" class="form-control" name="Password" maxlength="10">
            </div>

            <div class="d-flex justify-content-center">
                <button type="submit" class="btn btn-success">Submit</button>
            </div>

        </form>
    </div>
</div>

</body>
</html>