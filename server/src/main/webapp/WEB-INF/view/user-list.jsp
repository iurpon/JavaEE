<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
    <link rel="stylesheet" type="text/css" href="resources/css/blueTable.css">
</head>
<p>
<ul class="menu">
    <li><a class="menu" href="projects">See all Project</a></li>
    <li><a class="menu" href="index.html">Home</a></li>
    <li><a class="menu" href="logout">Logout</a></li>
    <li><a class="menu" href="tasks">See all Tasks</a></li>
    <li><a class="menu" href="addUser">Add New User</a></li>
</ul>
</p>
<body>
<table class="blueTable">
    <thead>
        <th>Name</th>
        <th>Role</th>
        <th>Action</th>
        <th>Action</th>
    </thead>
    <c:forEach items="${users}" var="user" varStatus="status">
    <tfoot>
        <td>${user.userName}</td>
        <td>${user.role}</td>
        <td><a href="updateUser?id=${user.id}">Update</a></td>
        <td><a href="deleteUser?id=${user.id}">Delete</a></td>
    </tfoot>
    </c:forEach>
 </table>
</body>
</html>