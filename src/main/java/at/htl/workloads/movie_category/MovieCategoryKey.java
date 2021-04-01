package at.htl.workloads.movie_category;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MovieCategoryKey implements Serializable {

    private Long category_Id;
    private Long movie_Id;

    public MovieCategoryKey() {
    }

    public MovieCategoryKey(Long category_Id, Long movie_Id) {
        this.category_Id = category_Id;
        this.movie_Id = movie_Id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieCategoryKey that = (MovieCategoryKey) o;
        return Objects.equals(category_Id, that.category_Id) && Objects.equals(movie_Id, that.movie_Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category_Id, movie_Id);
    }
}
