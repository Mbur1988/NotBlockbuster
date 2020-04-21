package Movies;

public class MovieCollection {

    public static MovieNode root;

    /**
     * Constructor
     */
    public MovieCollection() {
        this.root = null;
    }

    /**
     * Inserts a new movie node into the tree.
     * If a node containing the movie already exists in the tree then increment its number of copies
     * @param movie Instance of Movie class to insert into the tree
     */
    public void Insert(Movie movie) {
        // define the movie key as the hash code of the movie's title
        int movieKey = movie.getTitle().hashCode();
        // create a new node to be added tot he tree
        MovieNode node = new MovieNode(movie);
        // if root is null then insert the node as root
        if(root == null) {
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
            // if movie already exists then increment the number of copies
            if (movieKey == current.getKey()) {
                // increment copies variable by 1
                current.setCount(current.getCount() + 1);
                // end method
                return;
            }
            // if movie key is less than the current node key then movie will insert into the left subtree
            else if (movieKey < current.getKey()) {
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
            // if movie key is less than the current node key then movie will insert into the right subtree
            else {
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
        }
    }

    /**
     * Checks whether a movie is in the tree
     * @param movieTitle the title of the movie to search for
     * @return true if the movie is present else false
     */
    public boolean Find(String movieTitle) {
        // define the movie key as the hash code of the movie's title
        int movieKey = movieTitle.hashCode();
        // initialises the current node as root
        MovieNode current = root;
        // loop until current is null
        while (current != null) {
            // if the key of the current node is equal to the movie key then return true
            if (movieKey == current.getKey()) {
                // return true
                return true;
            }
            // if the movie key is less than the key of the current node then continue searching in the left subtree
            else if (movieKey < current.getKey()) {
                // set the left node as the new current node
                current = current.getLeft();
            }
            // if the movie key is greater than the key of the current node then continue searching in the right subtree
            else {
                // set the right node as the new current node
                current = current.getRight();
            }
        }
        // if the movie can not be found in the tree then return false
        return false;
    }

    /**
     * Return the node for a particular movie
     * @param movieTitle the title of the movie to search for
     * @return the node of the movie
     */
    public MovieNode Get(String movieTitle) {
        // define the movie key as the hash code of the movie's title
        int movieKey = movieTitle.hashCode();
        // initialises the current node as root
        MovieNode current = root;
        // loop until current is null
        while (current != null) {
            // if the key of the current node is equal to the movie key then return the current node
            if (movieKey == current.getKey()) {
                // return current node
                return current;
            }
            // if the movie key is less than the key of the current node then continue searching in the left subtree
            else if (movieKey < current.getKey()) {
                // set the left node as the new current node
                current = current.getLeft();
            }
            // if the movie key is greater than the key of the current node then continue searching in the right subtree
            else {
                // set the right node as the new current node
                current = current.getRight();
            }
        }
        // if the movie can not be found in the tree then return null
        return null;
    }

    /**
     * Deletes a movie from the tree
     * @param movieTitle the title of the movie to delete
     * @return true if the movie is deleted successfully else false
     */
    public boolean Delete(String movieTitle) {
        // define the movie key as the hash code of the movie's title
        int movieKey = movieTitle.hashCode();
        // declare current and parent placeholders for navigating the tree
        MovieNode parent = root;
        MovieNode current = root;
        // initiate boolean left child indicator as false
        boolean leftChild = false;
        // loop until the node to be deleted has been located or found to not exist
        while (current.getKey() != movieKey) {
            // assign parent to current
            parent = current;
            // if the movie key is less than the key of the current node then continue searching in the left subtree
            if (movieKey < current.getKey()) {
                // sets left child indicator to true
                leftChild = true;
                // set the left node as the new current node
                current = current.getLeft();
            }
            // if the movie key is greater than the key of the current node then continue searching in the right subtree
            else {
                // sets left child indicator to false
                leftChild = false;
                // set the right node as the new current node
                current = current.getRight();
            }
            // if the current node is found to be null then the movie can not be found and the method returns false
            if (current == null) {
                // return false
                return false;
            }
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
     * @param node the node that is to be deleted
     * @return the node that will take the place of the deleted node
     */
    public MovieNode getReplacement(MovieNode node) {
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
}
