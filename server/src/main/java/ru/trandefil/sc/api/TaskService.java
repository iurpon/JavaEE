package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Task;

import java.util.List;

public interface TaskService {

    Task save(Task project);

    Task getById(String id);

    void delete(Task project);

    void deletById(String id);

    List<Task> getAll();

    void clear();

    void saveAll(List<Task> tasks);

}
