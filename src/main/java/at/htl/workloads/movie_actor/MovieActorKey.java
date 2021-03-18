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

    public Long getActorId() {
        return actorId;
    }

    public void setActorId(Long actorId) {
        this.actorId = actorId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
