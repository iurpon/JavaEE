package ru.trandefil.sc.repository;

import lombok.NonNull;
import ru.trandefil.sc.api.UserRepository;
import ru.trandefil.sc.model.User;
import ru.trandefil.sc.util.UUIDUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<User> getAll(@NonNull final EntityManager em) {
        final Query query = em.createQuery("select u from User u");
        final List<User> resultList = query.getResultList();
        return resultList;
    }

    @Override
    public User getLogged(@NonNull final String login, @NonNull final String pass, @NonNull final EntityManager em) {
        final Query query = em.createQuery("Select u FROM User u WHERE u.name = :name and u.password = :password");
        query.setParameter("name", login);
        query.setParameter("password", pass);
        final User logged = (User) query.getSingleResult();
        return logged;
    }

    @Override
    public User findByName(@NonNull final String name, @NonNull final EntityManager em) {
        final Query query = em.createQuery("Select u FROM User u WHERE u.name = :name");
        query.setParameter("name", name);
        final User user = (User) query.getSingleResult();
        return user;
    }

    @Override
    public User getRef(@NonNull final String userId, @NonNull final EntityManager em) {
        return em.getReference(User.class, userId);
    }

    @Override
    public User getById(@NonNull final String userId, @NonNull final EntityManager em) {
        final Query query = em.createQuery("select u from User u where u.id = :userId");
        query.setParameter("userId", userId);
        final User user = (User) query.getSingleResult();
        return user;
    }

    @Override
    public User saveOrUpdate(@NonNull final User user, @NonNull final EntityManager em) {
        if (user.isNew()) {
            user.setId(UUIDUtil.getUniqueString());
            em.persist(user);
            return user;
        }
        return em.merge(user);
    }

    @Override
    public void delete(@NonNull final User user, @NonNull final EntityManager em) {
        em.remove(user);
    }

    @Override
    public boolean deleteByName(@NonNull final String name, @NonNull final EntityManager em) {
        final User byName = findByName(name, em);
        if (byName != null) {
            return deleteById(byName.getId(), em);
        }
        return false;
    }

    @Override
    public boolean deleteById(@NonNull final String id, @NonNull final EntityManager em) {
        final Query query = em.createQuery("Delete FROM User u WHERE u.id = :id");
        query.setParameter("id", id);
        final int executeUpdate = query.executeUpdate();
        return executeUpdate != 0;
    }

    @Override
    public void clear(EntityManager em) {
        try {
            em.getTransaction().begin();
            final Query query = em.createQuery("Delete From User");
            query.executeUpdate();
            em.getTransaction().commit();
            em.close();
        } catch (Exception e) {
            if (em != null) {
                em.getTransaction().rollback();
                em.close();
            }
        }
    }
}
