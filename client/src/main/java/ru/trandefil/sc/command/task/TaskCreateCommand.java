package ru.trandefil.sc.command.task;

import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.generated.*;
import ru.trandefil.sc.service.TerminalService;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static ru.trandefil.sc.util.UserInputUtil.getDate;
import static ru.trandefil.sc.util.UserInputUtil.getNotNullString;

public class TaskCreateCommand extends AbstractCommand {

    public TaskCreateCommand(ServiceLocator serviceLocator) {
        super(serviceLocator);
    }

    public TaskCreateCommand() {
    }

    @Override
    public String command() {
        return "task-create";
    }

    @Override
    public String description() {
        return "create new task for project";
    }

    @Override
    public void execute() {
        final TaskEndPoint taskEndPoint = getServiceLocator().getTaskEndPoint();
        final UserEndPoint userEndPoint = getServiceLocator().getUserEndPoint();
        final ProjectEndPoint projectEndPoint = getServiceLocator().getProjectEndPoint();
        final Session session = getServiceLocator().getSession();
        final TerminalService terminalService = getServiceLocator().getTerminalService();
        final String userName = getNotNullString(terminalService, "name of task executer user");
        final UserDTO executer = userEndPoint.getUserByName(userName, session);
        if (executer == null) {
            System.out.println("wrong user name.");
            return;
        }
        final String projectName = getNotNullString(terminalService, "name of project");
        final ProjectDTO updating = projectEndPoint.getProjectByName(projectName, session);
        if (updating == null) {
            System.out.println("wrong project name");
            return;
        }
        final String taskName = getNotNullString(terminalService, "enter task name");
        final String taskDesc = getNotNullString(terminalService, "enter task description");
        final Date startDate = getDate(terminalService, "enter task start date");
        final Date endDate = getDate(terminalService, "enter task end date");
        try {
            GregorianCalendar c = new GregorianCalendar();
            c.setTime(startDate);
            XMLGregorianCalendar start = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            c.setTime(endDate);
            XMLGregorianCalendar end = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
            TaskDTO created = taskEndPoint.saveTask(null, taskName, taskDesc, start, end,
                    updating.getId(), executer.getId(), session);
            if (created == null) {
                System.out.println("fail to create new task");
                return;
            }
            System.out.println("new task succesfully created");
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean secure() {
        return true;
    }

}
