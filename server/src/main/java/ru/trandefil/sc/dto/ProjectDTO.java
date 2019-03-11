package ru.trandefil.sc.dto;

import ru.trandefil.sc.model.Project;

public class ProjectDTO {

    private String id;

    private String name;

    private String description;

    private String userName;

    public ProjectDTO(String id, String name, String description, String userName) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userName = userName;
    }

    public ProjectDTO(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.description = project.getDescription();
        this.userName = project.getUser().getName();
    }

    public ProjectDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "ProjectDTO{" +
                "name='" + name + '\'' +
                ", name='" + userName + '\'' +
                '}';
    }

}
