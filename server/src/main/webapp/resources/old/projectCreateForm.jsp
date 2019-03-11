<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Project Create</title>
    <link rel="stylesheet" type="text/css" href="resources/css/input1.css">
    <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
</head>
<body>
<section>
    <ul class="menu">
        <li><a class="menu" href="projects">See all Project</a></li>
        <li><a class="menu" href="tasks">See all Tasks</a></li>
        <li><a class="menu" href="index.html">Home</a></li>
    </ul>
    <form method="post" action="addProject" class="ui-form">
        <h3>Input Project Data</h3>
        <div class="form-row">
            <input type="text"  id="name" name="name" required autocomplete="off"><label for="name">Name</label>
        </div>
        <div class="form-row">
            <input type="text"  id="description" name="description" required autocomplete="off"><label for="description">Description</label>
        </div>
        <p><input type="submit" value="Save"></p>
    </form>
</section>
</body>
</html>