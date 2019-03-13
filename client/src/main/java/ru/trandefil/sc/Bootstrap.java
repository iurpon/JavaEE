package ru.trandefil.sc;

import org.reflections.Reflections;
import ru.trandefil.sc.api.ServiceLocator;
import ru.trandefil.sc.command.AbstractCommand;
import ru.trandefil.sc.endpoint.AdminEndPointImplService;
import ru.trandefil.sc.endpoint.ProjectEndPointImplService;
import ru.trandefil.sc.endpoint.TaskEndPointImplService;
import ru.trandefil.sc.endpoint.UserEndPointImplService;
import ru.trandefil.sc.generated.*;
import ru.trandefil.sc.service.TerminalService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Bootstrap implements ServiceLocator {

    private Session session = null;

    private final TerminalService terminalService = new TerminalService(new Scanner(System.in));

    private final ProjectEndPoint projectEndPoint =
            new ProjectEndPointImplService().getProjectEndPointImplPort();

    private final TaskEndPoint taskEndPoint = new TaskEndPointImplService().getTaskEndPointImplPort();

    private final UserEndPoint userEndPoint = new UserEndPointImplService().getUserEndPointImplPort();

    private final AdminEndPoint adminEndPoint = new AdminEndPointImplService().getAdminEndPointImplPort();

    private final Map<String, AbstractCommand> commandMap = new HashMap<>();

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public AdminEndPoint getAdminEndPoint() {
        return adminEndPoint;
    }

    @Override
    public Map<String, AbstractCommand> getCommandMap() {
        return commandMap;
    }

    public ProjectEndPoint getProjectEndPoint() {
        return projectEndPoint;
    }

    public TaskEndPoint getTaskEndPoint() {
        return taskEndPoint;
    }

    public UserEndPoint getUserEndPoint() {
        return userEndPoint;
    }

    @Override
    public TerminalService getTerminalService() {
        return this.terminalService;
    }

    private void getClassesAndFillMap(String packageInfo) {
        Reflections refilections = new Reflections(packageInfo);
        Set<Class<? extends AbstractCommand>> subTypes = refilections.getSubTypesOf(AbstractCommand.class);
        subTypes.forEach(cl -> {
            try {
                AbstractCommand ac = cl.newInstance();
                ac.setServiceLocator(this);
                commandMap.put(ac.command(), ac);
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    public void init() {
        getClassesAndFillMap("ru.trandefil.tm.command");
        System.out.println("enter help to see commands.");
        while (true) {
            try {
                final String s = terminalService.nextLine();
                final AbstractCommand abstractCommand = commandMap.get(s);
                if (abstractCommand == null) {
                    System.out.println("Bad command.");
                    continue;
                }
                if (!abstractCommand.secure()) {
                    abstractCommand.execute();
                    continue;
                }
                if (session == null) {
                    AbstractCommand loginCommand = commandMap.get("login");
                    loginCommand.execute();
                }
                if (session == null) {
                    System.out.println("Bad login");
                    continue;
                }
                if (!abstractCommand.isAdmin()) {
                    abstractCommand.execute();
                    continue;
                }
                if (!session.getRole().equals(Role.ADMIN)) {
                    System.out.println("Not authorized. Admin only.");
                    continue;
                }
                abstractCommand.execute();
            } catch (Exception e) {
               System.out.println(e.getMessage());
            }
        }
    }

}
