<%--
  Created by IntelliJ IDEA.
  User: Zuzulevs
  Date: 01.02.2022
  Time: 4:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {background-color: #64e7f7;}
    h1   {color: #1515eb; font-size: 70px; font-style: oblique;
        font-family: "Century Gothic"; text-align: center}
    h2 {color: #e2270f; font-style: oblique;
        font-family: "Century Gothic"; text-align: center;
        font-size: 50px
    }
</style>
<head>
    <title>Authorization</title>
</head>
<body>
<h1>Пройдите авторизацию</h1>

<form action=/authorization method="post">
    <h2>
        <input type="text" name="name" required placeholder="Введите логин"/>
        <input type="password" name="password" required placeholder="Введите пароль"/>
        <input type="submit" value="Ввод"><br><br>
    </h2>
</form>
</body>
</html>
