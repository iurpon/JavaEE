package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Session;

import javax.persistence.EntityManager;
import java.util.List;

public interface SessionRepository {

    void delete(Session session, EntityManager em);

    Session save(Session session, EntityManager em);

    void clear(EntityManager em);

    List<Session> getAll(EntityManager em);

}
