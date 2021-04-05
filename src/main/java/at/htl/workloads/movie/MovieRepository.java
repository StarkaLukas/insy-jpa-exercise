package at.htl.workloads.movie;

import at.htl.workloads.actor.Actor;
import at.htl.workloads.category.Category;

import java.util.List;

public interface MovieRepository {
    Movie getMovieById(Long id);

    void addMovie(Movie movie);

    void addCategoriesToMovie(Movie movie, List<Category> categories);

    void addActorsToMovie(Movie movie, List<Actor> actors);

    List<Movie> getAllMovies();

    List<MovieActName> getMoviesWithActors();

    List<MovieCatName> getMoviesWithCategories();
}
