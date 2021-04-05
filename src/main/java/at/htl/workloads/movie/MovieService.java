package at.htl.workloads.movie;

import at.htl.model.actor.ActorDTO;
import at.htl.model.category.CategoryDTO;
import at.htl.model.movie.MovieDTO;

import java.util.List;

public interface MovieService {
    Movie getMovieById(Long id);

    boolean addMovie(MovieDTO newMovie);

    boolean addCategoriesToMovie(MovieDTO movie, List<CategoryDTO> categories);

    boolean addActorsToMovie(MovieDTO movie, List<ActorDTO> actors);

    List<Movie> getAllMovies();

    List<MovieActName> getMoviesWithActors();

    List<MovieCatName> getMoviesWithCategories();
}
