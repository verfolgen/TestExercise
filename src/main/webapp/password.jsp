<%--
  Created by IntelliJ IDEA.
  User: Zuzulevs
  Date: 01.02.2022
  Time: 11:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Password</title>
    <style>
        body {background-color: #64e7f7;}
        h1   {color: #1515eb; font-size: 70px; font-style: oblique;
            font-family: "Century Gothic"; text-align: center}
        h2 {color: #e2270f; font-style: oblique;
            font-family: "Century Gothic"; text-align: center;
            font-size: 50px
        }
    </style>
</head>
<body>

<h1>Пройдите регистрацию или авторизуйтесь</h1>


<form action="authorization.jsp">
    <h2>
        <input type="submit" value="">Авторизация<br><br>
    </h2>
</form>

<form action="registration.jsp">
    <h2>
        <input type="submit" value="">Регистрация<br><br>
    </h2>
</form>
</body>
</html>
