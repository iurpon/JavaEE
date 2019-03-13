package ru.trandefil.sc.command.json;

import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.AdminEndPoint;
import ru.trandefil.sc.generated.Session;

public class DataJsonLoadCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-load";
    }

    @Override
    public String description() {
        return "load json from file and cache it. Admin only,";
    }

    @Override
    public void execute() {
        final AdminEndPoint adminEndPoint = getServiceLocator().getAdminEndPoint();
        final Session session = getServiceLocator().getSession();
        adminEndPoint.loadJson(session);
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
