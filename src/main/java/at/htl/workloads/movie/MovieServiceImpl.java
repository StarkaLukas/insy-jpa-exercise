package at.htl.workloads.movie;

import at.htl.model.movie.MovieDTO;
import at.htl.model.sale.SaleDTO;
import at.htl.workloads.customer.Customer;
import at.htl.workloads.sale.Sale;
import at.htl.workloads.staff.Staff;
import at.htl.workloads.store.Store;

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
        movie.setDuration(newMovie.getDuration());
        movie.setLanguage(newMovie.getLanguage());
        movie.setRating(newMovie.getRating());
        movie.setTitle(newMovie.getTitle());
        movie.setYear(newMovie.getYear());

        for (SaleDTO saleDTO : newMovie.getSaleList()) {
            Sale sale = new Sale();
            sale.setMovie(movie);
            sale.setPrice(saleDTO.getPrice());
            sale.setPayment_date(saleDTO.getPayment_date());

            Customer customer = new Customer();
            customer.setStreet(saleDTO.getCustomer().getStreet());
            customer.setPlace(saleDTO.getCustomer().getPlace());
            customer.setFirstName(saleDTO.getCustomer().getFirstName());
            customer.setLastName(saleDTO.getCustomer().getLastName());
            customer.setZip(saleDTO.getCustomer().getZip());
            customer.setDateOfBirth(saleDTO.getCustomer().getDateOfBirth());
            customer.getSales().add(sale);

            sale.setCustomer(customer);

            Staff staff = new Staff();
            staff.setHireDate(saleDTO.getStaff().getHireDate());
            staff.setFirstName(saleDTO.getStaff().getFirstName());
            staff.setLastName(saleDTO.getStaff().getLastName());
            staff.setSalary(saleDTO.getStaff().getSalary());
            staff.getSales().add(sale);

            Store store = new Store();
            store.setCity(saleDTO.getStaff().getStore().getCity());
            store.setName(saleDTO.getStaff().getStore().getName());
            store.getStaffList().add(staff);

            staff.setStore(store);

            sale.setStaff(staff);
            sale.setStaff(staff);

            movie.getSales().add(sale);

        }

        movieRepository.addMovie(movie);

        return true;
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.getAllMovies();
    }

    @Override
    public List<MovieActName> getMoviesWithActors() {
        return movieRepository.getMoviesWithActors();
    }
}
