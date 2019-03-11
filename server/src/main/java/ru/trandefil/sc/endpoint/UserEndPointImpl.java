package ru.trandefil.sc.endpoint;

import lombok.NonNull;
import ru.trandefil.tm.api.UserService;
import ru.trandefil.tm.dto.UserDTO;
import ru.trandefil.tm.entity.Role;
import ru.trandefil.tm.entity.Session;
import ru.trandefil.tm.entity.User;
import ru.trandefil.tm.exception.SecurityAuthentificationException;
import ru.trandefil.tm.exception.SecurityAuthorizationException;
import ru.trandefil.tm.generated.UserEndPoint;
import ru.trandefil.tm.util.SignatureUtil;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@Singleton
@WebService(endpointInterface = "ru.trandefil.tm.generated.UserEndPoint")
public class UserEndPointImpl implements UserEndPoint {

    @Inject
    private UserService userService;

    @Override
    @WebMethod
    public boolean deleteUserByName(@NonNull String name, @NonNull Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to delete user.");
            throw new SecurityAuthorizationException("no permitting for execution.");
        }
        return userService.deleteByName(name);
    }

    @Override
    @WebMethod
    public UserDTO saveUser(@NonNull String name, @NonNull String pass, @NonNull String role, @NonNull Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN)) {
            System.out.println("not authorized  to create new user.");
            throw new SecurityAuthorizationException("no permitting for execution.");
        }
        final User user = userService.constractUser(name, pass, role);
        return getDTO(user);
    }

    @Override
    @WebMethod
    public UserDTO getUserByName(@NonNull String userName, @NonNull Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final User user = userService.getByName(userName);
        if(user == null){
            return null;
        }
        return getDTO(user);
    }

    @Override
    @WebMethod
    public List<UserDTO> getAllUsers(@NonNull Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        final List<User> users = userService.getAll();
        return getDTOList(users);
    }

    @Override
    @WebMethod
    public Session getSession(@NonNull String userName, @NonNull String password) {
        return userService.getSession(userName, password);
    }

    @Override
    @WebMethod
    public void userLogout(@NonNull Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        userService.logout(session);
    }

    @Override
    @WebMethod
    public UserDTO updateUser(@NonNull UserDTO userDTO, @NonNull String pass, @NonNull Session session) {
        if (!SignatureUtil.checkCorrectSession(session)) {
            System.out.println("bad signature.");
            throw new SecurityAuthentificationException("security authentification exception.");
        }
        if (!session.getRole().equals(Role.ADMIN) && !userDTO.getId().equals(session.getUserId())) {
            System.out.println("not authorized  to update this user.");
            throw new SecurityAuthorizationException("no permitting for execution.");
        }
        if (pass.isEmpty()) {
            final User user = userService.getById(userDTO.getId());
            pass = user.getPassword();
        }
        userDTO.setPassword(pass);
        final User updated = userService.save(fromDTO(userDTO));
        return getDTO(updated);
    }

    @Override
    public Session registry(String userName, String password) {
//        userService.save(new User(null, userName, HashUtil.hashPassword(password), Role.USER));
        return getSession(userName, password);
    }

    private UserDTO getDTO(@NonNull User user) {
        final UserDTO dto = new UserDTO(user);
        return dto;
    }

    private List<UserDTO> getDTOList(@NonNull List<User> users) {
        final List<UserDTO> dtoList = new ArrayList<>();
        users.forEach(u -> dtoList.add(getDTO(u)));
        return dtoList;
    }

    private User fromDTO(@NonNull UserDTO dto) {
        final User user = new User(dto.getId(), dto.getName(), dto.getPassword(), dto.getRole());
        return user;
    }

}
