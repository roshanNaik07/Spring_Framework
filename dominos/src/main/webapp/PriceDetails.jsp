<!doctype html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>PriceDetails.jsp</title>
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">

</head>
<body>

<div class="d-flex justify-content-center py-5">
    <h1>Check names for <b>Price</b> above</h1>
</div>

<div class="container-fluid d-flex justify-content-center align-items-center ">
    <div>
        <span style="color:red" class="py-5">${error}</span>
        <form action="getNames" method="post" >
            <div class="mb-3">
                <label  class="form-label">Enter Price</label>
                <input type="number" class="form-control" name="price">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

<h3>Names : </h3>

    <c:forEach var="item" items="${data}">
        <h5>${item}</h5>
    </c:forEach >

</body>
</html>