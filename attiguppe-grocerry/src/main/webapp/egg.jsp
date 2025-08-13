<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>egg.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>

</head>
<body>

<h1> Add this item to the cart</h1>

<br>

<form action="egg" method="post">

    Egg size : <input type="text" name="size"/>
    <br>
    Egg Price : <input type="number" name="price">
    <br>

    <input class="btn btn-primary" type="submit" value="Add Egg" />

</form>
<div>
    <h2>Details :</h2>
    Egg Size : <h4>${size}</h4>
    Egg price: <h4>${price}</h4>
</div>
</body>
</html>