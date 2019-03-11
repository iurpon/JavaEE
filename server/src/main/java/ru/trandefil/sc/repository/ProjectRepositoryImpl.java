package ru.trandefil.sc.repository;

import ru.trandefil.sc.api.ProjectRepository;
import ru.trandefil.sc.model.Project;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

import static ru.trandefil.sc.util.EntityData.PROJECT1;
import static ru.trandefil.sc.util.EntityData.PROJECT2;

@ApplicationScoped
public class ProjectRepositoryImpl implements ProjectRepository {

    private Map<String, Project> projectMap = new HashMap<>();

    {
        init();
    }

    private void init() {
        projectMap.put(PROJECT1.getId(), PROJECT1);
        projectMap.put(PROJECT2.getId(), PROJECT2);
    }

    @Override
    public Project save(Project project) {
        if (project.isNew()) {
            project.setId(UUID.randomUUID().toString());
        }
        return projectMap.put(project.getId(), project);
    }

    @Override
    public Project getById(String id) {
        return projectMap.get(id);
    }

    @Override
    public void delete(Project project) {
        projectMap.remove(project.getId());
    }

    @Override
    public List<Project> getAll() {
        return new ArrayList<>(projectMap.values());
    }

    @Override
    public void deleteById(String id) {
        projectMap.remove(id);
    }

}
