package at.htl.workloads.movie;

public class MovieCatName {
    private String movie_Title;
    private Integer movie_Year;
    private String category_Title;

    public MovieCatName(String movie_Title, Integer movie_Year, String category_Title) {
        this.movie_Title = movie_Title;
        this.movie_Year = movie_Year;
        this.category_Title = category_Title;
    }

    public String getMovie_Title() {
        return movie_Title;
    }

    public void setMovie_Title(String movie_Title) {
        this.movie_Title = movie_Title;
    }

    public Integer getMovie_Year() {
        return movie_Year;
    }

    public void setMovie_Year(Integer movie_Year) {
        this.movie_Year = movie_Year;
    }

    public String getCategory_Title() {
        return category_Title;
    }

    public void setCategory_Title(String category_Title) {
        this.category_Title = category_Title;
    }
}
