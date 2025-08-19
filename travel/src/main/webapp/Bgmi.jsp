<!doctype html>
<html lang="en" xmlns:c="">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bgmi.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>

<div class="d-flex justify-content-center py-5">
    <h1>Bgmi Details</h1>
</div>

<div class="container-fluid d-flex justify-content-center align-items-center ">
    <div>

        <form action="bgmi" method="post" >

            <div class="mb-3">
                <label  class="form-label">Game name</label>
                <input type="text" class="form-control" name="gameName" >
            </div>
            <div class="mb-3">
                <label  class="form-label">founder</label>
                <input type="text" class="form-control" name="founder">
            </div>
            <div class="mb-3">
                <label  class="form-label">Player Name</label>
                <input type="text" class="form-control" name="playerName">
            </div>

            <div class="mb-3">
                <label  class="form-label">email</label>
                <input type="text" class="form-control" name="email">
            </div>

            <div class="mb-3">
                <label  class="form-label">Gun Name</label>
                <input type="text" class="form-control" name="gunName">
            </div>

            <div class="mb-3">
                <label  class="form-label">Age</label>
                <input type="number" class="form-control" name="age">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

</body>
</html>