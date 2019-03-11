package ru.trandefil.sc.api;

import ru.trandefil.sc.model.User;

import java.util.List;

public interface UserService {

    User getLoggedUser(String userName, String password);

    User save(User user);

    List<User> getAll();

    void deleteById(String id);

    User getById(String id);

}
