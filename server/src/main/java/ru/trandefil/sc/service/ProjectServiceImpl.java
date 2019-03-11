package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.ProjectRepository;
import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.model.Project;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProjectServiceImpl implements ProjectService {

    @Inject
    private ProjectRepository projectRepository;

    @Override
    public Project save(@NonNull final Project project) {
        return projectRepository.save(project);
    }

    @Override
    public Project getById(@NonNull final String id) {
        return projectRepository.getById(id);
    }

    @Override
    public void delete(@NonNull final Project project) {
        projectRepository.delete(project);
    }

    @Override
    public List<Project> getAll() {
        return projectRepository.getAll();
    }

    @Override
    public void deleteById(@NonNull final String id) {
        projectRepository.deleteById(id);
    }

}
