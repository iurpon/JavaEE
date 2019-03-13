package ru.trandefil.sc.servlet.task;

import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Task;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.util.SessionUtil;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/deleteTask")
public class DeleteTaskServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private TaskService taskService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DeleteTaskServlet doPost()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("DeleteTaskServlet doGet()");
        final String id = request.getParameter("id");
        final User current = SessionUtil.getLoginUser(request.getSession());
        final Task byid = taskService.getByid(current.getId(), id);
        taskService.delete(current.getId(),byid);
        response.sendRedirect("tasks");
    }
}
