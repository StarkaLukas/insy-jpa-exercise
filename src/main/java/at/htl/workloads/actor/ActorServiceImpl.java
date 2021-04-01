package at.htl.workloads.actor;

import at.htl.model.actor.ActorDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class ActorServiceImpl implements ActorService {

    private ActorRepository actorRepository;

    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override

    public Actor findById(Long id) {
        return actorRepository.getActorById(id);
    }

    @Override
    public boolean addActor(ActorDTO newActor) {
        Actor existingActor = actorRepository.getActorById(newActor.getId());

        if (existingActor != null) {
            return false;
        }

        Actor actor = new Actor();
        actor.setId(newActor.getId());
        actor.setFirstName(newActor.getFirstName());
        actor.setLastName(newActor.getLastName());
        actorRepository.addActor(actor);

        return true;
    }

    @Override
    public List<Actor> getActorList() {
        return actorRepository.getActorList();
    }
}
