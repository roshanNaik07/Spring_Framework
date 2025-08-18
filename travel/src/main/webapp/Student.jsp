<!doctype html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Student.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="d-flex justify-content-center py-5">
    <h1>Student Details</h1>
</div>

<div class="container-fluid d-flex justify-content-center align-items-center ">
    <div>
        <span>
            <span style="color:red">${error}</span>
            <span style="color:green">${Result}</span>
        </span>
        <form action="student" method="post" >

            <div class="mb-3">
                <label  class="form-label">First Name</label>
                <input type="text" class="form-control" name="firstName" value="${value.firstName}">
            </div>
            <div class="mb-3">
                <label  class="form-label">Middle Name</label>
                <input type="text" class="form-control" name="middleName" value="${value.middleName}">
            </div>
            <div class="mb-3">
                <label  class="form-label">Last Name</label>
                <input type="text" class="form-control" name="lastName" value="${value.lastName}">
            </div>

            <div class="mb-3">
                <label  class="form-label">email</label>
                <input type="text" class="form-control" name="email" value="${value.email}">
            </div>

            <div class="mb-3">
                <label  class="form-label">USN</label>
                <input type="text" class="form-control" name="usn" value="${value.usn}">
            </div>

            <div class="mb-3">
                <label  class="form-label">Age</label>
                <input type="number" class="form-control" name="age" value="${value.age}">
            </div>

            <div class="mb-3">
                <label  class="form-label">Phone Number</label>
                <input type="text" class="form-control" name="phoneNo" value="${value.phoneNo}">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

</body>
</html>