<!doctype html>
<html lang="en" xmlns:c="http://www.w3.org/1999/XSL/Transform">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

<script>
    function startTimer() {
    console.log("startTimer() triggered!");
    let timerDisplay = document.getElementById("timer");
    let submitBtn = document.getElementById("submit");
    let displayBtn = document.getElementById("resendOTP");

    let expiryTime = sessionStorage.getItem("otpExpiry");

    if (!expiryTime) {
        expiryTime = Date.now() + 90 * 1000; // 90 sec from now
        sessionStorage.setItem("otpExpiry", expiryTime);
    }

    let interval = setInterval(() => {
        let remaining = Math.floor((expiryTime - Date.now()) / 1000);

        if (remaining > 0) {
            timerDisplay.textContent = "OTP valid till " + remaining + "s";
            submitBtn.style.display = "inline-block";
            displayBtn.style.display = "none";
        } else {
            clearInterval(interval);
            timerDisplay.textContent = "";
            submitBtn.style.display = "none";
            displayBtn.style.display = "inline-block";
            sessionStorage.removeItem("otpExpiry");
        }
    }, 1000);
}

    function checkEmail(){

            let email = document.getElementById("emailId").value;
            let errorBox = document.getElementById("errorBox");
            let icon = document.getElementById("iconId");
            let input = document.getElementById("emailId");

            errorBox.innerHTML = "";

            input.classList.remove("is-valid", "is-invalid");

            if(!email || email.trim() === ""){
                errorBox.innerHTML = "Email cannot be empty";
                icon.classList.add("d-none");
                input.classList.add("is-invalid");
                input.style.borderColor = "red";
                return;
            }

            const xhttp = new XMLHttpRequest();
            xhttp.open("GET","http://localhost:8080/hospital_xworkz_module/checkEmail/" + encodeURIComponent(email));
            xhttp.send();

            xhttp.onload = function(){
               let response = this.responseText.trim();

               if(response === ""){
                    icon.classList.remove("d-none");
                    input.classList.add("is-valid");
                    input.style.borderColor = "green";
               }else{
                    errorBox.innerHTML = response;
                    icon.classList.add("d-none");
                    input.classList.add("is-invalid");
                    input.style.borderColor = "red";
               }

            }
        }

</script>

<nav class="navbar bg-body-tertiary px-5 py-4 shadow p-3 mb-5">
    <div class="container-fluid">
        <a class="navbar-brand fs-3 fw-bold ms-5" href="index">
            <img src="images/HospitalLogo.png" alt="Logo" width="50" height="50"
                 class="d-inline-block align-text-top me-2">
            MedCare
        </a>
        <a href="index" class="btn btn-success me-5"><i class="fa-solid fa-house me-2"></i>Home</a>
    </div>
</nav>

<div class="container-fluid d-flex justify-content-center align-items-center ">

    <div>
        <form action="send-otp" method="post"
              class="border border-success-subtle shadow-lg p-3 mb-5 py-5 px-4 rounded border-3">

            <div class="d-flex justify-content-center">
                <div class="text-center">
                    <i class="fa-solid fa-user-lock" style="color:#0ea5e9; font-size:50px;"></i>
                    <h2 style="font-family:popins">Admin Login</h2>
                </div>
            </div>

            <div class="my-3">

                <label class="form-label" style="font-family:popins">Enter Email</label>
                <c:if test="${not empty email}">
                    <input type="text" name="email" value="${email}" readonly required class="form-control">
                </c:if>

                <c:if test="${empty email}">
                    <div class="position-relative ">
                        <input type="text" name="email" placeholder="Enter email"
                               id="emailId"
                               required
                               class="form-control pe-5;"
                               onchange="checkEmail()" style="border-color:white">

                        <span id="iconId"
                              class="position-absolute top-50 end-0 translate-middle-y me-3 d-none">
                            </span>
                    </div>
                </c:if>

            </div>

            <div class="form-text text-danger py-2" id="errorBox">${error}</div>

            <div class="d-flex justify-content-center">
                <c:if test="${empty showotpField}">
                    <button type="submit" class="btn btn-success">Send OTP</button>
                </c:if>
            </div>

            <c:if test="${not empty showotpField}">

                <div class="mb-3">
                    <label class="form-label" style="font-family:popins ">Enter OTP</label>
                    <input type="number" class="form-control" name="otp">
                </div>

                <div class="form-text text-danger py-2" id="timer"></div>

                <div class="d-flex justify-content-center">
                    <button type="submit" class="btn btn-success" formaction="verify-otp" id="submit">Submit</button>
                    <button type="submit" class="btn btn-success" id="resendOTP" style="display: none;">Resend</button>
                </div>

                <script>
                    startTimer();
                </script>
            </c:if>

        </form>
    </div>
</div>

</body>
</html>