package ru.trandefil.sc.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "projects")
public class Project extends AbstractEntity {

    @Column(unique = true)
    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    public Project(String id, String name, String description, User user) {
        super(id);
        this.name = name;
        this.description = description;
        this.user = user;
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
