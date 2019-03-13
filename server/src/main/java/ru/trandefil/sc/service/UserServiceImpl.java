package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.SessionRepository;
import ru.trandefil.sc.api.SessionService;
import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.exception.RepositoryLayerException;
import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.Session;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.util.EMFactoryUtil;
import ru.trandefil.sc.util.HashUtil;
import ru.trandefil.sc.util.SignatureUtil;
import ru.trandefil.sc.util.UUIDUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private SessionService sessionService;

    @PersistenceContext(unitName = "EM")
    private EntityManager entityManager;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void delete(@NonNull final User user) {
        userRepository.delete(user, entityManager);
    }

    @Override
    public boolean deleteByName(@NonNull final String name) {
        return userRepository.deleteByName(name, entityManager);
    }

    @Override
    public User save(@NonNull final User user) {
        return userRepository.saveOrUpdate(user, entityManager);
    }

    @Override
    public User getByName(@NonNull final String userName) {
        return userRepository.findByName(userName, entityManager);
    }

    @Override
    public User getRefById(@NonNull final String userId) {
        return userRepository.getRef(userId, entityManager);
    }

    @Override
    public User getById(@NonNull final String id) {
        return userRepository.getById(id, entityManager);
    }

    @Override
    public List<User> getAll() {
        return userRepository.getAll(entityManager);
    }

    @Override
    public Session getSession(@NonNull final String userName, @NonNull final String userPassword) {
        logger.info("====================================================get session");
        final User user = userRepository.getLogged(userName, HashUtil.hashPassword(userPassword), entityManager);
        if (user == null) {
            logger.info("---------------------------------------------------- bad user credential");
            return null;
        }
        logger.info("get form base user : " + user);
        final Session newSess = createNewSession(user.getId(), user.getRole(), entityManager);
        logger.info("created session : " + newSess);
        return newSess;
    }

    private Session createNewSession(@NonNull final String userId, @NonNull final Role role, @NonNull final EntityManager em) {
        logger.info("create new sesion");
        final String uuid = UUIDUtil.getUniqueString();
        final long timeStamp = System.nanoTime();
        final String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        final Session created = new Session(uuid, timeStamp, userId, role, signature);
        sessionService.save(created);
        logger.info("=============================================created session : " + created);
        return created;
    }


    @Override
    public void logout(@NonNull final Session session) {
        sessionService.delete(session);
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
