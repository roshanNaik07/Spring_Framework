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

<table class="table">
    <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Phone No</th>
            <th>Price</th>
        </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${data}">
        <tr>
            <td>${item.name}</td>
            <td>${item.email}</td>
            <td>${item.phoneNo}</td>
            <td>${item.price}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>