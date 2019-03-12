package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.ProjectRepository;
import ru.trandefil.sc.api.ProjectService;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.Project;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.util.EMFactoryUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
@Alternative
public class ProjectServiceImpl implements ProjectService {

    @Inject
    private ProjectRepository projectRepository;

    @Inject
    private UserService userService;

    @Override
    public Project save(@NonNull final String userId, @NonNull final String name, @NonNull final String description) {
/*        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
//            final User user = userService.getRefById(userId);
            final User user = userService.getById(userId);
            final Project created = new Project(null, name, description, user);
            final Project saved = projectRepository.save(created, em);
            em.getTransaction().commit();
            em.close();
            return saved;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }*/
        return null;
    }

    @Override
    public Project update(@NonNull final Project project) {
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            final Project updated = projectRepository.save(project, em);
            em.getTransaction().commit();
            em.close();
            return updated;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
        return null;
    }

    @Override
    public List<Project> getAll(@NonNull final String userId) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        final List<Project> projects = projectRepository.getAll(userId, em);
        em.close();
        return projects;
    }

    @Override
    public List<Project> getAll() {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        final List<Project> projects = projectRepository.getAll(em);
        em.close();
        return projects;
    }

    @Override
    public Project getById(@NonNull final String id, @NonNull final String userId) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        final Project project = projectRepository.getById(userId, id, em);
        em.close();
        return project;
    }

    @Override
    public void delete(@NonNull String userId, @NonNull Project project) {
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            projectRepository.delete(project, em);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String projectName) {
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            final boolean result = projectRepository.deleteByName(userId, projectName, em);
            em.getTransaction().commit();
            em.close();
            return result;

        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
        return false;
    }

    @Override
    public Project getByName(@NonNull String projectName, @NonNull String userId) {
        EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final Project project = projectRepository.getByName(userId, projectName, em);
        em.close();
        return project;
    }

}
