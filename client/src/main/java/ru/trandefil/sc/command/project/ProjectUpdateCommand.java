package ru.trandefil.sc.command.project;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.ProjectDTO;
import ru.trandefil.sc.generated.ProjectEndPoint;
import ru.trandefil.sc.generated.Session;
import ru.trandefil.sc.service.TerminalService;

import static ru.trandefil.sc.util.UserInputUtil.getNotNullString;

public class ProjectUpdateCommand extends AbstractCommand {

    public ProjectUpdateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectUpdateCommand() {
    }

    @Override
    public String command() {
        return "project-update";
    }

    @Override
    public String description() {
        return "update project";
    }

    @Override
    public void execute() {
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final Session session = getServiceLocator().getSession();
        final String updatedName = getNotNullString(terminalService,"enter updated project name");
        final ProjectDTO updating = projectEndPoint.getProjectByName(updatedName,session);
        if(updating == null){
            return;
        }
        final String newName = getNotNullString(terminalService,"enter new project name");
        final String newDesc = getNotNullString(terminalService,"enter new description name");
        updating.setName(newName);
        updating.setDescription(newDesc);
        projectEndPoint.updateProject(updating,session);
    }

    @Override
    public boolean secure() {
        return true;
    }
}
