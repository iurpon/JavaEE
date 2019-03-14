package ru.trandefil.sc.repository;

import lombok.NonNull;
import org.apache.deltaspike.data.api.FullEntityRepository;
import org.apache.deltaspike.data.api.Query;
import org.apache.deltaspike.data.api.QueryParam;
import org.apache.deltaspike.data.api.Repository;
import ru.trandefil.sc.model.User;

import java.util.List;

@Repository
public interface DSUserRepository extends FullEntityRepository<User, String> {

    @Override
    void persist(@NonNull User user);

    @Override
    User merge(@NonNull User user);

    @Override
    User getReference(@NonNull Object o);

    @Override
    User findBy(@NonNull String s);

    @Override
    List<User> findAll();

    @Override
    void remove(@NonNull User user);

    @Query(value = "delete from User u where u.id = :id")
    int deleteById(@NonNull @QueryParam("id") String id);

    @Query(value = "delete from User u where u.name = :name")
    int deleteByName(@NonNull @QueryParam("name") String name);

    @Query(value = "select u from User u where u.name = :name")
    User getByName(@NonNull @QueryParam("name") String name);

    @Query(value = "select u from User u where u.name = :name and u.password = :pass")
    User getLoggedUser(@NonNull @QueryParam("name") String name, @NonNull @QueryParam("pass") String pass);

    @Query(value = "select u from User u where u.id = :id")
    User getById(@NonNull @QueryParam("id") String id);

}
