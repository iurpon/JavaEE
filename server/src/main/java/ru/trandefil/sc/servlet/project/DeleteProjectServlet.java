package ru.trandefil.sc.servlet.project;

import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Project;
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
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@WebServlet("/deleteProject")
public class DeleteProjectServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private ProjectService projectService;

    @Inject
    private TaskService taskService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("==================================DeleteProjectServlet doPost()");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("=====================================DeleteProjectServlet doGet()");
        final String id = request.getParameter(("id"));
        final User current = SessionUtil.getLoginUser(request.getSession());
        projectService.deleteById(current.getId(),id);
        response.sendRedirect("projects");
    }

}
