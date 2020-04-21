package Movies;

public class Node {

    int key;
    int count;
    Movie movie;
    Node left;
    Node right;

    /**
     * Constructor
     */
    public Node(Movie movie) {
        key = movie.getTitle().hashCode();
        count = 1;
        this.movie = movie;
        left = null;
        right = null;
    }

    /**
     * Function to get key
     * @return
     */
    public int getKey() {
        return key;
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
    public Node getLeft() {
        return left;
    }

    /**
     * Function to set left node
     * @param node
     */
    public void setLeft(Node node) {
        left = node;
    }

    /**
     * Function to get right node
     * @return right node
     */
    public Node getRight() {
        return right;
    }

    /**
     * Function to set right node
     * @param node
     */
    public void setRight(Node node) {
        right = node;
    }
}
