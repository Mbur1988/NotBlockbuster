package BinarySearchTree;

import Movies.Movie;

class BSTNode {

    Movie movie;
    int count;
    BSTNode left, right;

    /**
     * Null Constructor
     */
    public BSTNode() {
        movie = null;
        left = null;
        right = null;
    }

    /**
     * Constructor
     */
    public BSTNode(Movie movie) {
        left = null;
        right = null;
        this.movie = movie;
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
        this.count = count;
    }

    /**
     * Function to get left node
     * @return left node
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * Function to set left node
     * @param node
     */
    public void setLeft(BSTNode node) {
        left = node;
    }

    /**
     * Function to get right node
     * @return right node
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * Function to set right node
     * @param node
     */
    public void setRight(BSTNode node) {
        right = node;
    }
}
