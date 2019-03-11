package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Project;

import java.util.List;

public interface ProjectRepository {

    Project save(Project project);

    Project getById(String id);

    void delete(Project project);

    void deleteById(String id);

    List<Project> getAll();

}
