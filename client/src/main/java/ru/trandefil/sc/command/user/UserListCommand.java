package ru.trandefil.sc.command.user;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.Session;
import ru.trandefil.sc.generated.UserDTO;
import ru.trandefil.sc.generated.UserEndPoint;

import java.util.List;

public class UserListCommand extends AbstractCommand {

    public UserListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public UserListCommand() {
    }

    @Override
    public String command() {
        return "user-list";
    }

    @Override
    public String description() {
        return "show all users";
    }

    @Override
    public void execute() {
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final Session session = getServiceLocator().getSession();
        final List<UserDTO> userList = userEndPoint.getAllUsers(session);
        if(userList.isEmpty()){
            System.out.println("list is empty");
            return;
        }
        userList.forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return true;
    }

    @Override
    public boolean isAdmin() {
        return false;
    }
}
