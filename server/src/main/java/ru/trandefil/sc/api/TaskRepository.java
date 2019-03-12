package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Task;

import javax.persistence.EntityManager;
import java.util.List;

public interface TaskRepository {

    List<Task> getAll(String userId, EntityManager em);

    List<Task> getAll(EntityManager em);

    Task save(Task task, EntityManager em);

    void delete(Task task, EntityManager em);

    boolean deleteByName(String userId, String name, EntityManager em);

    Task getByName(String userId, String name, EntityManager em);

    Task getByid(String userId, String id, EntityManager em);

    void clear(EntityManager em);

}
