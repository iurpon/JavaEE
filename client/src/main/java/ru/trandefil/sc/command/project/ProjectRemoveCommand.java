package ru.trandefil.sc.command.project;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.ProjectEndPoint;
import ru.trandefil.sc.generated.Session;
import ru.trandefil.sc.service.TerminalService;

import static ru.trandefil.sc.util.UserInputUtil.getNotNullString;

public class ProjectRemoveCommand extends AbstractCommand {

    public ProjectRemoveCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectRemoveCommand() {
    }

    @Override
    public String command() {
        return "project-remove";
    }

    @Override
    public String description() {
        return "remove project";
    }

    @Override
    public void execute() {
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final Session session = getServiceLocator().getSession();
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final String removingProject = getNotNullString(terminalService, "enter project name to delete");
        projectEndPoint.deleteProjectByName(removingProject, session);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
