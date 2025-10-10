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
            <a href="Admin.jsp" class="btn btn-success me-5">Dashboard</a>
            <a href="logOut" class="btn btn-success me-5">Log out</a>
        </form>
    </div>
</nav>

<h1 class="text-center mb-4" style="font-family: Poppins;">Doctors List</h1>

<h3 class="display-6 text-center mt-2 text-success" class="Message">${success}</h3>
<h3 class="display-6 text-center mt-2 text-danger" class="Message">${error}</h3>

<div class="container">
    <table class="table table-bordered table-hover">
        <thead class="table-success">
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Specialization</th>
            <th>Qualification</th>
            <th>Experience</th>
            <th>PhoneNumber</th>
            <th>Image</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="doctor" items="${doctors}" varStatus="status">
            <tr>
                <td>${status.index + 1}</td>
                <td>${doctor.name}</td>
                <td>${doctor.email}</td>
                <td>${doctor.specialization}</td>
                <td>${doctor.qualification}</td>
                <td>${doctor.experience}</td>
                <td>${doctor.phoneNumber}</td>
                <td>
                    <img src="download?fileName=${doctor.imageName}" width="135" height="100">
                </td>
                <td>
                    <form action="openUpdateDoctorPage" method="post" class="d-inline">
                        <input type="hidden" name="email" value="${doctor.email}">
                        <input type="hidden" name="name" value="${doctor.name}">
                        <input type="hidden" name="specialization" value="${doctor.specialization}">
                        <input type="hidden" name="qualification" value="${doctor.qualification}">
                        <input type="hidden" name="experience" value="${doctor.experience}">
                        <input type="hidden" name="phoneNumber" value="${doctor.phoneNumber}">
                        <input type="hidden" name="imageName" value="${doctor.imageName}">
                        <button type="submit" class="btn btn-warning btn-sm">Update</button>
                    </form>

                    <form action="deleteDoctor" method="post" class="d-inline" onsubmit="return false;">
                        <input type="hidden" name="email" value="${doctor.email}">
                        <button type="button" class="btn btn-danger btn-sm" data-bs-toggle="modal"
                                data-bs-target="#deleteModal${doctor.email}">
                            Delete
                        </button>
                    </form>

                    <div class="modal fade" id="deleteModal${doctor.email}" tabindex="-1" aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content shadow-lg border-0 rounded-2" style="font-family: Poppins;">
                                <div class="modal-header bg-success text-white rounded-top-2 justify-content-center">
                                    <h5 class="modal-title text-center w-100 fs-2">Confirm Delete</h5>
                                    <button type="button" class="btn-close btn-close-white position-absolute end-0 me-4"
                                            data-bs-dismiss="modal" aria-label="Close"></button>
                                </div>
                                <div class="modal-body text-center">
                                    <p class="fs-5 mb-0">
                                        Are you sure you want to delete <strong>Dr ${doctor.name}</strong>?
                                    </p>
                                </div>
                                <div class="modal-footer d-flex justify-content-center border-0">
                                    <button type="button" class="btn btn-secondary px-4 rounded-2"
                                            data-bs-dismiss="modal">
                                        Cancel
                                    </button>
                                    <form action="deleteDoctor" method="post" class="d-inline">
                                        <input type="hidden" name="email" value="${doctor.email}">
                                        <button type="submit" class="btn btn-danger px-4 rounded-2 shadow-sm">
                                            Yes, Delete
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<script>
    setTimeout(function () {
      const msg = document.getElementById("Message");
      if (msg) {
        msg.style.display = "none";
      }
    }, 10000)
</script>
  </body>
  </html>