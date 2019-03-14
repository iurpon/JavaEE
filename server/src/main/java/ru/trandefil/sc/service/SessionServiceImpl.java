package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.SessionRepository;
import ru.trandefil.sc.api.SessionService;
import ru.trandefil.sc.model.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.logging.Logger;

/*@ApplicationScoped
@Transactional*/
public class SessionServiceImpl implements SessionService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private SessionRepository sessionRepository;

    @PersistenceContext(unitName = "EM")
    private EntityManager entityManager;

    @Override
    public void delete(@NonNull final Session session) {
        logger.info("======================================== session service delete");
        sessionRepository.delete(session,entityManager);
    }

    @Override
    public Session save(@NonNull final Session session) {
        logger.info("======================================== session service save");
        return sessionRepository.save(session,entityManager);
    }

    @Override
    public Session getById(@NonNull final String id) {
        logger.info("======================================== session service getById");
        return sessionRepository.getById(id,entityManager);
    }

}
