<!doctype html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Result.jsp</title>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>

<div class="d-flex justify-content-center py-5">
    <h1>Enter id</h1>
</div>

<div class="container-fluid d-flex justify-content-center align-items-center ">
    <div>
        <span style="color:red" class="py-5">${error}</span>
        <form action="getByID" method="post" >
            <div class="mb-3">
                <label  class="form-label">Enter Id</label>
                <input type="number" class="form-control" name="id">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>
<table class="table my-5">
    <thead>
    <tr>
        <th>Name</th>
        <th>Email</th>
        <th>Phone No</th>
        <th>Price</th>
    </tr>
    </thead>
    <tbody>
        <tr>
            <td>${result.name}</td>
            <td>${result.email}</td>
            <td>${result.phoneNo}</td>
            <td>${result.price}</td>
        </tr>
    </tbody>
</table>

</body>
</html>