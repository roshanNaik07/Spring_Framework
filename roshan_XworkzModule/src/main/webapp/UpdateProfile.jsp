<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Profile.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous"></script>
<script src="signup-validation.js"></script>

<nav class="navbar bg-body-tertiary shadow-sm p-3 mb-5 " data-bs-theme="dark" >
    <div class="container">
        <a class="navbar-brand" href="index.jsp">
            <img src="images/x-workzLogo.png" alt="Bootstrap" width="160" height="70">
        </a>
    </div>
    <div>
        <form class="container-fluid justify-content-start d-flex">

            <a href="SignIn.jsp" class="btn btn-outline-warning me-2 btn-lg shadow-sm">Log out</a>

        </form>
    </div>
</nav>

<form class="container my-5 border border-warning-subtle shadow-lg p-3 mb-5 py-5 px-4 rounded border-3" action="updateUserData" method="post">
    <div class="container my-5 d-flex justify-content-center">
        <h2 style="font-family:popins">Update Profile</h2>
    </div>

    <span style="color:red">${error}</span>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Name</label>
            <input type="text" class="form-control" name="name" id="name" oninput="validateName()"
                   value="${userData.name}" readonly>
            <div id="nameError" class="form-text text-danger"></div>
        </div>

        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Phone Number</label>
            <input type="number" class="form-control" name="phoneNo" id="phoneNumber" oninput="validatePhoneNo()"
                   value="${userData.phoneNo}">
            <div id="phoneError" class="form-text text-danger"></div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Email</label>
            <input type="text" class="form-control" name="email" id="email" oninput="validateEmail()"
                   value="${userData.email}" >
            <div id="emailError" class="form-text text-danger"></div>
        </div>
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Age</label>
            <input type="number" class="form-control" name="age" id="age" oninput="validateAge()"
                   value="${userData.age}">
            <div id="ageError" class="form-text text-danger"></div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Address</label>
            <input type="text" class="form-control" name="address" id="address" oninput="validateAddress()"
                   value="${userData.address}">
            <div id="addressError" class="form-text text-danger"></div>
        </div>
        <div class="col-md-6 mb-3">
            <select class="form-select mt-3 " aria-label="Default select example" disabled style="font-family:popins">
                <option value="${userData.gender}">${userData.gender}</option>
            </select>
            <input type="hidden" name="gender" value="${userData.gender}">
        </div>
    </div>
    <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-primary ">Submit</button>
    </div>
</form>


</body>
</html>