<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Medcare.com</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI"
        crossorigin="anonymous"></script>

<nav class="navbar bg-body-tertiary px-5 py-4 shadow p-3 mb-5" style="color">
    <div class="container-fluid">
        <a class="navbar-brand fs-3 fw-bold ms-5" href="index.jsp">
            <img src="images/HospitalLogo.png" alt="Logo" width="50" height="50"
                 class="d-inline-block align-text-top me-2">
            MedCare
        </a>
        <form class="d-flex">
            <a href="redirectToSlot" class="btn btn-success me-5">Doctor slots</a>
            <a href="index.jsp" class="btn btn-success me-5">Log out</a>
        </form>
    </div>
</nav>


<form action="saveSlot" method="post"
      class="container my-5 border border-success-subtle shadow-lg p-4 rounded border-3"
      style="max-width: 600px;">

    <h3 class="text-center mb-4" style="font-family: Poppins;">Set Slots for specialization</h3>

    <div class="form-text text-danger">${error}</div>

    <div class="mb-3">
        <label class="form-label" style="font-family: popins">Specialization</label>
        <select class="form-select" aria-label="Default select example"
                name="specialization" style="font-family:popins" required>
            <option selected disabled>Select specialization</option>
            <c:forEach var="spec" items="${specializations}">
                <option value="${spec}" ${selectedSpecialization == spec ? "selected" : ""}>
                ${spec}
                </option>
            </c:forEach>
        </select>
    </div>

    <div class="mb-3">
        <label class="form-label" style="font-family: Poppins;">Start Time</label>
        <div class="input-group">
            <input type="time" class="form-control" name="slotStartTime" required>
        </div>
    </div>

    <div class="mb-3">
        <label class="form-label" style="font-family: Poppins;">End Time</label>
        <div class="input-group">
            <input type="time" class="form-control" name="slotEndTime" required>
        </div>
    </div>

    <div class="text-center">
        <button type="submit" class="btn btn-success px-4">Save Slot</button>
    </div>
</form>


<script src="validation.js"></script>

</body>
</html>