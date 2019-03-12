package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAll(String userId);

    List<Task> getAll();

    Task save(String userId, Task task);

    void delete(String userId, Task task);

    boolean deleteByName(String userId, String name);

    Task getByName(String userId, String name);

    Task getByid(String userId, String id);

}
