<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SignUp.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
</head>
<body>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js" integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q" crossorigin="anonymous"></script>
<script src="signup-validation.js"></script>

<nav class="navbar bg-body-tertiary">
    <div class="container">
        <a class="navbar-brand" href="/">
            <img src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="Bootstrap" width="30" height="24">
        </a>
    </div>
    <div>
        <form class="container-fluid justify-content-start">
            <a href="SignIn.jsp" class="btn btn-outline-success me-2">Sign In</a>
        </form>
    </div>
</nav>

<div class="container my-5 d-flex justify-content-center">
    <h2>Sign Up</h2>
</div>

<form class="container my-5" action="signUp" method="post">
    <span style="color:red">${error}</span>
    <span style="color:green">${success}</span>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label">Name</label>
            <input type="text" class="form-control" name="name" id="name" oninput="validateName()" value="${value.name}">
            <div id="nameError" class="form-text text-danger"></div>
        </div>

        <div class="col-md-6 mb-3">
            <label class="form-label">Phone Number</label>
            <input type="number" class="form-control" name="phoneNo" id="phoneNumber" oninput="validatePhoneNo()" value="${value.phoneNo}" >
            <div id="phoneError" class="form-text text-danger"></div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label">Email</label>
            <input type="text" class="form-control" name="email" id="email" oninput="validateEmail()" value="${value.email}">
            <div id="emailError" class="form-text text-danger"></div>
        </div>
        <div class="col-md-6 mb-3">
            <label class="form-label">Age</label>
            <input type="number" class="form-control" name="age" id="age" oninput="validateAge()" value="${value.age}">
            <div id="ageError" class="form-text text-danger"></div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label">Password</label>
            <input type="password" class="form-control" name="password" id="password" oninput="validatePassword()" value="${value.password}">
            <div id="passwordError" class="form-text text-danger"></div>
        </div>
        <div class="col-md-6 mb-3">
            <label class="form-label">Confirm Password</label>
            <input type="password" class="form-control" name="confirmPassword" id="confirmPassword" oninput="validateConfirmPassword()" value="${value.confirmPassword}">
            <div id="confirmPasswordError" class="form-text text-danger"></div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label">Address</label>
            <input type="text" class="form-control" name="address" id="address" oninput="validateAddress()" value="${value.address}">
            <div id="addressError" class="form-text text-danger"></div>
        </div>
        <div class="col-md-6 mb-3">
            <select class="form-select mt-3 " aria-label="Default select example" name="gender" id="gender" oninput="validateGender()" value="${value.gender}">
                <option selected disabled>Select gender</option>
                <option value="male" >male</option>
                <option value="female" >female</option>
                <option value="others" >others</option>
            </select>
            <span id="genderError" style="color: red; font-size: 14px;"></span>
        </div>
    </div>
    <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-primary ">Submit</button>
    </div>
</form>

</body>
</html>