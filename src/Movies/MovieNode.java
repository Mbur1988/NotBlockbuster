package Movies;

import CustomExceptions.CopiesOutOfBoundsException;

public class MovieNode {

    private int key;
    private int copies;
    private int count;
    private Movie movie;
    private MovieNode left;
    private MovieNode right;

    /**
     * Constructor
     */
    public MovieNode(Movie movie) {
        this.key = movie.getTitle().hashCode();
        this.copies = 1;
        this.count = 0;
        this.movie = movie;
        this.left = null;
        this.right = null;
    }

    /**
     * Function to get key
     * @return
     */
    public int getKey() {
        return key;
    }

    /**
     * Function to set key
     * @return
     */
    private void setKey(int key) {
        this.key = key;
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
        if (count == 10) {
            throw new CopiesOutOfBoundsException("Can not store more than 10 DVDs");
        }
        else {
            this.count++;
        }
    }

    /**
     * Function to decrement number of copies available
     */
    public void decrementCopies() throws CopiesOutOfBoundsException {
        if (count == 0) {
            throw new CopiesOutOfBoundsException("Can not have a negative number of DVDs");
        }
        else {
            this.count--;
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

    /**
     * Function to get movie
     * @return movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Function to set movie
     * @param movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Function to get left node
     * @return left node
     */
    public MovieNode getLeft() {
        return left;
    }

    /**
     * Function to set left node
     * @param node
     */
    public void setLeft(MovieNode node) {
        left = node;
    }

    /**
     * Function to get right node
     * @return right node
     */
    public MovieNode getRight() {
        return right;
    }

    /**
     * Function to set right node
     * @param node
     */
    public void setRight(MovieNode node) {
        right = node;
    }
}