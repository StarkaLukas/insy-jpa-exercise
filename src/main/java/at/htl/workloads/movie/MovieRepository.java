package at.htl.workloads.movie;

import java.util.List;

public interface MovieRepository {
    Movie getMovieById(Long id);

    void addMovie(Movie movie);

    List<Movie> getAllMovies();

    List<MovieActName> getMoviesWithActors();
}
