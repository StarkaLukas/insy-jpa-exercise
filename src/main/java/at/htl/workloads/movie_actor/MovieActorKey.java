package at.htl.workloads.movie_actor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MovieActorKey implements Serializable {
    private Long actorId;
    private Long movieId;

    public MovieActorKey() {
    }

    public MovieActorKey(Long actorId, Long movieId) {
        this.actorId = actorId;
        this.movieId = movieId;
    }
}
