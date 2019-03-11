package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class Task extends AbstractEntity {

    private String name;

    private String description;

    private Date start;

    private Date end;

    private Project project;

    public Task(String id, String name, String description, Date start, Date end, Project project) {
        super(id);
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.project = project;
    }

}
