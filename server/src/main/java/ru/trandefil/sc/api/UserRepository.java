package ru.trandefil.sc.api;

import lombok.NonNull;
import org.apache.deltaspike.data.api.*;
import ru.trandefil.sc.model.User;

import java.util.List;

@Repository(forEntity = User.class)
public interface UserRepository extends EntityRepository<User, String> {


    void persist(@NonNull User user);


    User merge(@NonNull User user);


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
