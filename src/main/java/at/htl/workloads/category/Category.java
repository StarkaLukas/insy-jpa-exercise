package at.htl.workloads.category;

import at.htl.workloads.movie.Movie;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "id")
    private List<Movie> movies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
