package Movies;

import CustomExceptions.CopiesOutOfBoundsException;

public class Movie {

    private String title;
    private String starring;
    private String director;
    private String genre;
    private String classification;
    private int duration;
    private int release_date;
    private int copies;
    private int count;

    /**
     * Constructor
     * @param title movie title as string
     * @param starring people starring in the movie as array list of strings
     * @param director movie director as string
     * @param duration duration of the movie as duration
     * @param genre movie genre as string
     * @param classification movie classification as string
     * @param release_date movie release date as local time
     */
    public Movie(String title,
                 String starring,
                 String director,
                 String genre,
                 String classification,
                 int duration,
                 int release_date,
                 int copies) {
        this.title = title;
        this.starring = starring;
        this.director = director;
        this.genre = genre;
        this.classification = classification;
        this.duration = duration;
        this.release_date = release_date;
        this.copies = copies;
        this.count = 0;
    }

    /**
     * Function to get the title of the movie
     * @return movie title as string
     */
    public String getTitle() {
        return title;
    }

    /**
     * Function to get the duration of the movie
     * @return movie duration as duration
     */
    public int getDuration() {
        return duration;
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
     * Function to get a count of the number of times the movie is rented out
     * @return number of times the movie is rented out as int
     */
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    /**
     * Function to increment number of times the movie has been rented
     */
    public void incrementCount() {
        this.count++;
    }

    /**
     * print all movie info to console
     */
    public void display() {
        System.out.println();
        System.out.println("Title: " + title);
        System.out.println("Starring: " + starring);
        System.out.println("Director: " + director);
        System.out.println("Genre: " + genre);
        System.out.println("Classification: " + classification);
        System.out.println("Duration: " + duration);
        System.out.println("Release Date: " + release_date);
        System.out.println("Copies Available: " + copies);
        System.out.println("Times Rented: " + count);
    }
}