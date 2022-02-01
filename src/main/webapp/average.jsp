<%@ page import="javax.persistence.criteria.CriteriaBuilder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <style>
        body {background-color: #64e7f7;}
        h1   {color: #1515eb; font-size: 70px; font-style: oblique;
            font-family: "Century Gothic"; text-align: center}
        h2 {color: #e2270f; font-style: oblique;
            font-family: "Century Gothic"; text-align: center;
            font-size: 50px
        }
    </style>
    <title>Average</title>
</head>
<body>
<h1>Среднее число попыток</h1>

<%
    Double average = (Double) request.getAttribute("average");
%>
<table border="1"; align="center">
    <tr>
        <th><h1> Количество попыток</h1></th>
    </tr>

    <tr>
        <td><h1><%=average%></h1></td>
    </tr>
</table>

</body>
</html>
