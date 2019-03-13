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

@WebServlet("/updateTask")
public class UpdateTaskServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private TaskService taskService;

    @Inject
    private UserService userService;

    @Inject
    private ProjectService projectService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("===============================================UpdateTaskServlet doPost()");
        final String id = request.getParameter("id");
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
        final User current = SessionUtil.getLoginUser(request.getSession());
        final String projectId = request.getParameter("projectId");
        final Project project  = projectService.getById(projectId,current.getId());
        final String start = request.getParameter("start");
        final Date starting = DateUtil.fromString(start);
        final String end = request.getParameter("end");
        final Date ending = DateUtil.fromString(end);
        final String executorName = request.getParameter("executorName");
        final User executor = userService.getByName(executorName);
        if(executor == null){
            logger.info("  =================================== executor is null");
        }
        final Task task = taskService.getByid(current.getId(),id);
        task.setName(name);
        task.setDescription(description);
        task.setStart(starting);
        task.setEnd(ending);
        task.setExecutor(executor);
        taskService.save(current.getId(),task);
        response.sendRedirect("tasks");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("UpdateTaskServlet doGet()");
        final String id = request.getParameter("id");
        final User current = SessionUtil.getLoginUser(request.getSession());
        final Task task = taskService.getByid(current.getId(),id);
        request.setAttribute("taskEntity", task);
        request.setAttribute("action", "update");
        request.getRequestDispatcher("/WEB-INF/view/editTask.jsp").forward(request, response);
    }

}
