package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Session;
import ru.trandefil.sc.model.User;

import java.util.List;

public interface UserService {

    User getRefById(String id);

    User getById(String id);

    void delete(User user);

    boolean deleteByName(String name);

    User save(User user);

    User getByName(String userName);

    List<User> getAll();

    Session getSession(String userName, String userPassword);

    void logout(Session session);

    User constractUser(String name, String pass, String role);

}
