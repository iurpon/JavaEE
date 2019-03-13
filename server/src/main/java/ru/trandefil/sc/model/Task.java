package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task extends AbstractEntity {

    @Column(unique = true)
    private String name;

    private String description;

    private Date start;

    private Date end;

    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

    @ManyToOne(fetch = FetchType.EAGER)
    private User assignee;

    @ManyToOne(fetch = FetchType.EAGER)
    private User executor;

    public Task(String id, String name, String description, Date start, Date end, Project project, User assignee, User executor) {
        super(id);
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        this.project = project;
        this.assignee = assignee;
        this.executor = executor;
    }

    @Override
    public String toString() {
        return "Task{" +
                "name='" + name + '\'' +
                ", assignee=" + assignee +
                ", executor=" + executor +
                '}';
    }

}
