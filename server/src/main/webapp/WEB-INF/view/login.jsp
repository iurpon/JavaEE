<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Project Create</title>
    <link rel="stylesheet" type="text/css" href="resources/css/input1.css">
    <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
</head>
<body>

    <ul class="menu">
        <li><a class="menu" href="projects">See all Project</a></li>
        <li><a class="menu" href="tasks">See all Tasks</a></li>
    </ul>
    <form method="post" action="login" class="ui-form">
        <h3 class="whiteTextOverride">${message}</h3>
        <h3>Log In</h3>
        <div class="form-row">
            <input type="text"  id="name" name="name" required autocomplete="off"><label for="name">Name</label>
        </div>
        <div class="form-row">
            <input type="password"  id="password" name="password" required autocomplete="off"><label for="password">Password</label>
        </div>
        <p><input type="submit" value="LogIn"></p>
    </form>

</body>
</html>