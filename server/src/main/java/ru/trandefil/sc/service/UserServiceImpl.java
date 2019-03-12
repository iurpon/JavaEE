package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.SessionRepository;
import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.api.UserService;
import ru.trandefil.sc.model.Role;
import ru.trandefil.sc.model.Session;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.exception.RepositoryLayerException;
import ru.trandefil.sc.util.EMFactoryUtil;
import ru.trandefil.sc.util.HashUtil;
import ru.trandefil.sc.util.SignatureUtil;
import ru.trandefil.sc.util.UUIDUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Alternative
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Inject
    private SessionRepository sessionRepository;

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void delete(@NonNull final User user) {
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            userRepository.delete(user, em);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public boolean deleteByName(@NonNull final String name) {
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            final boolean isDeleted = userRepository.deleteByName(name, em);
            em.getTransaction().commit();
            em.close();
            return isDeleted;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public User save(@NonNull final User user) {
        if (user.isNew()) {
            user.setId(UUIDUtil.getUniqueString());
        }
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            userRepository.saveOrUpdate(user, em);
            em.getTransaction().commit();
            em.close();
            return user;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
            throw new RepositoryLayerException(e.getMessage());
        }
    }

    @Override
    public User getByName(@NonNull final String userName) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final User user = userRepository.findByName(userName, em);
        em.close();
        return user;
    }

    @Override
    public User getRefById(@NonNull final String userId) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final User ref = userRepository.getRef(userId, em);
        em.close();
        return ref;
    }

    @Override
    public User getById(@NonNull final String id) {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final User user = userRepository.getById(id, em);
        em.close();
        return user;
    }

    @Override
    public List<User> getAll() {
        final EntityManager em = EMFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        final List<User> users = userRepository.getAll(em);
        em.close();
        return users;
    }

    @Override
    public Session getSession(@NonNull final String userName, @NonNull final String userPassword) {
        logger.info("get session");
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            final User user = userRepository.getLogged(userName, HashUtil.hashPassword(userPassword), em);
            if (user == null) {
                System.out.println("bad login.");
                return null;
            }
            logger.info("get form base user : " + user);
            final Session newSess = createNewSession(user.getId(), user.getRole(), em);
            logger.info("created session : " + newSess);
            em.getTransaction().commit();
            em.close();
            System.out.println("logged " + user.getName());
            return newSess;
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
            e.getMessage();
        }
        return null;
    }

    private Session createNewSession(@NonNull final String userId, @NonNull final Role role, @NonNull final EntityManager em) {
        logger.info("create new sesion");
        final String uuid = UUIDUtil.getUniqueString();
        final long timeStamp = System.nanoTime();
        final String signature = SignatureUtil.createSignature(uuid, userId, timeStamp, role);
        final Session created = new Session(uuid, timeStamp, userId, role, signature);
        return sessionRepository.save(created, em);
    }

    @Override
    public void logout(@NonNull final Session session) {
        EntityManager em = null;
        try {
            em = EMFactoryUtil.getEntityManager();
            em.getTransaction().begin();
            sessionRepository.delete(session, em);
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
            e.getMessage();
            throw new RepositoryLayerException(e.getMessage());
        }
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
