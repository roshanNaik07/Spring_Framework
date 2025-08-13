<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>onion.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>

</head>
<body>

<h1> Add this item to the cart</h1>

<br>

<form action="onion" method="post">

    Onlion size : <input type="text" name="size"/>
    <br>
    Onion Price : <input type="number" name="price">
    <br>
    <input class="btn btn-primary" type="submit" value="Add Onion" />

</form>
<div>
    <h2>Details :</h2>
    Onion Size : <h4>${size}</h4>
    Onion price: <h4>${price}</h4>
</div>
</body>
</html>