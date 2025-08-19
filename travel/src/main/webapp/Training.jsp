<!doctype html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Training.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="d-flex justify-content-center py-5">
    <h1>Training Details</h1>
</div>

<div class="container-fluid d-flex justify-content-center align-items-center ">
    <div>
        <span>
            <span style="color:red">${error}</span>
            <span style="color:green">${Result}</span>
        </span>

        <form action="training" method="post" >

            <div class="mb-3">
                <label  class="form-label">Training Name</label>
                <input type="text" class="form-control" name="trainingName" value="${value.trainingName}">
            </div>
            <div class="mb-3">
                <label  class="form-label">Location</label>
                <input type="text" class="form-control" name="location" value="${value.location}">
            </div>
            <div class="mb-3">
                <label  class="form-label">Course Name</label>
                <input type="text" class="form-control" name="courseName" value="${value.courseName}">
            </div>

            <div class="mb-3">
                <label  class="form-label">email</label>
                <input type="text" class="form-control" name="email" value="${value.email}">
            </div>

            <div class="mb-3">
                <label  class="form-label">Trainer Name</label>
                <input type="text" class="form-control" name="trainerName" value="${value.trainerName}">
            </div>

            <div class="mb-3">
                <label  class="form-label">Trainer Experience</label>
                <input type="number" class="form-control" name="trainerExperience" value="${value.trainerExperience}">
            </div>

            <div class="mb-3">
                <label  class="form-label">Phone Number</label>
                <input type="number" class="form-control" name="phoneNo" value="${value.phoneNo}">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

</body>
</html>