package ru.trandefil.sc.servlet.project;

import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.model.Project;
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

@WebServlet("/projects")
public class ProjectListServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private ProjectService projectService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("ProjectLIstServlet doGet");
        final User current = SessionUtil.getLoginUser(req.getSession());
        final List<Project> list = projectService.getAll(current.getId());
        req.setAttribute("projects", list);
        req.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("/WEB-INF/view/project-list.jsp").forward(req, resp);
    }

}
