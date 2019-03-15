package ru.trandefil.sc.servlet.task;

import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.Project;
import ru.trandefil.sc.model.Task;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.util.DateUtil;
import ru.trandefil.sc.util.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Logger;

@WebServlet("/addTask")
public class AddTaskServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private TaskService taskService;

    @Inject
    private ProjectService projectService;

    @Inject
    private UserService userService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("====================================== add task servlet do post");
        final String projectId = request.getParameter("projectId");
        if (projectId.isEmpty() || projectId == null) {
            logger.info("error -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final User current = SessionUtil.getLoginUser(request.getSession());
        final Project project = projectService.getById(projectId,current.getId());
        if(project == null){
            logger.info("project null -------------------------------------------");
            response.sendRedirect("tasks");
            return;
        }
        final String username = request.getParameter("username");
        final User executor = userService.getByName(username);
        if(executor == null){
            logger.info("executor null -------------------------------------------");
            response.sendRedirect("tasks");
            return;
        }
        final String name = request.getParameter("name");
        if (name.isEmpty() || name == null) {
            logger.info("name null  -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final String description = request.getParameter("description");
        if (description.isEmpty() || description == null) {
            logger.info("description null -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final String start = request.getParameter("start");
        final Date starting = DateUtil.fromString(start);

        final String end = request.getParameter("end");
        final Date ending = DateUtil.fromString(end);
        System.out.println(start);
        System.out.println(end);
        final Task task = new Task(null, name, description, starting, ending, project,current,executor);
        taskService.save(current.getId(),task);
        response.sendRedirect("tasks");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("=================================AddTaskServlet doGet()");
        final String projecId = request.getParameter("id");
        request.setAttribute("projectId", projecId);
        request.setAttribute("action", "create");
        request.getRequestDispatcher("/WEB-INF/view/editTask.jsp").forward(request, response);
    }

}
