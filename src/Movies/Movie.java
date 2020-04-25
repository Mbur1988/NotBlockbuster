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
     * Function to set the title of the movie
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Function to get the list of stars starring in the movie
     * @return  an array list of strings
     */
    public String getStarring() {
        return starring;
    }

    /**
     * Function to set the list of stars starring in the movie
     * @param starring
     */
    public void setStarring(String starring) {
        this.starring = starring;
    }

    /**
     * Function to get the director of the movie
     * @return directors name as string
     */
    public String getDirector() {
        return director;
    }

    /**
     * Function to set the director of the movie
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Function to get the genre of the movie
     * @return movie genre as string
     */
    public String getGenre() {
        return genre;
    }

    /**
     * Function to set the genre of the movie
     * @param genre
     */
    public void setGenre(String genre) {
        this.genre = genre;
    }

    /**
     * Function to get the classification of the movie
     * @return movie classification as string
     */
    public String getClassification() {
        return classification;
    }

    /**
     * Function to set classification of the movie
     * @param classification
     */
    public void setClassification(String classification) {
        this.classification = classification;
    }

    /**
     * Function to get the duration of the movie
     * @return movie duration as duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Function to set the duration of the movie
     * @param duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Function to get the release date movie
     * @return movie release date as local date
     */
    public int getRelease_date() {
        return release_date;
    }

    /**
     * Function to set the release date of the movie
     * @param release_date
     */
    public void setRelease_date(int release_date) {
        this.release_date = release_date;
    }

    /**
     * Function to get the number of available copies
<<<<<<< Updated upstream
     * @return
=======
     * @return number of copies available as int
>>>>>>> Stashed changes
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
     * Function to get a count of the number of times the movie is rented out
     * @return number of times the movie is rented out as int
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

    /**
     * Function to increment number of times the movie has been rented
     */
    public void incrementCount() {
        this.count++;
    }

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