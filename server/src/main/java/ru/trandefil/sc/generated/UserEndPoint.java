package ru.trandefil.sc.generated;

import ru.trandefil.sc.dto.UserDTO;
import ru.trandefil.sc.model.Session;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface UserEndPoint {

    @WebMethod
    boolean deleteUserByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

    @WebMethod
    UserDTO updateUser(
            @WebParam(name = "user") UserDTO user,
            @WebParam(name = "pass") String pass,
            @WebParam(name = "session") Session session);

    @WebMethod
    UserDTO saveUser(@WebParam(name = "name") String name,
                     @WebParam(name = "pass") String pass,
                     @WebParam(name = "role") String role,
                     @WebParam Session session);

    @WebMethod
    UserDTO getUserByName(@WebParam(name = "name") String name, @WebParam(name = "session") Session session);

    @WebMethod
    List<UserDTO> getAllUsers(@WebParam(name = "session") Session session);

    @WebMethod
    void userLogout(@WebParam(name = "session") Session session);

    @WebMethod
    Session getSession(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password);

    @WebMethod
    Session registry(@WebParam(name = "userName") String userName, @WebParam(name = "password") String password);

}
