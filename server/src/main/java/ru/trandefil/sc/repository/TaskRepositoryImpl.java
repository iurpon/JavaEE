package ru.trandefil.sc.repository;

import ru.trandefil.sc.api.TaskRepository;
import ru.trandefil.sc.model.Task;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

import static ru.trandefil.sc.util.EntityData.*;

@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository{

    private static Map<String, Task> taskMap = new HashMap<>();

    static {
        init();
    }

    private static void init(){
        taskMap.put(TASK1.getId(),TASK1);
        taskMap.put(TASK2.getId(),TASK3);
        taskMap.put(TASK3.getId(),TASK3);
        taskMap.put(TASK4.getId(),TASK4);
    }

    @Override
    public Task save(Task task) {
        if(task.isNew()){
            task.setId(UUID.randomUUID().toString());
        }
        return taskMap.put(task.getId(),task);
    }

    @Override
    public Task getById(String id) {
        return taskMap.get(id);
    }

    @Override
    public void delete(Task task) {
        taskMap.remove(task.getId());
    }

    @Override
    public void deleteById(String id) {
        taskMap.remove(id);
    }

    @Override
    public List<Task> getAll() {
        return new ArrayList<>(taskMap.values());
    }

    @Override
    public void clear() {
        taskMap.clear();
    }

    @Override
    public void saveAll(List<Task> tasks) {
        tasks.forEach(task -> taskMap.put(task.getName(),task));
    }

}
