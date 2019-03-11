package ru.trandefil.sc.util;

import ru.trandefil.sc.model.User;

import javax.servlet.http.HttpSession;
import java.util.logging.Logger;

public class SessionUtil {

    private static Logger logger = Logger.getLogger(SessionUtil.class.getName());

    public static void storeLoginUser(HttpSession session, User loginUser) {
        // На JSP можно получить доступ через ${loginUser}
        logger.info("===================================== sissionUtil storeLoginUser");
        session.setAttribute("loginUser", loginUser);
    }

    // Получить информацию пользователя, сохраненную в Session.
    public static User getLoginUser(HttpSession session) {
        logger.info("===================================== sissionUtil getLoginUser");
        User loginUser = (User) session.getAttribute("loginUser");
        return loginUser;
    }

}
