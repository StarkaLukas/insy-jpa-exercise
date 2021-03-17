package at.htl.workloads.movie;

import at.htl.workloads.actor.Actor;
import at.htl.workloads.category.Category;
import at.htl.workloads.language.Language;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {
    @Id
    private Long id;
    private String title;
    private Integer year;
    private Double duration;
    private Double rating;
    private Language language;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Actors",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private List<Actor> actors;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Movie_Categories",
    joinColumns = @JoinColumn(name = "movie_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categories;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
