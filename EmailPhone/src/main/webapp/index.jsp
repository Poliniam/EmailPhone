<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>NameEmailPhone</title>
</head>
<body>
<div>
    <form action="${pageContext.request.contextPath}/PutName" method="post">
        <input type="text" name="namme" placeholder="Name">
        <input type="submit" name="one" value="Find name">
    </form>
    <form action="${pageContext.request.contextPath}/ShowAll" method="post">
        <input type="submit" name="all" value="Show all users">
    </form>
</div>
</body>
</html>