package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.ProjectRepository;
import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.Project;
import ru.trandefil.sc.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Inject
    private ProjectRepository projectRepository;

    @Inject
    private UserService userService;

    @PersistenceContext(unitName = "EM")
    private EntityManager entityManager;

    @Override
    public Project save(@NonNull final String userId, @NonNull final String name, @NonNull final String description) {
        final User user = userService.getById(userId);
        final Project project = new Project(null, name, description, user);
        return projectRepository.save(project, entityManager);
    }

    @Override
    public Project update(@NonNull final Project project) {
        return projectRepository.save(project, entityManager);
    }

    @Override
    public List<Project> getAll(@NonNull final String userId) {
        return projectRepository.getAll(userId, entityManager);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll(entityManager);
    }

    @Override
    public Project getById(@NonNull final String id, @NonNull final String userId) {
        return projectRepository.getById(userId, id, entityManager);
    }

    @Override
    public void delete(@NonNull final String userId, @NonNull final Project project) {
        final Project byId = projectRepository.getById(userId, project.getId(), entityManager);
        if (byId != null) {
            projectRepository.delete(byId, entityManager);
        }
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String projectName) {
        return projectRepository.deleteByName(userId, projectName, entityManager);
    }

    @Override
    public Project getByName(@NonNull String projectName, @NonNull String userId) {
        return projectRepository.getByName(userId, projectName, entityManager);
    }

}
