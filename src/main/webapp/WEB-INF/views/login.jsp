<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Balaji
  Date: 02/11/16
  Time: 10:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in Page - Baali</title>
</head>
<body>
<h3>My Custom Login Page</h3>
<c:url value="/login" var="loginPage"/>
<form action="${loginPage}" method="post">
    UserName: <input type="text" name="username" required /><br/>
    Password: <input type="password" name="password" required/><br />
    <input type="submit" value="Submit..." />

</form>
</body>
</html>
