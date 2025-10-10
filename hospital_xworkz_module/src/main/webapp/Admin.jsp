<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Medcare.com</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <style>
        .custom-success {
            background-color: #28a745 !important;
            color: white !important;
            border: 1px solid #28a745 !important;
            border-radius: 5px;
        }
        .custom-success:hover {
            background-color: #218838 !important;
            border-color: #1e7e34 !important;
        }
    </style>
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

<nav class="navbar bg-body-tertiary px-5 py-4 shadow p-3 mb-5">
    <div class="container-fluid">
        <a class="navbar-brand fs-3 fw-bold ms-5" href="index.jsp">
            <img src="images/HospitalLogo.png" alt="Logo" width="50" height="50"
                 class="d-inline-block align-text-top me-2">
            MedCare
        </a>

        <div class="ms-auto d-flex">
            <a href="getAllPatients" class="btn btn-success me-3">Patients</a>

            <a href="getAllDotors" class="btn btn-success me-3">Doctors</a>

            <div class="dropdown ms-auto">
                <button class="btn btn-success dropdown-toggle px-5" type="button" id="dropdownMenuButton"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    &#9776; Menu
                </button>
                <ul class="dropdown-menu dropdown-menu-end px-2" aria-labelledby="dropdownMenuButton">
                    <li><a class="dropdown-item custom-success my-2 w-100" href="openDoctorRegisterPage">Register
                        Doctor</a></li>
                    <li><a class="dropdown-item custom-success my-2 w-100" href="openPatientRegisterPage">Register
                        Patient</a></li>
                    <li><a class="dropdown-item custom-success my-2 w-100" href="openSlot">Slots</a></li>
                    <li><a class="dropdown-item custom-success my-2 w-100" href="Specialization.jsp">Set
                        Specialization</a></li>
                    <li><a class="dropdown-item custom-success w-100" href="logOut">Log out</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<h3 class="display-6 text-center mt-5 text-success">${success}</h3>
<h3 class="display-6 text-center mt-5 text-danger">${error}</h3>
</body>
</html>
