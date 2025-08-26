<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>index.jsp</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-LN+7fdVzj6u52u30Kp6M/trliBMCMKTyK833zpbD+pXdCLuTusPj697FH4R/5mcr" crossorigin="anonymous">
    <%@ page isELIgnored="false" %>
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.7/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ndDqU0Gzau9qJ1lfW4pNLlhNTkCfHzAVBReH9diLvGRem5+R9g2FzA8ZGN954O5Q"
        crossorigin="anonymous"></script>

<nav class="navbar bg-body-tertiary shadow-sm p-3 mb-5 bg-body-tertiary" data-bs-theme="dark">
    <div class="container">
        <a class="navbar-brand" href="/">
            <img src="images/x-workzLogo.png" alt="Bootstrap" width="160" height="70">
        </a>
    </div>
    <div>
        <form class="container-fluid justify-content-start">
            <a href="SignIn.jsp" class="btn btn-outline-warning me-2 btn-lg shadow-sm">Sign In</a>
            <a href="SignUp.jsp" class="btn btn-outline-warning me-2 btn-lg shadow-sm">Sign Up</a>
        </form>
    </div>
</nav>

<h3 style="color:green">${updatedPassword}</h3>

<div class="container py-5">
    <div class="clearfix">
        <img src="images/classRoom.png" class="col-md-6 float-md-end mb-3 ms-md-3" alt="Class Room img" width="100"
             height="400">

        <p>
            X-Workz Training Center in Bangalore is a leading institute dedicated to transforming fresh graduates and
            aspiring professionals into industry-ready talent. With a strong focus on practical learning, real-time
            projects, and expert mentorship, the center bridges the gap between academic knowledge and corporate
            expectations. Our mission is to empower students with the right skills, confidence, and discipline to excel
            in the fast-paced IT industry. </p>

        <p>
            We specialize in providing hands-on training in cutting-edge technologies including Java, Python, Web
            Development, Cloud Computing, and more. Our well-structured curriculum is designed in alignment with current
            industry demands, ensuring that every learner is equipped with relevant and updated knowledge. At X-Workz,
            we combine classroom learning with live projects, mock interviews, and career guidance to prepare students
            for real-world challenges. </p>

        <p>
            Located in the heart of Bangalore, X-Workz Training Center has emerged as a trusted destination for students
            and professionals aspiring to build a successful career in the IT industry. Over the years, we have
            successfully trained and placed numerous candidates in reputed multinational companies and growing startups,
            proving our commitment to quality education and career development. Our team of dedicated trainers brings in
            rich industry experience and a passion for teaching, ensuring that every learner not only understands
            concepts but can also apply them effectively in real-world scenarios.

        </p>
    </div>
</div>

</body>
</html>