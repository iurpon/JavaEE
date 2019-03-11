package ru.trandefil.sc.endpoint;

import ru.trandefil.sc.model.User;

import java.util.List;

public interface UserEndPoint {

    List<User> getAllUsers();

    User getLoggedUser(String name, String password);

    User saveUser(String name, String password, String role);

    User updateUser(User user);

    User getUserByName(String name);

    boolean deleteUserByName(String name);

}
