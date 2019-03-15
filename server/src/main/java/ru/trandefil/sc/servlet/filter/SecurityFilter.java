package ru.trandefil.sc.servlet.filter;

import ru.trandefil.sc.model.User;
import ru.trandefil.sc.util.SessionUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;
import java.util.logging.Logger;

@WebFilter("/*")
public class SecurityFilter implements Filter {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("============================================= Security Filter init()");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        logger.info("-------------------------------- filter starts ");
        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) resp;
        final String servletPath = request.getServletPath();
        logger.info("========================================================== servletPath :" + servletPath);
        if(servletPath.contains("EndPoint")){
            logger.info("======================================== THIS IS ENDPOINT NO SECURITY");
            chain.doFilter(request, response);
            return;
        }

        // Информация пользователя сохранена в Session
        // (После успешного входа в систему).
        final User loginUser = SessionUtil.getLoginUser(request.getSession());
        logger.info("----------------------------- user READY ? : " + loginUser);
        logger.info("============================================== Servlet Path : " + servletPath);
        if (servletPath.equals("/login")) {
            logger.info("============================================== Servlet Path equals /login: ");
            chain.doFilter(request, response);
            return;
        }
        if (loginUser == null) {
            logger.info("======================================= forward login form");
//            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
            response.sendRedirect("login");
            return;
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }

}
