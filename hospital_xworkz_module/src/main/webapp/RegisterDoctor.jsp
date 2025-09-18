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
            <a href="index.jsp" class="btn btn-success me-5">Log out</a>
        </form>
    </div>
</nav>

<form class="container my-5 border border-success-subtle shadow-lg p-3 mb-5 py-5 px-4 rounded border-3"
      action="registerDoctor" method="post" enctype="multipart/form-data">

    <div class="container d-flex justify-content-center">
        <h2>Enter doctor details</h2>
    </div>

    <div style="color:red">${error}</div>
    <div style="color:green">${success}</div>

    <div class="row mt-3">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Name</label>
            <input type="text" class="form-control" name="name" id="name" oninput="validateName()" maxlength="30"
                   value="${values.name}" required>
            <div id="nameError" class="form-text text-danger"></div>
        </div>

        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Email</label>
            <input type="email" class="form-control" name="email" id="email" oninput="validateEmail()" maxlength="30"
                   value=${values.email} >
            <div id="emailError" class="form-text text-danger"></div>
        </div>

    </div>

    <div class="row">

        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family: popins">Specialization</label>
            <select class="form-select" aria-label="Default select example"
                    name="specialization" id="specialization"
                    oninput="validateSpecialization()" style="font-family:popins" required>
                <option disabled ${empty values.specialization ? "selected" : ""}>Select specialization</option>

                <c:forEach var="spec" items="${Specialization.values()}">
                    <option value="${spec}"
                            ${values.specialization == spec ? "selected" : ""}>
                    ${spec}
                    </option>
                </c:forEach>

            </select>

            <span id="specializationError" style="color: red; font-size: 14px;"></span>
        </div>

        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family: popins">Degree / Qualification</label>
            <div class="position-relative">
                <input type="text" class="form-control" name="qualification" id="qualificationId"
                       placeholder="e.g. MBBS, MD, MS" maxlength="50" oninput="qualificationValidation()"
                       value="${values.qualification}" required>
            </div>
            <div id="qualificationErrorId" class="form-text text-danger"></div>
        </div>

    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Years of Experience</label>
            <input type="text" class="form-control" name="experience" id="experience" oninput="validateExperience()"
                   maxlength="2" value=${values.experience}>
            <div id="experienceError" class="form-text text-danger"></div>
        </div>

        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Phone No</label>
            <div class="position-relative">
                <input type="text" class="form-control pe-5"
                       name="phoneNumber" id="PhoneNumberId"
                       oninput="validatePhoneNumber()" maxlength="10" value="${values.phoneNumber}" required>
            </div>
            <div id="phoneNumberErrorId" class="form-text text-danger"></div>
        </div>

    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <input type="file" name="image" value="values.imageName" required>
        </div>
    </div>

    <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-success ">Submit</button>
    </div>

</form>

<script src="validation.js"></script>

</body>
</html>