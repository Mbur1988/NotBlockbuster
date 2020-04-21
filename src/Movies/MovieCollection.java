package Movies;

public class MovieCollection {

    public static Node root;

    public MovieCollection() {
        this.root = null;
    }

    public void Insert(Movie movie) {
        Node newNode = new Node(movie);
        if(root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (movie.getTitle().hashCode() == current.key) {
                current.setCount(current.getCount() + 1);
                return;
            }
            else if (movie.getTitle().hashCode() < current.key) {
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

    public boolean Find(String movieTitle) {
        Node current = root;
        while (current != null) {
            if (current.key == movieTitle.hashCode()) {
                return true;
            }
            else if (current.key > movieTitle.hashCode()) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return false;
    }

    public Node Get(String movieTitle) {
        Node current = root;
        while (current != null) {
            if (current.key == movieTitle.hashCode()) {
                return current;
            }
            else if (current.key > movieTitle.hashCode()) {
                current = current.left;
            }
            else {
                current = current.right;
            }
        }
        return null;
    }
}
