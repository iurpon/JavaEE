package ru.trandefil.sc.endpoint;

import lombok.NonNull;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.dto.UserDTO;
import ru.trandefil.sc.exception.SecurityAuthentificationException;
import ru.trandefil.sc.exception.SecurityAuthorizationException;
import ru.trandefil.sc.generated.UserEndPoint;
import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.Session;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.util.HashUtil;
import ru.trandefil.sc.util.SignatureUtil;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@WebService(endpointInterface = "ru.trandefil.sc.generated.UserEndPoint")
public class UserEndPointImpl implements UserEndPoint {

    @Inject
    private UserService userService;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

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
        if (user == null) {
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
    public Session getSession(@NonNull final String userName, @NonNull final String password) {
        logger.info("---------------------------------------- getSession");
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
    public Session registry(@NonNull final String userName, @NonNull final String password) {
        logger.info("================================ user endpoint registry");
        final User user = userService.constractUser(userName, password, "user");
        logger.info("=====================================created user " + user);
        final Session session = getSession(userName, password);
        logger.info("===================================== created Session " + session);
        return session;
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
