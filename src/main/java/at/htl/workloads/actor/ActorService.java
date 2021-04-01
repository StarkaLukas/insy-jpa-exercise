package at.htl.workloads.actor;

import at.htl.model.actor.ActorDTO;

import java.util.List;

public interface ActorService {

    Actor findById(Long id);

    boolean addActor(ActorDTO newActor);

    List<Actor> getActorList();
}
