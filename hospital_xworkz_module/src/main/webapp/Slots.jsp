<!doctype html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Medcare.com</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ page import="com.xworkz.hospital.constant.Specialization" %>
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
            <a href="SetSlot.jsp" class="btn btn-success me-5">Set Slot</a>
            <a href="index.jsp" class="btn btn-success me-5">Log out</a>
        </form>
    </div>
</nav>


<form action="getBySpecialization" method="get"
      class="container my-5 border border-success-subtle shadow-lg p-4 rounded border-3"
      style="max-width: 600px;">

    <h3 class="text-center mb-4" style="font-family: Poppins;">Set Doctor Slots</h3>

    <div class="mb-3">
        <select class="form-select" aria-label="Default select example"
                name="specialization" oninput="validateSpecialization()" style="font-family:popins" required>

            <option disabled ${empty values.specialization ?
            "selected" : ""}>Select specialization</option>
            <c:forEach var="spec" items="${Specialization.values()}">
                <option value="${spec}"
                        ${values.specialization== spec ?
                "selected" : ""}>
                ${spec}
                </option>
            </c:forEach>
        </select>
    </div>

    <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-success ">Submit</button>
    </div>

</form>

<c:if test="${not empty openDoctorSlotForm}">
    <form action="setDoctorSlots" method="get"
          class="container my-5 border border-success-subtle shadow-lg p-4 rounded border-3" style="max-width: 600px;">

        <h3 class="text-center mb-4" style="font-family: Poppins;">Select Doctor and Slots</h3>

        <div class="mb-3">
            <b><label class="form-label px-2" style="font-family:popins">Doctor Name</label></b>
            <select class="form-select" aria-label="Default select example"
                    name="specialization" id="specialization"
                    oninput="validateSpecialization()" style="font-family:popins" required>
                <option disabled ${empty values.specialization ?
                "selected" : ""}>Select Doctor</option>

                <c:forEach var="spec" items="${Specialization.values()}">
                    <option value="${spec}"
                            ${values.specialization== spec ?
                    "selected" : ""}>
                    ${spec}
                    </option>
                </c:forEach>
            </select>

            <b><label class="form-label px-2 pt-4" style="font-family:popins">Select Slots</label></b>
            <select class="form-select" aria-label="Default select example"
                    name="specialization" oninput="validateSpecialization()" style="font-family:popins" required>
                <option disabled ${empty values.specialization ?
                "selected" : ""}>Select Slots</option>
                <c:forEach var="spec" items="${Specialization.values()}">
                    <option value="${spec}"
                            ${values.specialization== spec ?
                    "selected" : ""}>
                    ${spec}
                    </option>
                </c:forEach>
            </select>
        </div>

        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-success ">Submit</button>
        </div>
    </form>

</c:if>

</body>
</html>