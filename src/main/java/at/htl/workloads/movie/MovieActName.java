package at.htl.workloads.movie;

public class MovieActName {
    private String movie_Title;
    private Integer movie_Year;
    private String actor_FirstName;
    private String actor_LastName;

    public MovieActName(String movie_Title, Integer movie_Year, String actor_FirstName, String actor_LastName) {
        this.movie_Title = movie_Title;
        this.movie_Year = movie_Year;
        this.actor_FirstName = actor_FirstName;
        this.actor_LastName = actor_LastName;
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

    public String getActor_FirstName() {
        return actor_FirstName;
    }

    public void setActor_FirstName(String actor_FirstName) {
        this.actor_FirstName = actor_FirstName;
    }

    public String getActor_LastName() {
        return actor_LastName;
    }

    public void setActor_LastName(String actor_LastName) {
        this.actor_LastName = actor_LastName;
    }
}
