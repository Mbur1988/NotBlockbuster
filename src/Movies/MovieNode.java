package Movies;

public class MovieNode {

    private Movie movie;
    private MovieNode left;
    private MovieNode right;

    /**
     * Constructor
     */
    public MovieNode(Movie movie) {
        this.movie = movie;
        this.left = null;
        this.right = null;
    }

    /**
     * Function to get movie
     * @return movie
     */
    public Movie getMovie() {
        return movie;
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