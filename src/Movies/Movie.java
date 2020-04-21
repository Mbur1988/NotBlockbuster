package Movies;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Movie {

    private String title;
    private ArrayList<String> starring;
    private String director;
    private Duration duration;
    private String genre;
    private String classification;
    private LocalDate release_date;

    public Movie(String title,
                 ArrayList<String> starring,
                 String director,
                 Duration duration,
                 String genre,
                 String classification,
                 LocalDate release_date) {
        this.title = title;
        this.starring = starring;
        this.director = director;
        this.duration = duration;
        this.genre = genre;
        this.classification = classification;
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getStarring() {
        return starring;
    }

    public void setStarring(ArrayList<String> starring) {
        this.starring = starring;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public LocalDate getRelease_date() {
        return release_date;
    }

    public void setRelease_date(LocalDate release_date) {
        this.release_date = release_date;
    }
}
