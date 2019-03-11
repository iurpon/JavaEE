<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Tasks</title>
    <link rel="stylesheet" type="text/css" href="resources/css/input1.css">
    <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
</head>
<body>
    <ul class="menu">
        <li><a class="menu" href="projects">See all Project</a></li>
        <li><a class="menu" href="index.html">Home</a></li>
    </ul>
    <form method="post" action="addTask" class="ui-form">
        <h3>Input Task data</h3>
        <input type="hidden" name="id" value="${projectId}">
        <div class="form-row">
            <input type="text"  id="name" name="name" required autocomplete="off"><label for="name">Name</label>
        </div>
        <div class="form-row">
            <input type="text"  id="description" name="description" required autocomplete="off"><label for="description">Description</label>
        </div>
        <p><input type="submit" value="Save"></p>
    </form>
<%--    <form method="post" action="addTask">
        <input type="hidden" name="id" value="${projectId}">

        <dl>
            <dt>Name:</dt>
            <dd><input type="text" value=""  name="name"></dd>
        </dl>
        <dl>
            <dt>Description:</dt>
            <dd><input type="text" value="" size=40 name="description"></dd>
        </dl>
        <button type="submit">Save</button>
    </form>--%>

</body>
</html>