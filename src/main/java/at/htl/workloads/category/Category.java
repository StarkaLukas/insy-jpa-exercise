package at.htl.workloads.category;

import at.htl.workloads.movie.Movie;
import at.htl.workloads.movie_category.MovieCategory;

import javax.persistence.*;
import java.util.List;

@Entity
public class Category {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<MovieCategory> movieCategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MovieCategory> getMovieCategories() {
        return movieCategories;
    }

    public void setMovieCategories(List<MovieCategory> movieCategories) {
        this.movieCategories = movieCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
