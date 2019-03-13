package ru.trandefil.sc.api;

import ru.trandefil.sc.model.Session;

public interface SessionService {

    void delete(Session session);

    Session save(Session session);

    Session getById(String id);

}
