package Movies;

public class MovieCollection {

    public static Node root;

    /**
     * Constructor
     */
    public MovieCollection() {
        this.root = null;
    }

    /**
     *
     * @param movie
     */
    public void Insert(Movie movie) {
        int movieKey = movie.getTitle().hashCode();
        Node newNode = new Node(movie);
        if(root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (movieKey == current.key) {
                current.setCount(current.getCount() + 1);
                return;
            }
            else if (movieKey < current.key) {
                current = current.left;
                if (current == null) {
                    parent.left = newNode;
                    return;
                }
            }
            else {
                current = current.right;
                if (current == null) {
                    parent.right = newNode;
                    return;
                }
            }
        }
    }

    /**
     *
     * @param movieTitle
     * @return
     */
    public boolean Find(String movieTitle) {
        int movieKey = movieTitle.hashCode();
        Node current = root;
        while (current != null) {
            if (current.key == movieKey) {
                return true;
            }
            else if (current.key > movieKey) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return false;
    }

    /**
     *
     * @param movieTitle
     * @return
     */
    public Node Get(String movieTitle) {
        int movieKey = movieTitle.hashCode();
        Node current = root;
        while (current != null) {
            if (current.key == movieKey) {
                return current;
            }
            else if (current.key > movieKey) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return null;
    }

    /**
     *
     * @param movieTitle
     * @return
     */
    public boolean Delete(String movieTitle) {
        int movieKey = movieTitle.hashCode();
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.key != movieKey) {
            parent = current;
            if (current.key > movieKey) {
                isLeftChild = true;
                current = current.left;
            }
            else {
                isLeftChild = false;
                current = current.right;
            }
            if (current == null) {
                return false;
            }
        }
        //if i am here that means we have found the node
        //Case 1: if node to be deleted has no children
        if (current.left == null && current.right == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
        //Case 2 : if node to be deleted has only one child
        else if (current.right == null) {
            if (current == root) {
                root = current.left;
            }
            else if (isLeftChild) {
                parent.left = current.left;
            }
            else {
                parent.right = current.left;
            }
        }
        else if (current.left == null) {
            if (current == root) {
                root = current.right;
            }
            else if (isLeftChild) {
                parent.left = current.right;
            }
            else {
                parent.right = current.right;
            }
        }
        //Case 3 : if node to be deleted has two children
        else if (current.left != null && current.right != null) {

            //now we have found the minimum element in the right sub tree
            Node successor = getReplacement(current);
            if(current == root){
                root = successor;
            }
            else if (isLeftChild) {
                parent.left = successor;
            }
            else {
                parent.right = successor;
            }
            successor.left = current.left;
        }
        return true;
    }

    public Node getReplacement(Node deleleNode) {
        Node replacement = null;
        Node replacementParent = null;
        Node current = deleleNode.right;
        while (current != null) {
            replacementParent = replacement;
            replacement = current;
            current = current.left;
        }
        // check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
        if (replacement != deleleNode.right) {
            replacementParent.left = replacement.right;
            replacement.right = deleleNode.right;
        }
        return replacement;
    }
}
