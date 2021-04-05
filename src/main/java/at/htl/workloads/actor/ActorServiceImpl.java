package at.htl.workloads.actor;

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
    public List<Actor> getActorList() {
        return actorRepository.getActorList();
    }
}
