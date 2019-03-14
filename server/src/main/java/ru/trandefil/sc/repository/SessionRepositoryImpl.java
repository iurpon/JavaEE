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
        logger.info("=================================delete session repo");
        logger.info("================================== entityManager contains ? " + em.contains(session));
        if(em.contains(session)){
            logger.info("========================================== contains");
            em.remove(session);
        }
        Session ref = em.getReference(Session.class,session.getId());
        logger.info("==========================================  geting session ref : " + ref);
        em.remove(ref);
    }

    @Override
    public Session save(@NonNull final Session session, @NonNull final EntityManager em) {
        logger.info("===================================save session repo");
        em.persist(session);
        return session;
    }

    @Override
    public void clear(EntityManager em) {
        logger.info("clear session repo");
            final Query query = em.createQuery("delete from Session");
            query.executeUpdate();
    }

    @Override
    public List<Session> getAll(EntityManager em) {
        logger.info("===================================getAll session repo");
        final Query query = em.createQuery("select s from Session s");
        return (List<Session>)query.getResultList();
    }

    @Override
    public Session getById(String id, EntityManager em) {
        logger.info("===================================getById session repo");
        final Query query = em.createQuery("select s from Session s where s.id = :id");
        query.setParameter("id",id);
        return (Session)query.getSingleResult();
    }

}
