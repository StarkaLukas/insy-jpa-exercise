package at.htl.workloads.movie_category;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MovieCategoryKey implements Serializable {

    private Long categoryId;
    private Long movieId;

    public MovieCategoryKey() {
    }

    public MovieCategoryKey(Long categoryId, Long movieId) {
        this.categoryId = categoryId;
        this.movieId = movieId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }
}
