package ru.trandefil.sc.servlet.task;

import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Project;
import ru.trandefil.sc.model.Task;
import ru.trandefil.sc.util.DateUtil;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String projectId = request.getParameter("id");
        if (projectId.isEmpty() || projectId == null) {
            logger.info("error -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final Project project = projectService.getById(projectId);
        final String name = request.getParameter("name");
        if (name.isEmpty() || name == null) {
            logger.info("error -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final String description = request.getParameter("description");
        if (description.isEmpty() || description == null) {
            logger.info("error -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final String start = request.getParameter("start");
        final Date starting = DateUtil.fromString(start);

        final String end = request.getParameter("end");
        final Date ending = DateUtil.fromString(end);
        System.out.println(start);
        System.out.println(end);
        final Task task = new Task(null, name, description, starting, ending, project);
        taskService.save(task);
        response.sendRedirect("tasks");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("AddTaskServlet doGet()");
        final String projecId = request.getParameter("id");
        request.setAttribute("projectId", projecId);
        request.setAttribute("action", "create");
        request.getRequestDispatcher("/WEB-INF/view/editTask.jsp").forward(request, response);
    }
}
