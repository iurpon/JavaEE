package ru.trandefil.sc.command.service;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.Session;
import ru.trandefil.sc.generated.UserEndPoint;

public class LogoutCommand extends AbstractCommand {

    public LogoutCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public LogoutCommand() {
    }

    @Override
    public String command() {
        return "logout";
    }

    @Override
    public String description() {
        return "logout user from system.";
    }

    @Override
    public void execute() {
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        Session session = getServiceLocator().getSession();
        userEndPoint.userLogout(session);
        getServiceLocator().setSession(null);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
