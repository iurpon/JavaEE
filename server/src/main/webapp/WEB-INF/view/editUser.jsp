<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Project</title>
    <link rel="stylesheet" type="text/css" href="resources/css/input1.css">
    <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
</head>
<body>
<ul class="menu">
    <li><a class="menu" href="projects">See all Project</a></li>
    <li><a class="menu" href="tasks">See all Tasks</a></li>
    <li><a class="menu" href="index.html">Home</a></li>
</ul>
<c:set var="actions" value="${action}"/>
<c:if test="${actions eq 'update'}">
    <%--<jsp:useBean id="user" type="ru.trandefil.sc.model.User" scope="request"/>--%>
    <c:set var="user" value="${updating}"/>
    <form method="post" action="updateUser" class="ui-form">
        <h3>Update User data</h3>
        <input type="hidden" name="id" value="${user.id}">
        <div class="form-row">
            <input type="text" id="name" value="${user.userName}" name="name" required autocomplete="off"><label
                for="name">Name</label>
        </div>
        <div class="form-row">
            <input type="password" id="password" value="${user.password}" name="password" required
                   autocomplete="off"><label
                for="name">Password</label>
        </div>
        <div class="form-row">
            <input type="text" id="role" value="${user.role}" name="role" list="roles" required
                   autocomplete="off"><label for="role">Role</label>
            <datalist id="roles">
                <option value="ADMIN">
                <option value="USER">
            </datalist>
        </div>
        <p><input type="submit" value="Save"></p>
    </form>
</c:if>
<c:if test="${actions eq 'create'}">
    <form method="post" action="addUser" class="ui-form">
        <h3>Input User Data</h3>
        <div class="form-row">
            <input type="text" id="name" name="name" required autocomplete="off"><label for="name">Name</label>
        </div>
        <div class="form-row">
            <input type="password" id="password" name="password" required autocomplete="off"><label
                for="name">Password</label>
        </div>
        <div class="form-row">
            <input type="text" id="role" name="role" list="roles" required autocomplete="off"><label
                for="role">Role</label>
            <datalist id="roles">
                <option value="ADMIN">
                <option value="USER">
            </datalist>
        </div>
        <p><input type="submit" value="Save"></p>
    </form>
</c:if>

</body>
</html>