package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.Session;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.repository.DSSessionRepository;
import ru.trandefil.sc.repository.DSUserRepository;
import ru.trandefil.sc.util.HashUtil;
import ru.trandefil.sc.util.SignatureUtil;
import ru.trandefil.sc.util.UUIDUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    private DSUserRepository userRepository;

    @Inject
    private DSSessionRepository sessionRepository;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void delete(@NonNull final User user) {
//        userRepository.delete(user, entityManager);
        userRepository.deleteById(user.getId());
    }

    @Override
    public boolean deleteByName(@NonNull final String name) {
//        return userRepository.deleteByName(name, entityManager);
        return userRepository.deleteByName(name) != 0;
    }

    @Override
    public User save(@NonNull final User user) {
//        return userRepository.saveOrUpdate(user, entityManager);
        return userRepository.merge(user);
    }

    @Override
    public User getByName(@NonNull final String userName) {
//        return userRepository.findByName(userName, entityManager);
        return userRepository.getByName(userName);
    }

    @Override
    public User getRefById(@NonNull final String userId) {
//        return userRepository.getRef(userId, entityManager);
        return null;
    }

    @Override
    public User getById(@NonNull final String id) {
//        return userRepository.getById(id, entityManager);
        return userRepository.getById(id);
    }

    @Override
    public List<User> getAll() {
//        return userRepository.getAll(entityManager);
        return userRepository.findAll();
    }

    @Override
    public Session getSession(@NonNull final String userName, @NonNull final String userPassword) {
        logger.info("====================================================get session");
        final User user = userRepository.getLoggedUser(userName, HashUtil.hashPassword(userPassword));
        if (user == null) {
            logger.info("---------------------------------------------------- bad user credential");
            return null;
        }
        logger.info("get form base user : " + user);
        final Session newSess = createNewSession(user.getId(), user.getRole());
        logger.info("created session : " + newSess);
        return newSess;
    }

    private Session createNewSession(@NonNull final String userId, @NonNull final Role role) {
        logger.info("create new sesion");
        final String uuid = UUIDUtil.getUniqueString();
        final long timeStamp = System.nanoTime();
        final String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        final Session created = new Session(uuid, timeStamp, userId, role, signature);
        sessionRepository.save(created);
        logger.info("=============================================created session : " + created);
        return created;
    }


    @Override
    public void logout(@NonNull final Session session) {
        sessionRepository.remove(session);
    }

    @Override
    public User constractUser(@NonNull final String name, @NonNull final String pass, @NonNull String role) {
        role = role.trim().toUpperCase();
        if ("ADMIN".equals(role) || "USER".equals(role)) {
            final Role newRole = Enum.valueOf(Role.class, role);
            final User newUser = new User(null, name, HashUtil.hashPassword(pass), newRole);
            System.out.println("created user : " + newUser);
            final User saved = save(newUser);
            return saved;
        }
        System.out.println("bad user role.");
        return null;
    }

}
