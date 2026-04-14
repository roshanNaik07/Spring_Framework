<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Specialization</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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

</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>


<nav class="navbar bg-body-tertiary px-5 py-4 shadow p-3 mb-5">
    <div class="container-fluid">
        <a class="navbar-brand fs-3 fw-bold ms-5" href="admin">
            <img src="images/HospitalLogo.png" alt="Logo" width="50" height="50"
                 class="d-inline-block align-text-top me-2">
            MedCare
        </a>

        <div class="ms-auto d-flex">
            <a href="patients" class="btn btn-success me-3">Patients</a>

            <a href="doctors" class="btn btn-success me-3">Doctors</a>

            <div class="dropdown ms-auto">
                <button class="btn btn-success dropdown-toggle px-5" type="button" id="dropdownMenuButton"
                        data-bs-toggle="dropdown" aria-expanded="false">
                    &#9776; Menu
                </button>
                <ul class="dropdown-menu dropdown-menu-end px-2" aria-labelledby="dropdownMenuButton">
                    <li><a class="dropdown-item custom-success my-2 w-100" href="doctorRegistration">Register
                        Doctor</a></li>
                    <li><a class="dropdown-item custom-success my-2 w-100" href="PatientRegistration">Register
                        Patient</a></li>
                    <li><a class="dropdown-item custom-success my-2 w-100" href="slots">Slots</a></li>
                    <li><a class="dropdown-item custom-success my-2 w-100" href="specialization">Set
                        Specialization</a></li>
                    <li><a class="dropdown-item custom-success w-100" href="logOut">Log out</a></li>
                </ul>
            </div>
        </div>
    </div>
</nav>

<div class="container my-5">

    <form action="specializationUpdate" method="post" class="border border-success-subtle shadow-lg p-4 rounded" style="max-width: 500px; margin: auto;">

        <h2 class="text-center" style="font-family :popins">Add Specialization</h2>
        <span class="form-text text-danger text-center">${error}</span>
        <span class="form-text text-success text-center">${success}</span>

        <div class="mb-3">
            <label for="specialization" class="form-label px-1" style="font-family :popins">Specialization</label>
            <input type="text" class="form-control" id="specialization" name="specialization" placeholder="Enter specialization" required>
        </div>
        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-success">Submit</button>
        </div>
    </form>
</div>

</body>
</html>