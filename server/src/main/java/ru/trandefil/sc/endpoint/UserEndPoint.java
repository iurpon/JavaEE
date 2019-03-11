package ru.trandefil.sc.endpoint;

import ru.trandefil.sc.model.User;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserEndPoint {

    @WebMethod
    List<User> getAllUsers();

    @WebMethod
    User getLoggedUser(String name, String password);

    @WebMethod
    User saveUser(String name, String password, String role);

    @WebMethod
    User updateUser(User user);

    @WebMethod
    User getUserByName(String name);

    @WebMethod
    boolean deleteUserByName(String name);

}
