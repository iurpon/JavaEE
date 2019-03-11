package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.TaskRepository;
import ru.trandefil.sc.api.TaskService;
import ru.trandefil.sc.model.Task;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class TaskServiceImpl implements TaskService {

    @Inject
    private TaskRepository taskRepository;

    @Override
    public Task save(@NonNull final Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getById(@NonNull final String id) {
        return taskRepository.getById(id);
    }

    @Override
    public void delete(@NonNull final Task task) {
        taskRepository.delete(task);
    }

    @Override
    public void deletById(@NonNull final String id) {
        taskRepository.deleteById(id);
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.getAll();
    }

    @Override
    public void clear() {
        taskRepository.clear();
    }

    @Override
    public void saveAll(@NonNull final List<Task> tasks) {
        taskRepository.saveAll(tasks);
    }

}
