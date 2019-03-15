package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.TaskRepository;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Task;
import ru.trandefil.sc.util.UUIDUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class TaskServiceImpl implements TaskService {

    @Inject
    private TaskRepository taskRepository;


    @Override
    public List<Task> getAll(@NonNull final String userId) {
        return taskRepository.getAll(userId);
    }

    @Override
    public Task save(@NonNull final String userId, @NonNull final Task task) {
        if (!task.getAssignee().getId().equals(userId)) {
            return null;
        }
        if(task.isNew()){
            task.setId(UUIDUtil.getUniqueString());
            taskRepository.persist(task);
        }
        taskRepository.merge(task);
        return task;
    }

    @Override
    public void delete(@NonNull final String userId, @NonNull final Task task) {
        if (!task.getAssignee().getId().equals(userId)) {
            return;
        }
        taskRepository.remove(task);
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String name) {
        return taskRepository.deleteByName(userId,name) != 0;
    }

    @Override
    public Task getByName(@NonNull final String userId, @NonNull final String name) {
        return taskRepository.getByName(userId, name);
    }

    @Override
    public Task getByid(@NonNull final String userId, @NonNull final String id) {
        return taskRepository.getByid(userId, id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

}
