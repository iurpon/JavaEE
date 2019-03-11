package ru.trandefil.sc.domain;

import ru.trandefil.sc.model.Project;
import ru.trandefil.sc.model.Task;
import ru.trandefil.sc.model.User;

import java.util.List;

public class Domain {

    private List<Project> projects;

    private List<User> users;

    private List<Task> tasks;

    public Domain() {
    }

    public Domain(List<Project> projects, List<User> users, List<Task> tasks) {
        this.projects = projects;
        this.users = users;
        this.tasks = tasks;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}
