package ru.trandefil.sc.servlet.user;

import ru.trandefil.sc.api.UserService;

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
//        final UserService userService = ServiceLocator.getUserService();
        userService.deleteById(id);
//        req.getRequestDispatcher("/WEB-INF/view/user-list.jsp");
        resp.sendRedirect("users");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

}
