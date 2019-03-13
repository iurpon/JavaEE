package ru.trandefil.sc.command;

import ru.trandefil.sc.api.ServiceLocator;

public abstract class AbstractCommand {

    private ServiceLocator serviceLocator;

    public AbstractCommand(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public AbstractCommand() {
    }

    public abstract String command();

    public abstract String description();

    public abstract void execute();

    public abstract boolean secure();

    public ServiceLocator getServiceLocator() {
        return serviceLocator;
    }

    public void setServiceLocator(ServiceLocator serviceLocator) {
        this.serviceLocator = serviceLocator;
    }

    public boolean isAdmin(){
        return false;
    }

}
