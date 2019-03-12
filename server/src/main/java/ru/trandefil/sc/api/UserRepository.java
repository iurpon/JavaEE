package ru.trandefil.sc.api;

import ru.trandefil.sc.model.User;

import javax.persistence.EntityManager;
import java.util.List;

public interface UserRepository {

    List<User> getAll(EntityManager entityManager);

    User getLogged(String login, String pass, EntityManager entityManager);

    User findByName(String name, EntityManager em);

    User getById(String userId, EntityManager em);

    User saveOrUpdate(User user, EntityManager em);

    void delete(User user, EntityManager em);

    boolean deleteByName(String name, EntityManager em);

    boolean deleteById(String id, EntityManager em);

    User getRef(String userId, EntityManager em);

    void clear(EntityManager em);

}
