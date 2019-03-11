package ru.trandefil.sc.servlet.user;

import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.User;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/updateUser")
public class UserUpdateServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("-------------------------------------User update doGet() ");
        final String id = req.getParameter("id");
        final User user = userService.getById(id);
        req.setAttribute("updating", user);
        req.setAttribute("action", "update");
        req.getRequestDispatcher("/WEB-INF/view/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("-------------------------------------User update doPost");
        final String id = req.getParameter("id");
        final String name = req.getParameter("name");
        final String password = req.getParameter("password");
        final String role = req.getParameter("role");
        final User user = new User(id, name, password, Enum.valueOf(Role.class, role));
        userService.save(user);
        resp.sendRedirect("users");
    }
}
