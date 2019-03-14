package ru.trandefil.sc.repository;

import lombok.NonNull;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import ru.trandefil.sc.model.Project;

import java.util.List;

@Repository
public interface DSProjectRepository extends FullEntityRepository<Project, String> {

    @Override
    void persist(Project project);

    @Override
    Project merge(Project project);

    @Override
    Project getReference(Object pk);

    @Override
    Project findBy(String pk);

    @Query(value = "select p from Project p where p.id = :id and p.user.id = :userId")
    Project getByUserId(@NonNull @QueryParam("id") String id, @NonNull @QueryParam("userId") String userId);

    @Query(value = "select p from Project p where p.user.id = :userId and p.name = :name")
    Project getByName(@NonNull @QueryParam("userId") String userId, @NonNull @QueryParam("name") String name);

    @Override
    List<Project> findAll();

    @Query(value = "select p from Project p where p.user.id = :userId")
    List<Project> getAllFiltered(@NonNull @QueryParam("userId") String userId);

    @Override
    void remove(Project project);

    @Query(value = "delete from Project p where p.id = :id")
    int removeById(@NonNull @QueryParam("id") String id);

    @Query(value = "delete from Project p where p.name = :name and p.user.id = :userId")
    int removeByName(@NonNull @QueryParam("name") String name, @NonNull @QueryParam("userId") String userId);

}
