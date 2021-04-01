package at.htl.workloads.movie_actor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieActorKey implements Serializable {
    private Long actor_Id;
    private Long movie_Id;

    public MovieActorKey() {
    }

    public MovieActorKey(Long actor_Id, Long movie_Id) {
        this.actor_Id = actor_Id;
        this.movie_Id = movie_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieActorKey that = (MovieActorKey) o;
        return Objects.equals(actor_Id, that.actor_Id) && Objects.equals(movie_Id, that.movie_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actor_Id, movie_Id);
    }
}
