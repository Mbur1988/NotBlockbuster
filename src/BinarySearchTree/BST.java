package BinarySearchTree;

import Movies.Movie;

public class BST {

    private BSTNode root;

    /**
     * Constructor
     */
    public BST() {
        root = null;
    }

    /**
     * Function to check if tree is empty
     * @return
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * Method to insert a new node into the tree
     * @param movie
     */
    public void Insert(Movie movie) {
        Insert(root, movie);
    }

    /**
     * Method to insert a new node into the tree
     * @param node
     * @param movie
     * @return
     */
    public BSTNode Insert(BSTNode node, Movie movie) {
        if (node == null) {
            root = new BSTNode(movie);
            return root;
        }

        int nodeKey = node.getMovie().getTitle().hashCode();
        int movieKey = movie.getTitle().hashCode();
        // if the node is null then insert new node as root

        // if movie key is equal to the node key then increase the node count by 1
        if (nodeKey == movieKey) {
            node.setCount(node.getCount() + 1);
        }
        // if movie key is greater than node key then it should be inserted to right of it
        else if (movieKey > nodeKey) {
            node.setRight(Insert(node.getRight(), movie));
        }
        // if movie key is greater than node key then it should be inserted to left of it
        else if (movieKey < nodeKey) {
            node.setLeft(Insert(node.getLeft(), movie));
        }
        return node;
    }

    /**
     *
     * @param movie
     * @return
     */
    public int Available(Movie movie) {
        BSTNode node = Search(root, movie);
        if (node == null) {
            return 0;
        }
        else {
            return node.getCount();
        }
    }

    /**
     *
     * @param movieTitle
     * @return
     */
    public int Available(String movieTitle) {
        BSTNode node = Search(root, movieTitle);
        if (node == null) {
            return 0;
        }
        else {
            return node.getCount();
        }
    }

    /**
     *
     * @param movie
     * @return
     */
    public boolean Search(Movie movie) {
        BSTNode node = Search(root, movie);
        if (node == null) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     *
     * @param movieTitle
     * @return
     */
    public BSTNode Search(String movieTitle) {
        BSTNode node = Search(root, movieTitle);
        if (node == null) {
            return null;
        }
        else {
            return node;
        }
    }

    /**
     * Method to search for an element in the tree
     * @param node
     * @param movie
     * @return
     */
    public BSTNode Search(BSTNode node, Movie movie) {
        int nodeKey = node.getMovie().getTitle().hashCode();
        int movieKey = movie.getTitle().hashCode();
        // if the node is null or data of the node is x then the element is found
        if (nodeKey == movieKey) {
            return node;
        }
        // if movie key is greater than node key then search the right subtree
        else if (movieKey > nodeKey) {
            return Search(node.getRight(), movie);
        }
        // if movie key is greater than node key then search the left subtree
        else if (movieKey < nodeKey) {
            return Search(node.getLeft(), movie);
        }
        // else the element can not be found return null
        else {
            return null;
        }
    }

    /**
     *
     * @param node
     * @param movieTitle
     * @return
     */
    public BSTNode Search(BSTNode node, String movieTitle) {
        int nodeKey = node.getMovie().getTitle().hashCode();
        int movieKey = movieTitle.hashCode();
        // if the node key is equal to the movie key then the element is found
        if (nodeKey == movieKey) {
            return node;
        }
        // if movie key is greater than node key then search the right subtree
        else if (movieKey > nodeKey) {
            return Search(node.getRight(), movieTitle);
        }
        // if movie key is greater than node key then search the left subtree
        else if (movieKey < nodeKey) {
            return Search(node.getLeft(), movieTitle);
        }
        // else the element can not be found return null
        else {
            return null;
        }
    }
}
