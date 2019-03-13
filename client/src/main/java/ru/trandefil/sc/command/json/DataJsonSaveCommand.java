package ru.trandefil.sc.command.json;

import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.AdminEndPoint;
import ru.trandefil.sc.generated.Session;

public class DataJsonSaveCommand extends AbstractCommand {

    @Override
    public String command() {
        return "data-json-save";
    }

    @Override
    public String description() {
        return "convert object to json and save it to file. Admin only";
    }

    @Override
    public void execute() {
        final AdminEndPoint adminEndPoint = getServiceLocator().getAdminEndPoint();
        final Session session = getServiceLocator().getSession();
        adminEndPoint.saveJson(session);
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
