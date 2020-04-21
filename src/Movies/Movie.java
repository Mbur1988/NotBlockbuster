package Movies;

import CustomExceptions.CopiesOutOfBoundsException;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;

public class Movie {

    private String title;
    private ArrayList<String> starring;
    private String director;
    private Duration duration;
    private String genre;
    private String classification;
    private LocalDate release_date;
    private int copies;
    private int count;

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
        this.copies = 1;
        this.count = 0;
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

    /**
     * Function to get the number of available copies
     * @return
     */
    public int getCopies() {
        return copies;
    }

    /**
     * Function to set the number of available copies
     * @param copies
     */
    private void setCopies(int copies) {
        this.copies = copies;
    }

    /**
     * Function to increment number of copies available
     */
    public void incrementCopies() throws CopiesOutOfBoundsException {
        if (copies == 10) {
            throw new CopiesOutOfBoundsException("Can not store more than 10 DVDs");
        }
        else {
            this.copies++;
        }
    }

    /**
     * Function to decrement number of copies available
     */
    public void decrementCopies() throws CopiesOutOfBoundsException {
        if (copies == 0) {
            throw new CopiesOutOfBoundsException("Can not have a negative number of DVDs");
        }
        else {
            this.copies--;
        }
    }

    /**
     * Function to get count
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * Function to set count
     * @param count
     */
    public void setCount(int count) {
        if (count > 10 || count < 0) {
            throw new IndexOutOfBoundsException("Index " + count + " is out of bounds!");
        }
        else {
            this.count = count;
        }
    }
}
