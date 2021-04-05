package at.htl.workloads.movie;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import java.util.List;

@RequestScoped
public class MovieRepositoryImpl implements MovieRepository{

    private EntityManager entityManager;

    public MovieRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Movie getMovieById(Long id) {
        return entityManager.find(Movie.class, id);
    }

    @Override
    public void addMovie(Movie movie) {
        entityManager.persist(movie);
    }

    @Override
    public List<Movie> getAllMovies() {
        var query = entityManager.createQuery("select m from Movie m", Movie.class);
        return query.getResultList();
    }

    @Override
    public List<MovieActName> getMoviesWithActors() {
        var query = entityManager.createQuery(
                "select NEW at.htl.workloads.movie.MovieActName(m.title, m.year, a.actor.firstName, a.actor.lastName) from Movie m join m.movieActors a", MovieActName.class
        );

        return query.getResultList();
    }
}
