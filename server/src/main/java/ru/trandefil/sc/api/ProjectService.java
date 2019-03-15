package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Project;

import java.util.List;

public interface ProjectService {

    Project save(String userId, String name, String description);

    List<Project> getAll(String userId);

    List<Project> getAll();

    Project getById(String id, String userId);

    void delete(String userId, Project project);

    void deleteById(String userId, String projectId);

    boolean deleteByName(String userId, String projectName);

    Project getByName(String userId, String projectName);

    Project update(Project project);


}
