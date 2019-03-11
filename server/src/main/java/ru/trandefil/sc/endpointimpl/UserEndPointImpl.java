package ru.trandefil.sc.endpointimpl;

import lombok.NonNull;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.endpoint.UserEndPoint;
import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.User;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@Singleton
@WebService(endpointInterface = "ru.trandefil.sc.endpoint.UserEndPoint")
public class UserEndPointImpl implements UserEndPoint {

    @Inject
    private UserService userService;

    @WebMethod
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @Override
    @WebMethod
    public User getLoggedUser(
            @NonNull @WebParam(name = "name") String name,
            @NonNull @WebParam(name = "password") String password) {
        return userService.getLoggedUser(name,password);
    }

    @Override
    @WebMethod
    public User saveUser(
            @NonNull @WebParam(name = "name") String name,
            @NonNull @WebParam(name = "password") String password,
            @NonNull @WebParam(name = "role") String role) {
        final User user = userService.save(new User(null,name,password,Enum.valueOf(Role.class,role)));
        return user;
    }

    @Override
    @WebMethod
    public User updateUser(@NonNull @WebParam User user) {
        return userService.save(user);
    }

    @Override
    @WebMethod
    public User getUserByName(@NonNull @WebParam(name = "name") String name) {
        return null;
    }

    @Override
    @WebMethod
    public boolean deleteUserByName(@NonNull @WebParam(name = "name") String name) {
        return false;
    }
}
