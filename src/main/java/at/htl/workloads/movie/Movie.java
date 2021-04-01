package at.htl.workloads.movie;

import at.htl.workloads.language.Language;
import at.htl.workloads.movie_actor.MovieActor;
import at.htl.workloads.movie_category.MovieCategory;
import at.htl.workloads.sale.Sale;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer year;
    private Double duration;
    private Double rating;
    private Language language;

    @OneToMany(mappedBy = "movie")
    private List<Sale> sales = new ArrayList<Sale>();

    @OneToMany(mappedBy = "movie")
    private List<MovieActor> movieActors;

    @OneToMany(mappedBy = "movie")
    private List<MovieCategory> movieCategories;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Double getDuration() {
        return duration;
    }

    public void setDuration(Double duration) {
        this.duration = duration;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    public List<MovieActor> getMovieActors() {
        return movieActors;
    }

    public void setMovieActors(List<MovieActor> movieActors) {
        this.movieActors = movieActors;
    }

    public List<MovieCategory> getMovieCategories() {
        return movieCategories;
    }

    public void setMovieCategories(List<MovieCategory> movieCategories) {
        this.movieCategories = movieCategories;
    }
}
