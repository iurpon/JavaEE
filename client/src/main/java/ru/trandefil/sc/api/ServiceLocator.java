package ru.trandefil.sc.api;

import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.*;
import ru.trandefil.sc.service.TerminalService;

import java.util.Map;

public interface ServiceLocator {

    TerminalService getTerminalService();

    Map<String, AbstractCommand> getCommandMap();

    ProjectEndPoint getProjectEndPoint();

    TaskEndPoint getTaskEndPoint();

    UserEndPoint getUserEndPoint();

    AdminEndPoint getAdminEndPoint();

    Session getSession();

    void setSession(Session session);

}
