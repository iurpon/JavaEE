package ru.trandefil.sc.command.project;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.ProjectDTO;
import ru.trandefil.sc.generated.ProjectEndPoint;
import ru.trandefil.sc.generated.Session;
import ru.trandefil.sc.service.TerminalService;

import static ru.trandefil.sc.util.UserInputUtil.getNotNullString;

public class ProjectCreateCommand extends AbstractCommand {

    public ProjectCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectCreateCommand() {
    }

    @Override
    public String command() {
        return "project-create";
    }

    @Override
    public String description() {
        return "create new project";
    }

    @Override
    public void execute() {
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String projectName = getNotNullString(terminalService, "enter project name");
        final String projectDesc = getNotNullString(terminalService, "enter project desсription");
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final Session session = getServiceLocator().getSession();
        ProjectDTO project = projectEndPoint.saveProject(projectName, projectDesc, session);
        if(project != null){
            System.out.println("saved succesfully");
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
