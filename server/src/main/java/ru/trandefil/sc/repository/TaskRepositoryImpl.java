package ru.trandefil.sc.repository;

import lombok.NonNull;
import ru.trandefil.sc.api.TaskRepository;
import ru.trandefil.sc.model.Task;
import ru.trandefil.sc.util.UUIDUtil;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.logging.Logger;


@ApplicationScoped
public class TaskRepositoryImpl implements TaskRepository {

    private final Logger logger = Logger.getLogger(this.getClass().getName());

    @Override
    public List<Task> getAll(@NonNull final String userId, @NonNull final EntityManager em) {
        logger.info(" repo getAll();");
        final Query query = em.createQuery("select t from Task t where t.assignee.id = :userId or t.executor = :userId");
        query.setParameter("userId", userId);
        final List<Task> tasks = query.getResultList();
        logger.info("returning : " + tasks);
        return tasks;
    }

    @Override
    public List<Task> getAll(@NonNull final EntityManager em) {
        logger.info("repo getAll()");
        final Query query = em.createQuery("select t from Task t ");
        final List<Task> tasks = query.getResultList();
        logger.info("returning " + tasks);
        return tasks;
    }

    @Override
    public Task save(@NonNull final Task task, @NonNull final EntityManager em) {
        logger.info("repo save");
        if (task.isNew()) {
            task.setId(UUIDUtil.getUniqueString());
            logger.info("persisting task : " + task);
            em.persist(task);
            logger.info("returning " + task);
            return task;
        }
        logger.info("returning " + task);
        return em.merge(task);
    }

    @Override
    public void delete(@NonNull final Task task, @NonNull final EntityManager em) {
        logger.info("repo delete");
        em.remove(task);
    }

    @Override
    public boolean deleteByName(@NonNull final String userId, @NonNull final String name, @NonNull final EntityManager em) {
        logger.info("repo deleteByName");
        final Query query = em.createQuery("delete from Task t where t.assignee.id =:userId and t.name = :name");
        query.setParameter("userId", userId);
        query.setParameter("name", name);
        final int result = query.executeUpdate();
        logger.info("deleted by name ? : " + (result != 0));
        return result != 0;
    }

    @Override
    public Task getByName(@NonNull final String userId, @NonNull final String name, @NonNull final EntityManager em) {
        logger.info("getByName repo");
        final Query query = em.createQuery("select t from Task t where (t.assignee.id = :userId or t.executor.id = :userId) and t.name = :name");
        query.setParameter("name", name);
        query.setParameter("userId", userId);
        final Task task = (Task) query.getSingleResult();
        logger.info("returning " + task);
        return task;
    }

    @Override
    public Task getByid(@NonNull final String userId, @NonNull final String id, @NonNull final EntityManager em) {
        logger.info("repo getById");
        final Query query = em.createQuery("select t from Task t where (t.assignee.id = :userId or t.executor.id = :userId) and t.id = :id");
        query.setParameter("userId", userId);
        query.setParameter("id", id);
        final Task task = (Task) query.getSingleResult();
        logger.info("returning " + task);
        return task;
    }

    @Override
    public void clear(EntityManager em) {
        logger.info("task repo clear");
        try {

            final Query query = em.createQuery("DELETE FROM Task");
            em.getTransaction().begin();
            final int result = query.executeUpdate();
            logger.info("deleted rows ---------------------------------------------------: " + result);
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
