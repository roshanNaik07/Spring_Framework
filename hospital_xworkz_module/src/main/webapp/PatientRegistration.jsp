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

<script>

    window.onload = function() {
        let specializationError = document.getElementById("specializationError");
        specializationError.textContent = "Please select the specialization to get the doctor and slot details.";
        specializationError.style.color = "orange";
    };

    function fetchDoctorsBySpecialization() {
        console.log("Fetching doctors by specialization...");
        let specialization = document.getElementById("specializationSelect").value;
        let specializationError = document.getElementById("specializationError");
        let doctorError = document.getElementById("doctorError");

        specializationError.textContent = "";

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/hospital_xworkz_module/fetchDoctorNameBySpecialization/" + specialization);
        xhttp.setRequestHeader("Accept", "application/json");
        xhttp.send();

        xhttp.onload = function () {
            if (this.status === 200) {
                const doctors = JSON.parse(this.responseText);
                const doctorSelect = document.getElementById("doctorNameWithID");

                if(doctors.length === 0) {
                    specializationError.textContent = "No doctors available for the selected specialization.";
                    specializationError.style.color = "red";
                }

                doctorSelect.innerHTML = '<option disabled selected value="">Select Doctor</option>';

                doctors.forEach(doctor => {
                    const option = document.createElement("option");
                    option.value = doctor.id;
                    option.text = doctor.name;
                    doctorSelect.appendChild(option);
                });
            }
        };
    }

    function fetchSlotsByDoctorId(){
        console.log("Fetching slots by doctor ID...");
        let doctorId = document.getElementById("doctorNameWithID").value;

        const xhttp = new XMLHttpRequest();
        xhttp.open("GET", "http://localhost:8080/hospital_xworkz_module/fetchSlotsByDoctorId/" + doctorId);
        xhttp.setRequestHeader("Accept", "application/json");
        xhttp.send();

        xhttp.onload = function () {
            if (this.status === 200) {
                const slots = JSON.parse(this.responseText);
                const slotSelect = document.getElementById("slotTimingsSelect");

                slotSelect.innerHTML = '<option disabled selected value="">Select Slots</option>';

                slots.forEach(slot => {
                    const option = document.createElement("option");
                    option.value = slot.id;
                    option.text = slot.slotTimings;
                    slotSelect.appendChild(option);
                });
            }
        };
    }
</script>

<nav class="navbar bg-body-tertiary px-5 py-4 shadow p-3 mb-5" style="color">
    <div class="container-fluid">
        <a class="navbar-brand fs-3 fw-bold ms-5" href="index.jsp">
            <img src="images/HospitalLogo.png" alt="Logo" width="50" height="50"
                 class="d-inline-block align-text-top me-2">
            MedCare
        </a>
        <form class="d-flex">
            <a href="Admin.jsp" class="btn btn-success me-5">Dashboard</a>
            <a href="logOut" class="btn btn-success me-5">Log out</a>
        </form>
    </div>
</nav>

<form class="container my-5 border border-success-subtle shadow-lg p-3 mb-5 py-5 px-4 rounded border-3"
      action="registerDoctor" method="post" enctype="multipart/form-data">

    <div class="container d-flex justify-content-center" style="font-family: popins">
        <h2>Enter Patient details</h2>
    </div>

    <div style="color:red">${error}</div>
    <div style="color:green">${success}</div>

    <div class="row mt-3">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Patient Name</label>
            <input type="text" class="form-control" name="name" id="name" oninput="validateName()" maxlength="30"
                   value="${values.name}" placeholder="Enter full name" required>
            <div id="nameError" class="form-text text-danger"></div>
        </div>

        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Email</label>
            <input type="email" class="form-control" name="email" id="email" oninput="validateEmail()" maxlength="30"
                   value="${values.email}" placeholder="Enter email address" required>
            <div id="emailError" class="form-text text-danger"></div>
        </div>

    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Phone No</label>
            <div class="position-relative">
                <input type="text" class="form-control pe-5"
                       name="phoneNumber" id="PhoneNumberId" placeholder="Enter 10-digit phone number"
                       oninput="validatePhoneNumber()" maxlength="10" value="${values.phoneNumber}" required>
            </div>
            <div id="phoneNumberErrorId" class="form-text text-danger"></div>
        </div>
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family:popins">Age</label>
            <input type="text" class="form-control" name="age" id="age" maxlength="3" oninput="validateAge()"
                   placeholder="Enter age in years" value="${values.age}" required>
            <div id="ageError" class="form-text text-danger"></div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family: popins">Address</label>
            <textarea class="form-control py-2" name="address" id="addressId" rows="1"
                      placeholder="Enter full address" maxlength="200" oninput="validateAddress()" required>${values.address}</textarea>
            <div id="addressErrorId" class="form-text text-danger"></div>
        </div>


        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family: popins">Blood Group</label>
            <select class="form-select py-2" name="bloodGroup" id="bloodGroupId" required>
                <option selected disabled>Select blood group</option>
                <c:forEach var="bg" items="${bloodGroups}">
                    <option value="${bg}" ${values.bloodGroup== bg ?
                    "selected" : ""}>
                    ${bg}
                    </option>
                </c:forEach>
            </select>
            <span id="bloodGroupError" class="form-text text-danger"></span>
        </div>
    </div>

    <div class="row">
        <div class="col-12 mb-3">
            <label class="form-label" style="font-family: popins">Symptoms</label>
            <textarea class="form-control" name="symptoms" id="symptomsId" rows="3"
                      placeholder="Enter patient's symptoms in detail" minlength="5" maxlength="400"
                      oninput="validateSymptoms()" required>${values.symptoms}</textarea>
            <div id="symptomsErrorId" class="form-text text-danger"></div>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label" style="font-family: popins">Specialization</label>
            <select class="form-select" aria-label="Default select example"
                    name="specialization" style="font-family:popins" id="specializationSelect"
                    onchange="fetchDoctorsBySpecialization()" required>
                <option selected disabled>Select specialization</option>
                <c:forEach var="spec" items="${specializations}">
                    <option value="${spec}" ${selectedSpecialization== spec ?
                    "selected" : ""}>
                    ${spec}
                    </option>
                </c:forEach>
            </select>
            <span id="specializationError" style="font-size: 14px;"></span>
        </div>

        <div class="col-md-6 mb-3">
            <label class="form-label px-2" style="font-family:popins">Doctor Name</label>
            <select id="doctorNameWithID" class="form-select"
                    onchange="fetchSlotsByDoctorId()" name="doctorName" style="font-family:popins" required>
                <option disabled selected value="">Select Doctor</option>
            </select>
            <span id="doctorError" style="font-size: 14px;"></span>
        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-3">
            <label class="form-label px-2" style="font-family:popins">Select Slots</label>
            <select id="slotTimingsSelect" class="form-select" name="slotTimings"
                    style="font-family: Poppins;" aria-label="Default select example" required>
                <option disabled selected value="">Select Slots</option>
            </select>
        </div>

        <div class="col-md-6 mb-3">

        </div>
    </div>

    <div class="d-flex justify-content-center">
        <button type="submit" class="btn btn-success ">Submit</button>
    </div>

</form>

<script src="validation.js"></script>

</body>
</html>