<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 20.09.2021
  Time: 8:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Table</title>
</head>
<body>
<div>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
        </tr>
        <tr>
            <th>${user.getId()}</th>
            <th>${user.getName()}</th>
            <th>${user.getEmail()}</th>
            <th>${user.getPhone()}</th>
        </tr>
    </table>
    <form action="${pageContext.request.contextPath}/PutName" method="post">
    <input type="text" name="id" value="<%= request.getParameter("namee")%>">
</form>
</div>
</body>
</html>
