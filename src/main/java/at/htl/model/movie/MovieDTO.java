package at.htl.model.movie;

import at.htl.model.sale.SaleDTO;
import at.htl.workloads.language.Language;

import java.util.List;

public class MovieDTO {

    private Long id;
    private String title;
    private Integer year;
    private Double duration;
    private Double rating;
    private Language language;
    private List<SaleDTO> saleList;

    public MovieDTO() {
    }

    public MovieDTO(Long id, String title, Integer year, Double duration, Double rating, Language language, List<SaleDTO> saleList) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.rating = rating;
        this.language = language;
        this.saleList = saleList;
    }

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

    public List<SaleDTO> getSaleList() {
        return saleList;
    }

    public void setSaleList(List<SaleDTO> saleList) {
        this.saleList = saleList;
    }
}
