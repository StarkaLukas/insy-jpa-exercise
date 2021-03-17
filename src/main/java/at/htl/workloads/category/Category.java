package at.htl.workloads.category;

import at.htl.workloads.movie.Movie;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Category {

    @Id
    private String name;
    private String description;

    @ManyToMany
    @JoinColumn(name = "movie_id")
    private List<Movie> movies;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
