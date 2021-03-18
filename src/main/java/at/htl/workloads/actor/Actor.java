package at.htl.workloads.actor;

import at.htl.workloads.movie.Movie;
import at.htl.workloads.person.Person;

import javax.persistence.*;
import java.util.List;

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Actor extends Person {

    @OneToMany(mappedBy = "id")
    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
