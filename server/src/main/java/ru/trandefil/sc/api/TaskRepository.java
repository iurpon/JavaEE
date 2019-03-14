package ru.trandefil.sc.api;

import lombok.NonNull;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import ru.trandefil.sc.model.Task;

import java.util.List;

@Repository
public interface TaskRepository extends FullEntityRepository<Task, String> {

    @Query(value = "select t from Task t where t.assignee.id = :userId")
    List<Task> getAll(@NonNull @QueryParam("userId") String userId);

    @Override
    void persist(@NonNull Task task);

    @Override
    Task merge(@NonNull Task task);

    @Override
    List<Task> findAll();

    @Override
    void remove(Task task);

    @Query(value = "delete from Task t where t.assignee.id = :userId and t.name = :name")
    int deleteByName(@NonNull @QueryParam("userId") String userId, @NonNull @QueryParam("name") String name);

    @Query(value = "select t from Task t where t.assignee.id = :userId and t.name = :name")
    Task getByName(@NonNull @QueryParam("userId") String userId, @NonNull @QueryParam("name") String name);

    @Query(value = "select t from Task t where t.assignee.id = :userId and t.id = :id")
    Task getByid(@NonNull @QueryParam("userId") String userId, @NonNull @QueryParam("id") String id);

    @Override
    void clear();

}
