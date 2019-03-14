package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.TaskRepository;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/*@ApplicationScoped
@Transactional*/
public class TaskServiceImpl {//implements TaskService {

/*    @Inject
    private TaskRepository taskRepository;

    @PersistenceContext(unitName = "EM")
    private EntityManager entityManager;

    @Override
    public List<Task> getAll(@NonNull final String userId) {
        return taskRepository.getAll(userId, entityManager);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll(entityManager);
    }

    @Override
    public Task save(@NonNull final String userId, @NonNull final Task task) {
        if (!task.getAssignee().getId().equals(userId)) {
            return null;
        }
        return taskRepository.save(task, entityManager);
    }

    @Override
    public void delete(@NonNull final String userId, @NonNull final Task task) {
        if (!task.getAssignee().getId().equals(userId)) {
            return;
        }
        taskRepository.delete(task, entityManager);
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String name) {
        return taskRepository.deleteByName(userId, name, entityManager);
    }

    @Override
    public Task getByName(@NonNull final String userId, @NonNull final String name) {
        return taskRepository.getByName(userId, name, entityManager);
    }

    @Override
    public Task getByid(@NonNull final String userId, @NonNull final String id) {
        return taskRepository.getByid(userId, id, entityManager);
    }*/

}
