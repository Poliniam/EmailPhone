<%@ page import="java.util.ArrayList" %>
<%@ page import="model.User" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 20.09.2021
  Time: 11:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>All Phones</title>
</head>
<body>
<div>
    <table border="1">
        <c:forEach var="user" items="${person}">
            <tr>
                <th><c:out value="${user.getId()}"/></th>
                <th><c:out value="${user.getName()}"/></th>
                <th><c:out value="${user.getEmail()}"/></th>
                <th><c:out value="${user.getPhone()}"/></th>
            </tr>
        </c:forEach>
    </table>
</div>
<form action="${pageContext.request.contextPath}/Delete" method="post">
    <input type="text" name="id" placeholder="Name">
    <input type="submit" name="all" value="Delete this user">
<br>
    <br>
</form>
<form action="${pageContext.request.contextPath}/Insert" method="post">
    <input type="text" name="id_" placeholder="Id">
    <input type="text" name="name_" placeholder="Name">
    <input type="text" name="email_" placeholder="Email">
    <input type="text" name="phone_" placeholder="Phone">
    <input type="submit" name="all" value="Insert new user">
</form>
</body>
</html>
