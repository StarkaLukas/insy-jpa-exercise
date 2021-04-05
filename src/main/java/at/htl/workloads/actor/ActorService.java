package at.htl.workloads.actor;

import java.util.List;

public interface ActorService {

    Actor findById(Long id);

    List<Actor> getActorList();
}
