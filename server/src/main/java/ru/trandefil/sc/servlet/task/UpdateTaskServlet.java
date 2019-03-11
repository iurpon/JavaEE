package ru.trandefil.sc.servlet.task;

import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Task;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/updateTask")
public class UpdateTaskServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private TaskService taskService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("UpdateTaskServlet doPost()");
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
        final Task task = taskService.getById(id);
        task.setName(name);
        task.setDescription(description);
        taskService.save(task);
        response.sendRedirect("tasks");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("UpdateTaskServlet doGet()");
        final String id = request.getParameter("id");
        final Task task = taskService.getById(id);
        request.setAttribute("taskEntity", task);
        request.setAttribute("action", "update");
        request.getRequestDispatcher("/WEB-INF/view/editTask.jsp").forward(request, response);
    }

}
