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
import java.util.List;
import java.util.logging.Logger;

@WebServlet("/addUser")
public class UserCreateServlet extends HttpServlet {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private UserService userService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("----------------------------------------CreateUserServlet doGet()");
        req.setAttribute("action", "create");
        req.getRequestDispatcher("/WEB-INF/view/editUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        logger.info("------------------------------------------------CreateUserServlet doPost");
        final String name = req.getParameter("name");
        final String password = req.getParameter("password");
        final String role = req.getParameter("role");
//        final UserService userService = ServiceLocator.getUserService();
        final User user = new User(null, name, password, Enum.valueOf(Role.class, role));
        userService.save(user);
        List<User> all = userService.getAll();
        req.setAttribute("users", all);
        req.getRequestDispatcher("/WEB-INF/view/user-list.jsp").forward(req, resp);
    }
}
