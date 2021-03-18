package at.htl.workloads.movie_actor;

import at.htl.workloads.actor.Actor;
import at.htl.workloads.movie.Movie;

import javax.persistence.*;

@Entity
public class MovieActor {
    @EmbeddedId
    MovieActorKey id;

    @ManyToOne
    @MapsId("actor_id")
    @JoinColumn(name = "actor_id")
    Actor actor;

    @ManyToOne
    @MapsId("movie_id")
    @JoinColumn(name = "movie_id")
    Movie movie;

    public MovieActorKey getId() {
        return id;
    }

    public void setId(MovieActorKey id) {
        this.id = id;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
