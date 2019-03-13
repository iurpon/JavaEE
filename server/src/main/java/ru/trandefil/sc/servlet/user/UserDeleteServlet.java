package ru.trandefil.sc.servlet.user;

import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/deleteUser")
public class UserDeleteServlet extends HttpServlet {

    @Inject
    private UserService userService;

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("User delete doGet()");
        final String id = req.getParameter("id");
        final User byId = userService.getById(id);
        userService.delete(byId);
        resp.sendRedirect("web/users");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
