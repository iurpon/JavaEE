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
    <c:set var="actions" value="${action}"/>
    <c:if test = "${actions eq 'create'}">
        <form method="post" action="addTask" class="ui-form">
            <h3>Input Task data</h3>
            <input type="hidden" name="id" value="${projectId}">
            <div class="form-row">
                <input type="text"  id="name" name="name" required autocomplete="off"><label for="name">Name</label>
            </div>
            <div class="form-row">
                <input type="text"  id="description" name="description" required autocomplete="off"><label for="description">Description</label>
            </div>
                        <div class="form-row">
                            <input type="date"  id="date" name="start" required autocomplete="off"><label for="date">Task start</label>
                        </div>
                                    <div class="form-row">
                                        <input type="date"  id="date" name="end" required autocomplete="off"><label for="date">Task end</label>
                                    </div>
            <p><input type="submit" value="Save"></p>
        </form>
    </c:if>
    <c:if test = "${actions eq 'update'}">
        <%--<jsp:useBean id="task" type="ru.trandefil.sc.model.Task" scope="request"/>--%>
        <c:set var="task" value="${taskEntity}"/>
        <form method="post" action="updateTask" class="ui-form">
            <h3>Update Task data</h3>
            <input type="hidden" name="id" value="${task.id}">
            <div class="form-row">
                <input type="text" id="name"  value="${task.name}" name="name"
                       required autocomplete="off"><label for="name">Name</label>
            </div>
            <div class="form-row">
                <input type="text" id="description" value="${task.description}" name="description"
                       required autocomplete="off"><label for="description">Description</label>
            </div>
            <div class="form-row">
                <input type="text" id="project" value="${task.project.name}" name="projectName"
                       required autocomplete="off" readonly><label for="project">Project</label>
            </div>
                        <div class="form-row">
                            <input type="date" id="start" value="${task.start}" name="start"
                                   required autocomplete="off" ><label for="start">Start Task</label>
                        </div>
                        <div class="form-row">
                            <input type="date" id="end" value="${task.end}" name="end"
                                   required autocomplete="off" ><label for="end">End Task</label>
                        </div>
            <p><input type="submit" value="Save"></p>
        </form>
    </c:if>

</body>
</html>