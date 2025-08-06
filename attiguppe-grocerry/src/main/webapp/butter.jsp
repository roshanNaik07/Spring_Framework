<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>butter.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
</head>
<body>

<h1> Add this item to the cart</h1>

<br>

<form action="butter" method="post">

    Butter brand : <input type="text" name="brand"/>
    <br>
    Butter Price : <input type="number" name="price">
    <br>

    <input class="btn btn-primary" type="submit" value="Add Butter" />

</form>

</body>
</html>