<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Domino's</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
</head>
<body>

<div class="d-flex justify-content-center py-5">
    <h1>Order Details</h1>
</div>

<div class="container-fluid d-flex justify-content-center align-items-center ">
    <div>
        <span style="color:red">${error}</span>
        <form action="order" method="post" >

            <div class="mb-3">
                <label  class="form-label">Enter Name</label>
                <input type="text" class="form-control" name="name" value="${value.name}">
            </div>
            <div class="mb-3">
                <label  class="form-label">email</label>
                <input type="text" class="form-control" name="email" value="${value.email}">
            </div>
            <div class="mb-3">
                <label  class="form-label">Phone Number</label>
                <input type="text" class="form-control" name="phoneNo" value="${value.phoneNo}">
            </div>

            <div class="mb-3">
                <label  class="form-label">price</label>
                <input type="number" class="form-control" name="price" value="${value.price}">
            </div>

            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>

</div>

</body>
</html>