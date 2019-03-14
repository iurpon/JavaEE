package ru.trandefil.sc.service;

import lombok.NonNull;
import ru.trandefil.sc.api.SessionRepository;
import ru.trandefil.sc.api.SessionService;
import ru.trandefil.sc.model.Session;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.logging.Logger;

@ApplicationScoped
@Transactional
public class SessionServiceImpl implements SessionService {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Inject
    private SessionRepository sessionRepository;


    @Override
    public void delete(@NonNull final Session session) {
        logger.info("======================================== session service delete");
        sessionRepository.remove(session);
    }

    @Override
    public Session save(@NonNull final Session session) {
        logger.info("======================================== session service save");
        return sessionRepository.save(session);
    }

    @Override
    public Session getById(String id) {
        return null;
    }

}
