package at.htl.workloads.movie;

import at.htl.model.movie.MovieDTO;

import javax.enterprise.context.RequestScoped;
import java.util.List;

@RequestScoped
public class MovieServiceImpl implements MovieService {

    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.getMovieById(id);
    }

    @Override
    public boolean addMovie(MovieDTO newMovie) {
        Movie existingMovie = movieRepository.getMovieById(newMovie.getId());

        if (existingMovie != null) {
            return false;
        }

        Movie movie = new Movie();
        movie.setId(newMovie.getId());
        movie.setDuration(newMovie.getDuration());
        movie.setLanguage(newMovie.getLanguage());
        movie.setRating(newMovie.getRating());
        movie.setTitle(newMovie.getTitle());
        movie.setYear(newMovie.getYear());
        movieRepository.addMovie(movie);

        return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }
}
