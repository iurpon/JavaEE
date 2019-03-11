package ru.trandefil.sc.servlet.project;

import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.model.Project;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/addProject")
public class AddProjectServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private ProjectService projectService;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("AddProjectServlet doPost()");
        final String name = request.getParameter("name");
        if(name.isEmpty() || name == null){
            logger.info("error -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final String description = request.getParameter("description");
        if(name.isEmpty()){
            logger.info("error -------------------------------------------");
            response.sendRedirect("error");
            return;
        }
        final Project project = new Project(null, name, description);
        projectService.save(project);
        response.sendRedirect("projects");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("AddProjectServlet doGet()");
        request.setAttribute("action","create");
        request.getRequestDispatcher("/WEB-INF/view/editProject.jsp").forward(request,response);
    }

}
