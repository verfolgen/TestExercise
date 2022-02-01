<%@ page import="java.util.ArrayList" %>
<%@ page import="models.CheckList" %>
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
    <title>Таблица</title>
</head>
<body>
<h1>Таблица рекордов</h1>
<%
    ArrayList <CheckList> checkLists = (ArrayList) request.getAttribute("checksFromServer");
%>
<table border="1"; align="center">
    <tr>
       <th><h1> Количество попыток</h1></th>
    </tr>
<%for (CheckList check: checkLists) {%>
    <tr>
        <td><h1><%=check.getTrycount()%></h1></td>
    </tr>
<%}%>
</table>


</body>
</html>
