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
            <a href="openSetSlotForm" class="btn btn-success me-5">Set Slot</a>
            <a href="Admin.jsp" class="btn btn-success me-5">Dashboard</a>
            <a href="logOut" class="btn btn-success me-5">Log out</a>
        </form>
    </div>
</nav>

<h1 class="text-center mb-4" style="font-family: Poppins;">Set Doctor's Slots</h1>
<div class="text-center form-text text-danger mb-1">${error}</div>
<div class="text-center form-text text-success mb-1">${success}</div>
<form action="getBySpecialization" method="get"
      class="container  border border-success-subtle shadow-lg p-4 rounded border-3"
      style="max-width: 600px;">
    <h3 class="text-center mb-4" style="font-family: Poppins;">Select Specialization</h3>
    <span class="form-text text-danger">${error}</span>
    <div class="mb-3">
        <select class="form-select" aria-label="Default select example"
                name="specialization" style="font-family:popins" required>
            <option selected disabled>Select specialization</option>
            <c:forEach var="spec" items="${specializations}">
                <option value="${spec}" ${selectedSpecialization== spec ?
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
    <form class="container my-5 border border-success-subtle shadow-lg p-3 mb-5 py-5 px-4 rounded border-3"
          action="saveDoctorSlots" method="post">

        <h3 class="text-center mb-4" style="font-family: Poppins;">Select Doctor and Slots</h3>

        <span class="form-text text-danger">${error}</span>

        <div class="row">
            <div class="col-md-6 mb-3">
                <b><label class="form-label px-2" style="font-family:popins">Doctor Name</label></b>
                <select class="form-select" id="doctorNameSelect"
                        name="doctorName" style="font-family:popins" required onchange="setDoctorEmail()">
                    <option disabled selected value="">Select Doctor</option>
                    <c:forEach var="doctor" items="${doctorRegistrationDTOList}">
                        <option value="${doctor.name}" data-email="${doctor.email}">
                            ${doctor.name}
                        </option>
                    </c:forEach>
                </select>
            </div>

            <div class="col-md-6 mb-3">
                <b><label class="form-label px-2" style="font-family:popins">Select Slots</label></b>
                <select class="form-select" aria-label="Default select example"
                        name="slotTimings" style="font-family:popins" required>
                    <option disabled selected value="">Select Slots</option>
                    <c:forEach var="slot" items="${slotTimings}">
                        <option value="${slot}">
                            ${slot}
                        </option>
                    </c:forEach>
                </select>
            </div>
        </div>

        <div class="row">
            <div class="col-md-6 mb-3">
                <b><label class="form-label px-2" style="font-family:popins">Doctor Email</label></b>
                <input type="hidden" id="doctorEmailHidden" name="email">
                <input type="text" class="form-control bg-secondary-subtle" id="doctorEmailInput" readonly
                       style="font-family:popins">
            </div>

            <div class="col-md-6 mb-3">
                <b><label class="form-label px-2" style="font-family:popins">Specialization</label></b>
                <input type="text" class="form-control bg-secondary-subtle" name="specialization"
                       value="${specialization}" readonly style="font-family:popins">
            </div>
        </div>

        <div class="d-flex justify-content-center">
            <button type="submit" class="btn btn-success ">Submit</button>
        </div>
    </form>

</c:if>

<SCRIPT>
    function setDoctorEmail(){
        let select = document.getElementById("doctorNameSelect");
        let selectedOption = select.options[select.selectedIndex];
        let email = selectedOption.getAttribute("data-email");

        document.getElementById("doctorEmailHidden").value = email;

        document.getElementById("doctorEmailInput").value = email;
    }
</SCRIPT>

</body>
</html>