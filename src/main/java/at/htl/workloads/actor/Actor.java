package at.htl.workloads.actor;

import at.htl.workloads.movie_actor.MovieActor;
import at.htl.workloads.person.Person;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "person_id")
@DiscriminatorValue(value = "Actor")
public class Actor extends Person {

    @OneToMany(mappedBy = "actor", cascade = CascadeType.PERSIST)
    private List<MovieActor> movieActors = new ArrayList<>();

    public List<MovieActor> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(List<MovieActor> movieActors) {
        this.movieActors = movieActors;
    }
}
