package ru.trandefil.sc.command.project;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.ProjectDTO;
import ru.trandefil.sc.generated.ProjectEndPoint;
import ru.trandefil.sc.generated.Session;

import java.util.List;

public class ProjectListCommand extends AbstractCommand {

    public ProjectListCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public ProjectListCommand() {
    }

    @Override
    public String command() {
        return "project-list";
    }

    @Override
    public String description() {
        return "show all created projects";
    }

    @Override
    public void execute() {
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final Session session = getServiceLocator().getSession();
        final List<ProjectDTO> projects = projectEndPoint.getAllProjects(session);
        if(projects == null){
            return;
        }
        projects.forEach(System.out::println);
    }

    @Override
    public boolean secure() {
        return true;
    }

}
