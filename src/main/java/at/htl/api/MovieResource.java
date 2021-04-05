package at.htl.api;

import at.htl.model.actor.ActorDTO;
import at.htl.model.category.CategoryDTO;
import at.htl.model.movie.MovieDTO;
import at.htl.workloads.movie.Movie;
import at.htl.workloads.movie.MovieActName;
import at.htl.workloads.movie.MovieCatName;
import at.htl.workloads.movie.MovieService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/api/movie")
public class MovieResource {

    private final MovieService movieService;

    public MovieResource(MovieService movieService) {
        this.movieService = movieService;
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllMovies() {
        List<Movie> movies = movieService.getAllMovies();

        return Response.ok(movies).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMovie(@PathParam("id") Long id) {
        Movie movie = movieService.getMovieById(id);
        boolean movieWasFound = movie != null;

        return (movieWasFound ? Response.ok(movie) : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMovie(MovieDTO newMovie) {
        boolean result = movieService.addMovie(newMovie);

        return (result ? Response.ok(newMovie) : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @POST
    @Path("/addCategoriesToMovie")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addCategoriesToMovie(MovieDTO movieDTO, List<CategoryDTO> categoryDTOS) {
        boolean result = movieService.addCategoriesToMovie(movieDTO, categoryDTOS);

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @Transactional
    @POST
    @Path("/addActorsToMovie")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addActorsToMovie(MovieDTO movieDTO, List<ActorDTO> actorDTOS) {
        boolean result = movieService.addActorsToMovie(movieDTO, actorDTOS);

        return (result ? Response.ok() : Response.status(Response.Status.BAD_REQUEST)).build();
    }

    @GET
    @Path("/getMoviesWithActors")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMoviesWithActors() {
        List<MovieActName> moviesWithActors = movieService.getMoviesWithActors();

        return Response.ok(moviesWithActors).build();
    }

    @GET
    @Path("/getMoviesWithCategories")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMoviesWithCategories() {
        List<MovieCatName> moviesWithActors = movieService.getMoviesWithCategories();

        return Response.ok(moviesWithActors).build();
    }
}
