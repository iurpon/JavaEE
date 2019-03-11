package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project extends AbstractEntity {

    private String name;

    private String description;

    public Project(String id, String name, String description) {
        super(id);
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

}
