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
    <li><a class="menu" href="users">See all Users</a></li>
</ul>
</p>
<body>
<table class="blueTable">
    <thead>
        <th>Name</th>
        <th>Description</th>
        <th>Project</th>
        <th>Start Date</th>
        <th>End Date</th>
        <th>Action</th>
        <th>Action</th>
    </thead>
    <c:forEach items="${tasks}" var="task" varStatus="status">
    <tfoot>
        <td>${task.name}</td>
        <td>${task.description}</td>
        <td>${task.project.name}</td>
        <td><fmt:formatDate value="${task.start}" pattern="yyyy-MM-dd"/></td>
        <td><fmt:formatDate value="${task.end}" pattern="yyyy-MM-dd"/></td>
        <td><a href="updateTask?id=${task.id}">Update</a></td>
        <td><a href="deleteTask?id=${task.id}">Delete</a></td>
    </tfoot>
    </c:forEach>
 </table>
</body>
</html>
