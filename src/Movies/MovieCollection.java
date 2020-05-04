package Movies;

import CustomExceptions.MovieAlreadyExistsException;
import CustomExceptions.MovieDoesNotExistException;

public class MovieCollection {

    private static MovieNode root;
    public static int count;

    /**
     * Constructor
     */
    public MovieCollection() {
        this.root = null;
        this.count = 0;
    }

    /**
     * returns the root node of the movie collection
     * Used only for testing purposes
     *
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
            // increment count
            this.count++;
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
                    // increment count
                    this.count++;
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
                    // increment count
                    this.count++;
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
     * Return the movie class of a particular movie
     *
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
        // decrement count when a movie has been deleted successfully
        this.count--;
        // return true to indicate that the movie has been deleted successfully
        return true;
    }

    /**
     * Gets the replacement node of one to be deleted. the replacement is the minimum node of the right subtree
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
        // if the replacement has a right child add it to the left child node of its parent
        if (replacement != node.getRight()) {
            // update the parent of the replacement's left node to the right node of the replacement
            parent.setLeft(replacement.getRight());
            // update the right node of the replacement to the right node of the node to be deleted
            replacement.setRight(node.getRight());
        }
        // return the replacement node
        return replacement;
    }

    /**
     * User friendly method call to display all movie details in order of movie titles
     */
    public void displayInOrder() {
        // call displayInOrder() method with the root node of the binary search tree as its parameter
        displayInOrder(root);
    }

    /**
     * Displays all movie details in order of movie titles
     *
     * @param node the root node of the binary search tree
     */
    private void displayInOrder(MovieNode node) {
        // if the node is null then return
        if (node != null) {
            // explore the left subtree first as this contains the lower values
            displayInOrder(node.getLeft());
            // display the movie details of the current node
            node.getMovie().display();
            // explore the right subtree last as this contains higher values
            displayInOrder(node.getRight());
        }
    }

    /**
     * Returns an array containing all movies in the collection ordered by the number of times they are rented
     *
     * @return array of movies sorted by number of rentals
     */
    public static void displayTop10() {
        // declare and initialise an array of movies the size of the number of movies in the binary search tree
        Movie[] movies = new Movie[count];
        // declare an integer as an index for the movie array - initialise to 0
        int index = 0;
        // populate the movie array with all nodes contained in the binary search tree in ascending order
        getAllMovies(root, movies, index);
        // sort the movies contained in the movies array by rental count using a quick sort algorithm
        quicksort(movies);
        printTop10(movies);
    }

    /**
     * Populates an array with all movies contained in the binary search tree in lexicographical order
     *
     * @param node   should be the root node of the tree when calling the method
     * @param movies array to be populated. The array size should equal the number of nodes in the binary search tree
     * @param index  an integer index set to zero
     */
    private static void getAllMovies(MovieNode node, Movie[] movies, int index) {
        if (node != null) {
            // Get all movies from the left subtree first
            getAllMovies(node.getLeft(), movies, index);
            // Add the movie from this node to the array
            movies[index++] = node.getMovie();
            // Get all movies from the right subtree last
            getAllMovies(node.getRight(), movies, index);
        }
    }

    /**
     * Quicksort is a divide-and-conquer algorithm that comprises two main components; partition and quicksort.
     * It works by selecting a 'pivot' element from the array and partitioning the other elements into two sub-arrays,
     * according to whether they are less than or greater than the pivot. The sub-arrays are then sorted recursively.
     * Mathematical analysis of quicksort shows that the average time efficiency of the algorithm is O(n log n)
     * and that the worst case, is O(n2), although a worst case scenario is rare.
     * An advantage of quicksort over other sorting algorithms is that it does not swap objects that are already
     * in order which, generally, makes it faster. Additionally, quicksort does not require any temporary storage space,
     * although, this advantage comes with the disadvantage of not preserving the array in its original form.
     *
     * @param movies the array to be sorted. In this program the list should comprise of movie objects as the quicksort
     *               method has been modified to sort by movie objects by the number of rentals parameter 'count'.
     */
    private static void quicksort(Movie[] movies) {
        // calls the quicksort component specifying the left index as 0 and the right index as the array length -1
        quicksort(movies, 0, movies.length - 1);
    }

    /**
     * The quicksort component to the quicksort algorithm. The input array is processed by the partition method which
     * splits the array into a pivot (the first element) and two smaller partitions (refer to partition method).
     * Each of these partitions is then passed into this same quicksort method for recursive sorting until the array is
     * sorted (left index is equal to or larger than the right index).
     *
     * @param movies the array or partitioned subarray to be sorted
     * @param low    the low index of the movies array to be sorted
     * @param high     the high index of the movies array to be sorted
     */
    private static void quicksort(Movie[] movies, int low, int high) {
        if (high > low) {
            // partition the array using the partition method and get the pivot value
            int pivot = partition(movies, low, high);
            // quicksort the left partition recursively (values lower than the pivot)
            quicksort(movies, low, pivot - 1);
            // quicksort the right partition recursively (values higher than the pivot)
            quicksort(movies, pivot + 1, high);
        }
    }

    /**
     * Based on Hoare's partition scheme. This version sets the first index of the array as the pivot and then uses two
     * indices, starting at either end of the array. These two indices are moved toward each other until they detect a
     * pair of elements, one greater than or equal to the pivot, one lesser or equal, that are in the wrong order
     * relative to each other. These inverted elements are then swapped.
     *
     * @param movies the array or partitioned subarray to be sorted
     * @param low  the low index of the movies array to be sorted
     * @param high   the high index of the movies array to be sorted
     * @return the movie rental count ot the pivot element as an integer
     */
    private static int partition(Movie[] movies, int low, int high) {
        // set the first index value as the pivot
        int pivot = movies[low].getCount();
        // set left and right search indexes
        int left = low + 1; // Index for forward search
        int right = high; // Index for backward search
        // loop until the indexes meet
        while (right > left) {
            // increment left index through the array until an element is found with a value greater than the pivot
            while (left <= right && movies[left].getCount() <= pivot)
                left++;
            // decrement right index through the array until an element is found with a value less than the pivot
            while (left <= right && movies[right].getCount() > pivot)
                right--;
            // ensure that the right index is higher than the left index
            if (right > left) {
                // swap the elements at the left and right indices
                Movie temp = movies[right];
                movies[right] = movies[left];
                movies[left] = temp;
            }
        }
        // find the index of the location of the pivot in the partitioned array
        while (right > low && movies[right].getCount() >= pivot)
            right--;
        // put the pivot in the correct position and return its index
        if (pivot > movies[right].getCount()) {
            Movie temp = movies[low];
            movies[low] = movies[right];
            movies[right] = temp;
            return right;
        }
        //
        else {
            return low;
        }
    }

    private static void printTop10(Movie[] movies) {
        int count = 1;
        for (int index = movies.length - 1; index > movies.length - 11; index--) {
            try {
                System.out.println(count++
                        + ". "
                        + movies[index].getTitle()
                        + " - Rented " + movies[index].getCount()
                        + " times");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
    }
}
