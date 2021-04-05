package at.htl.workloads.movie;

import at.htl.workloads.actor.Actor;
import at.htl.workloads.category.Category;
import at.htl.workloads.movie_actor.MovieActor;
import at.htl.workloads.movie_actor.MovieActorKey;
import at.htl.workloads.movie_category.MovieCategory;
import at.htl.workloads.movie_category.MovieCategoryKey;

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
    public void addCategoriesToMovie(Movie movie, List<Category> categories) {
        if (getMovieById(movie.getId()) != null) {
            for (Category category : categories) {
                MovieCategory movieCategory = new MovieCategory();
                movieCategory.setMovie(movie);
                movieCategory.setCategory(category);

                MovieCategoryKey movieCategoryKey = new MovieCategoryKey(category.getId(), movie.getId());
                movieCategory.setId(movieCategoryKey);

                entityManager.persist(movieCategory);
            }
        }
    }

    @Override
    public void addActorsToMovie(Movie movie, List<Actor> actors) {
        if (getMovieById(movie.getId()) != null) {
            for (Actor actor : actors) {
                MovieActor movieActor = new MovieActor();
                movieActor.setMovie(movie);
                movieActor.setActor(actor);

                MovieActorKey movieActorKey = new MovieActorKey(actor.getId(), movie.getId());
                movieActor.setId(movieActorKey);

                entityManager.persist(movieActor);
            }
        }
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

    @Override
    public List<MovieCatName> getMoviesWithCategories() {
        var query = entityManager.createQuery(
                "select NEW at.htl.workloads.movie.MovieCatName(m.title, m.year, c.category.name) from Movie m join m.movieCategories c", MovieCatName.class
        );

        return query.getResultList();
    }
}
