package at.htl.workloads.movie_category;

import at.htl.workloads.category.Category;
import at.htl.workloads.movie.Movie;

import javax.persistence.*;

@Entity
public class MovieCategory {
    @EmbeddedId
    private MovieCategoryKey id;

    @ManyToOne
    @MapsId("category_id")
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @MapsId("movie_id")
    @JoinColumn(name = "movie_id")
    private Movie movie;

    public MovieCategoryKey getId() {
        return id;
    }

    public void setId(MovieCategoryKey id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
