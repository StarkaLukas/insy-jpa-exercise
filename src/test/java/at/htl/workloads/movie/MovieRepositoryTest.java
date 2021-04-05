package at.htl.workloads.movie;

import at.htl.IntTestBase;
import at.htl.workloads.language.Language;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@QuarkusTest
public class MovieRepositoryTest extends IntTestBase{

    @Inject
    MovieRepositoryImpl movieRepository;

    @Test
    public void addMovie_getMovie_simple_success() {
        Movie movie = new Movie();
        movie.setTitle("The Godfather");
        movie.setYear(1972);
        movie.setRating(9.2);
        movie.setDuration(178d);
        movie.setLanguage(Language.ENGLISH);

        assertThatCode(() -> movieRepository.addMovie(movie)).doesNotThrowAnyException();
        Movie loadedStore = movieRepository.getMovieById(movie.getId());

        assertThat(loadedStore).isNotNull().isEqualTo(movie);
    }

    @Test
    public void addMovies_getAllMovies_success() {
        Movie movie1 = new Movie();
        movie1.setTitle("The Godfather");
        movie1.setYear(1972);
        movie1.setRating(9.2);
        movie1.setDuration(178d);
        movie1.setLanguage(Language.ENGLISH);

        Movie movie2 = new Movie();
        movie2.setTitle("Fallen Angels");
        movie2.setYear(1995);
        movie2.setRating(7.7);
        movie2.setDuration(99d);
        movie2.setLanguage(Language.CHINESE);

        int savedMovies = movieRepository.getAllMovies().size();

        assertThatCode(() -> movieRepository.addMovie(movie1)).doesNotThrowAnyException();
        assertThatCode(() -> movieRepository.addMovie(movie2)).doesNotThrowAnyException();

        List<Movie> loadedMovies = movieRepository.getAllMovies();

        assertThat(loadedMovies.size()).isEqualTo(savedMovies + 2);
        assertThat(loadedMovies.get(savedMovies)).isEqualTo(movie1);
        assertThat(loadedMovies.get(savedMovies + 1)).isEqualTo(movie2);
    }

    @Test
    public void getMovie_notExists() {
        AtomicReference<Movie> loadedMovie = new AtomicReference<>();

        assertThatCode(() -> {
            loadedMovie.set(movieRepository.getMovieById(1L));
        }).doesNotThrowAnyException();

        assertThat(loadedMovie.get()).isNull();
    }
}
