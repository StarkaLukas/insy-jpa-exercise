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
}
