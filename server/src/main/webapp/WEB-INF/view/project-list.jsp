<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="resources/css/menu.css">
      <link rel="stylesheet" type="text/css" href="resources/css/blueTable.css">

  </head>
  <p>
  <ul class="menu">
      <li><a class="menu" href="addProject">Add New Project</a></li>
      <li><a class="menu" href="tasks">See all Tasks</a></li>
      <li><a class="menu" href="index.html">Home</a></li>
      <li><a class="menu" href="logout">Logout</a></li>
      <li><a class="menu" href="users">See all Users</a></li>
  </ul>
  </p>
  <body>
   <table class = "blueTable">
       <thead>
           <th>Name</th>
           <th>Description</th>
           <th>Action</th>
           <th>Action</th>
           <th>Action</th>
       </thead>
        <c:forEach items="${items}" var="project" varStatus="status">
            <tfoot>
                 <td>${project.name}</td>
                 <td>${project.description}</td>
                <td><a href="updateProject?id=${project.id}">Update</a></td>
                <td><a href="deleteProject?id=${project.id}">Delete</a></td>
                <td><a href="addTask?id=${project.id}">Add Task</a></td>
             </tfoot>
        </c:forEach>
   </table>
  </body>
</html>
