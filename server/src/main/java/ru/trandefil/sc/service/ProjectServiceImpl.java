package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.ProjectRepository;
import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.Project;
import ru.trandefil.sc.model.User;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class ProjectServiceImpl implements ProjectService {

    @Inject
    private ProjectRepository projectRepository;

    @Inject
    private UserService userService;


    @Override
    public Project save(@NonNull final String userId, @NonNull final String name, @NonNull final String description) {
        final User user = userService.getById(userId);
        final Project project = new Project(null, name, description, user);
        return projectRepository.save(project);
    }

    @Override
    public Project update(@NonNull final Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAll(@NonNull final String userId) {
        return projectRepository.getAllFiltered(userId);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project getById(@NonNull final String id, @NonNull final String userId) {
        return projectRepository.getByUserId(userId, id);
    }

    @Override
    public void delete(@NonNull final String userId, @NonNull final Project project) {
        final Project byId = projectRepository.getByUserId(userId, project.getId());
        if (byId != null) {
            projectRepository.remove(byId);
        }
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String projectName) {
        return projectRepository.removeByName(projectName, userId) != 0;
    }

    @Override
    public Project getByName(@NonNull String projectName, @NonNull String userId) {
        return projectRepository.getByName(userId, projectName);
    }

}
