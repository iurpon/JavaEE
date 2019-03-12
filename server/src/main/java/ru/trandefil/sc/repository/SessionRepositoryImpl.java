package ru.trandefil.sc.repository;

import lombok.NonNull;
import ru.trandefil.sc.api.SessionRepository;
import ru.trandefil.sc.model.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
public class SessionRepositoryImpl implements SessionRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public void delete(@NonNull final Session session, @NonNull final EntityManager em) {
        logger.info("delete session repo");
        em.remove(session);
    }

    @Override
    public Session save(@NonNull final Session session, @NonNull final EntityManager em) {
        logger.info("save session repo");
        em.persist(session);
        return session;
    }

    @Override
    public void clear(EntityManager em) {
        try {
            em.getTransaction().begin();
            final Query query = em.createQuery("delete from Session");
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

    @Override
    public List<Session> getAll(EntityManager em) {
        final Query query = em.createQuery("select s from Session s");
        return (List<Session>)query.getResultList();
    }

}
