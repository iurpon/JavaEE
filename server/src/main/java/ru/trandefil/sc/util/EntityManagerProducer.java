package ru.trandefil.sc.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProducer {


    @PersistenceContext(unitName = "EM")
    @Produces
//    @MyEm
    private EntityManager entityManager;

/*    @Produces
    @RequestScoped
    @MyEm
    public EntityManager create() {
        return this.entityManager;
    }*/

    public void dispose(@Disposes  EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

}
