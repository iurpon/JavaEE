package ru.trandefil.sc.command.user;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.Session;
import ru.trandefil.sc.generated.UserEndPoint;
import ru.trandefil.sc.service.TerminalService;

import static ru.trandefil.sc.util.UserInputUtil.getNotNullString;

public class UserDeleteCommand extends AbstractCommand {

    public UserDeleteCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserDeleteCommand() {
    }

    @Override
    public String command() {
        return "user-delete";
    }

    @Override
    public String description() {
        return "delete user.";
    }

    @Override
    public void execute() {
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final Session session = getServiceLocator().getSession();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "enter user name to delete");
        final boolean deleting = userEndPoint.deleteUserByName(userName, session);
        if (!deleting) {
            System.out.println("bad user name.");
            return;
        }
        System.out.println("user deleted succefully");
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

}
