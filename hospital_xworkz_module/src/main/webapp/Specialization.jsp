<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Specialization</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

<nav class="navbar bg-body-tertiary px-5 py-4 shadow p-3 mb-5">
    <div class="container-fluid">
        <a class="navbar-brand fs-3 fw-bold ms-5" href="index.jsp">
            <img src="images/HospitalLogo.png" alt="Logo" width="50" height="50" class="d-inline-block align-text-top me-2">
            MedCare
        </a>
        <form class="d-flex">
            <a href="Admin.jsp" class="btn btn-success me-5">Dashboard</a>
        </form>
    </div>
</nav>

<div class="container my-5">

    <form action="setSpecialization" method="post" class="border border-success-subtle shadow-lg p-4 rounded" style="max-width: 500px; margin: auto;">

        <h2 class="text-center" style="font-family :popins">Set Specialization</h2>
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