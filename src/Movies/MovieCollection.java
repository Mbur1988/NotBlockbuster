package Movies;

import CustomExceptions.MovieAlreadyExistsException;
import CustomExceptions.MovieDoesNotExistException;

public class MovieCollection {

    private static MovieNode root;

    /**
     * Constructor
     */
    public MovieCollection() {
        this.root = null;
    }

    /**
     * returns the root node of the movie collection
     * Used only for testing purposes
     * @return root movieNode
     */
    static MovieNode getRoot() {
        return root;
    }

    /**
     * Inserts a new movie node into the tree.
     * If a node containing the movie already exists in the tree then increment its number of copies
     *
     * @param movie Instance of Movie class to insert into the tree
     */
    public void Insert(Movie movie) throws MovieAlreadyExistsException {
        // create a new node to be added to the tree
        MovieNode node = new MovieNode(movie);
        // if root is null then insert the node as root
        if (root == null) {
            // set node to root
            root = node;
            // end method
            return;
        }
        // declare current and parent placeholders for navigating the tree
        MovieNode current = root;
        MovieNode parent = null;
        // repeat loop until a position is found for the new node
        while (true) {
            // update parent placeholder
            parent = current;
            // if movie title is smaller than the current node title then movie will insert into the left subtree
            if (movie.getTitle().compareTo(current.getMovie().getTitle()) < 0) {
                // select the left subtree as the current subtree
                current = current.getLeft();
                // if current is null then the new node can be inserted here
                if (current == null) {
                    // assign the new node to parent left which is the current node
                    parent.setLeft(node);
                    // end method
                    return;
                }
            }
            // if movie title is greater than the current node title then movie will insert into the right subtree
            else if (movie.getTitle().compareTo(current.getMovie().getTitle()) > 0) {
                // select the right subtree as the current subtree
                current = current.getRight();
                // if current is null then the new node can be inserted here
                if (current == null) {
                    // assign the new node to parent right which is the current node
                    parent.setRight(node);
                    // end method
                    return;
                }
            }
            // if movie already exists then throw MovieAlreadyExistsException
            else {
                // throw exception
                throw new MovieAlreadyExistsException();
            }
        }
    }

    /**
     * Checks whether a movie is in the tree
     *
     * @param movieTitle the title of the movie to search for
     * @return true if the movie is present else false
     */
    private boolean Find(String movieTitle) {
        // initialises the current node as root
        MovieNode current = root;
        // loop until current is null
        while (current != null) {
            // if the movie title is smaller than the title of the current node then search in the left subtree
            if (movieTitle.compareTo(current.getMovie().getTitle()) < 0) {
                // set the left node as the new current node
                current = current.getLeft();
            }
            // if the movie title is greater than the title of the current node then search in the right subtree
            else if (movieTitle.compareTo(current.getMovie().getTitle()) > 0) {
                // set the right node as the new current node
                current = current.getRight();
            }
            // if the key of the current node is equal to the movie key then return true
            else {
                // return true
                return true;
            }
        }
        // if the movie can not be found in the tree then return false
        return false;
    }

    /**
     * Return the movie class of a particular movie
     * @param movieTitle the title of the movie to search for
     * @return the movie class of the movie
     */
    public Movie Get(String movieTitle) throws MovieDoesNotExistException {
        // initialises the current node as root
        MovieNode current = root;
        // loop until current is null
        while (current != null) {
            // if the movie key is less than the key of the current node then continue searching in the left subtree
            if (movieTitle.compareTo(current.getMovie().getTitle()) < 0) {
                // set the left node as the new current node
                current = current.getLeft();
            }
            // if the movie key is greater than the key of the current node then continue searching in the right subtree
            else if (movieTitle.compareTo(current.getMovie().getTitle()) > 0) {
                // set the right node as the new current node
                current = current.getRight();
            }
            // if the key of the current node is equal to the movie key then return the current node
            else {
                // return current node
                return current.getMovie();
            }
        }
        // if the movie can not be found in the tree then throw exception
        throw new MovieDoesNotExistException();
    }

