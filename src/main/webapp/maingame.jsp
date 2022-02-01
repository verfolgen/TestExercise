<%@ page import="random.RandomNumber" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.HashSet" %>
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
<body>

<div id="action_form" style="left: 50%;margin-left: -150px;position: absolute;width: 1000px;margin-top: 20%;">
<form action="/game" method="post" >
    <input type="text" id="number" name="number" />
    <input type="submit"/>

</form>
</div>

<h1><%
    String result =(String) request.getAttribute("result");
%>
<%=result%>
</h1>

<h1>
    <%ArrayList <String> integers = (ArrayList) request.getAttribute("tries");%>
    <%=integers%>



</h1>


</body>
</html>
