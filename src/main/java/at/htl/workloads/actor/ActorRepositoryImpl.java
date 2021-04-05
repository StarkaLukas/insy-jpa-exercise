package at.htl.workloads.actor;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class ActorRepositoryImpl implements ActorRepository{

    private final EntityManager entityManager;

    public ActorRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Actor getActorById(Long id) {
        return entityManager.find(Actor.class, id);
    }

    @Override
    public List<Actor> getActorList() {
        var query = entityManager.createQuery("select a from Actor a", Actor.class);
        return query.getResultList();
    }
}