    /**
     * Deletes a movie from the tree
     *
     * @param movieTitle the title of the movie to delete
     * @return true if the movie is deleted successfully else false
     */
    public boolean Delete(String movieTitle) throws MovieDoesNotExistException {
//        if (root == null) {
//            return false;
//        }
        // declare current and parent placeholders for navigating the tree
        MovieNode parent = root;
        MovieNode current = root;
        // initiate boolean left child indicator as false
        boolean leftChild = false;
        // loop until the node to be deleted has been located or found to not exist
        while (current != null && !movieTitle.equals(current.getMovie().getTitle())) {
            // assign parent to current
            parent = current;
            // if the movie title is smaller than the title of the current node then search in the left subtree
            if (movieTitle.compareTo(current.getMovie().getTitle()) < 0) {
                // sets left child indicator to true
                leftChild = true;
                // set the left node as the new current node
                current = current.getLeft();
            }
            // if the movie title is greater than the title of the current node then search in the right subtree
            else if (movieTitle.compareTo(current.getMovie().getTitle()) > 0) {
                // sets left child indicator to false
                leftChild = false;
                // set the right node as the new current node
                current = current.getRight();
            }
        }
        // if the current node is found to be null then the movie does not exist and an exception is thrown
        if (current == null) {
            // throw new movie does not exist exception
            throw new MovieDoesNotExistException();
        }
        // if node to be deleted has no children then it can simply be deleted
        if (current.getLeft() == null && current.getRight() == null) {
            // if node to be deleted is the root node then set root to null
            if (current == root) {
                // set root null
                root = null;
            }
            // if node to be deleted is the left child node of its parent then set parent's left child to null
            if (leftChild == true) {
                // set parent's left child to null
                parent.setLeft(null);
            }
            // if node to be deleted is the right child node of its parent then set parent's right child to null
            else {
                // set parent's right child to null
                parent.setRight(null);
            }
        }
        // if node to be deleted has only the left child then that child takes its place
        else if (current.getRight() == null) {
            // if the node to be deleted is the root node then the left child becomes the root
            if (current == root) {
                // assign the left child as root
                root = current.getLeft();
            }
            // if the deleted node is the left child of the parent then the left child is assigned to that parent node
            else if (leftChild) {
                // assign the left child as the left child of the parent node
                parent.setLeft(current.getLeft());
            }
            // if the deleted node is the right child of the parent then the left child is assigned to that parent node
            else {
                // assign the left child as the right child of the parent node
                parent.setRight(current.getLeft());
            }
        }
        // if node to be deleted has only the right child then that child takes its place
        else if (current.getLeft() == null) {
            // if the node to be deleted is the root node then the right child becomes the root
            if (current == root) {
                // assign the right child as root
                root = current.getRight();
            }
            // if the deleted node is the left child of the parent then the right child is assigned to that parent node
            else if (leftChild) {
                // assign the right child as the left child of the parent node
                parent.setLeft(current.getRight());
            }
            // if the deleted node is the right child of the parent then the right child is assigned to that parent node
            else {
                // assign the right child as the right child of the parent node
                parent.setRight(current.getRight());
            }
        }
        // if node to be deleted has two children then the replacement node is the minimum value of the right subtree
        else if (current.getLeft() != null && current.getRight() != null) {
            // declare the replacement node as the minimum value of the right subtree
            MovieNode replacement = getReplacement(current);
            // if the node to be deleted is the root node then the replacement becomes the root
            if (current == root) {
                // assign the replacement as root
                root = replacement;
            }
            // if the deleted node is the left child of the parent then the replacement is assigned to that parent node
            else if (leftChild) {
                // assign the replacement as the left child of the parent node
                parent.setLeft(replacement);
            }
            // if the deleted node is the right child of the parent then the replacement is assigned to that parent node
            else {
                // assign the replacement as the right child of the parent node
                parent.setRight(replacement);
            }
            // update the left child node of the replacement to that of the deleted node
            replacement.setLeft(current.getLeft());
        }
        // return true to indicate that the movie has been deleted successfully
        return true;
    }

    /**
     * Gets the replacement node of one to be deleted. Updates parent left and right variables.
     *
     * @param node the node that is to be deleted
     * @return the node that will take the place of the deleted node
     */
    private MovieNode getReplacement(MovieNode node) {
        // set placeholders for the current, replacement and replacement's parent nodes
        MovieNode current = node.getRight(); // select the right subtree
        MovieNode replacement = null;
        MovieNode parent = null;
        // loop until current is null
        while (current != null) {
            // update placeholders
            parent = replacement;
            replacement = current;
            // continue down left branch until the minimum is found
            current = current.getLeft();
        }
        // if the successor has a right child add it to the left child node of its parent
        if (replacement != node.getRight()) {
            //
            parent.setLeft(replacement.getRight());
            //
            replacement.setRight(node.getRight());
        }
        return replacement;
    }

    /**
     * User friendly method call to display all movie details in order of movie titles
     */
    public void displayInOrder() {
        displayInOrder(root);
    }

    /**
     * Displays all movie details in order of movie titles
     * @param node the root node of the binary search tree
     */
    private void displayInOrder(MovieNode node) {
        if (node == null) {
            return;
        }
        displayInOrder(node.getLeft());
        node.getMovie().display();
        displayInOrder(node.getRight());
    }

    /**
     * User friendly method to return the number of nodes that make up the binary search tree
     * @return the number of nodes as an integer
     */
    public static int getSize() {
        return getSize(root);
    }

    /**
     * Returns the number of nodes that make up the binary search tree
     * @param node the root node of the binary search tree
     * @return the number of nodes as an integer
     */
    private static int getSize(MovieNode node){
        if(node==null){
            return 0;
        }
        return 1 + getSize(node.getLeft()) + getSize(node.getRight());
    }

    public static Movie[] getTopMovies() {
        int size = getSize();
        Movie[] movies = new Movie[size];
        int index = 0;
        getAllMovies(root, movies, index);
        quicksort(movies);
        return movies;
    }

    private static void getAllMovies(MovieNode node, Movie[] movies, int index) {
        if (node == null) {
            return;
        }
        // Get all movies from the left subtree first
        getAllMovies(node.getLeft(), movies, index);
        // Add the movie from this node to the array
        movies[index++] = node.getMovie();
        // Get all movies from the right subtree last
        getAllMovies(node.getRight(), movies, index);
    }

    private static void quicksort(Movie[] movies) {
        quicksort(movies, 0, movies.length - 1);
    }

    private static void quicksort(Movie[] movies, int left, int right) {
        if(left < right) {
            int pivot = partition(movies, left, right);
            quicksort(movies, left, pivot - 1);
            quicksort(movies, pivot + 1, right);
        }
    }

    private static int partition(Movie[] movies, int left, int right) {
        int pivot = movies[left].getCount();
        while (left <= right) {
            while (movies[left].getCount() > pivot) {
                left++;
            }
            while (movies[right].getCount() < pivot) {
                right--;
            }
            if (left <= right) {
                Movie tmp = movies[left];
                movies[left] = movies[right];
                movies[right] = tmp;

                left++;
                right--;
            }
        }
        return left;
    }
}
