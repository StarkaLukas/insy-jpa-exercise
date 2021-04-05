package at.htl.workloads.actor;

import java.util.List;

public interface ActorRepository {

    Actor getActorById(Long id);

    List<Actor> getActorList();
}
