package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Project;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(String id);

    void delete(Project project);

    List<Project> getAll();

    void deleteById(String id);

}
