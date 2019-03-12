package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Project;

import javax.persistence.EntityManager;
import java.util.List;

public interface ProjectRepository {

    List<Project> getAll(String userId, EntityManager em);

    List<Project> getAll(EntityManager em);

    Project getByName(String userId, String projectName, EntityManager em);

    Project getById(String userId, String projectId, EntityManager em);

    Project save(Project project, EntityManager em);

    void delete(Project project, EntityManager em);

    boolean deleteByName(String userId, String projectName, EntityManager em);

    void clear(EntityManager em);

}
