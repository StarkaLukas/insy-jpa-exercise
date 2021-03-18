package at.htl.workloads.actor;

import at.htl.workloads.movie_actor.MovieActor;
import at.htl.workloads.person.Person;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
@DiscriminatorValue(value = "Actor")
public class Actor extends Person {

    @OneToMany(mappedBy = "actor")
    private List<MovieActor> movieActors;

    public List<MovieActor> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(List<MovieActor> movieActors) {
        this.movieActors = movieActors;
    }
}
