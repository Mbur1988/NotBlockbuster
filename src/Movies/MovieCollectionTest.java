package Movies;

import CustomExceptions.MovieAlreadyExistsException;
import CustomExceptions.MovieDoesNotExistException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MovieCollectionTest {

    MovieCollection movieCollection;

    @BeforeEach
    void setUp() {
        movieCollection = new MovieCollection();
    }

    @Test
    void insert() throws MovieAlreadyExistsException {
        Movie movie = new Movie(
                "test",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        assertEquals(movieCollection.root.getMovie().getTitle(), "test");
    }

    @Test
    void insertLeft() throws MovieAlreadyExistsException {
        Movie movie = new Movie(
                "b",
                "test",
                "test",
                "test",
                "test",
                2,
                2,
                2);
        movieCollection.Insert(movie);
        movie = new Movie(
                "a",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        assertEquals(movieCollection.root.getLeft().getMovie().getTitle(), "a");
    }

    @Test
    void insertRight() throws MovieAlreadyExistsException {
        Movie movie = new Movie(
                "a",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        movie = new Movie(
                "b",
                "test",
                "test",
                "test",
                "test",
                2,
                2,
                2);
        movieCollection.Insert(movie);
        assertEquals(movieCollection.root.getRight().getMovie().getTitle(), "b");
    }

    @Test
    void insertAlreadyExists() throws MovieAlreadyExistsException {
        Movie movie = new Movie(
                "a",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        assertThrows(MovieAlreadyExistsException.class, () ->
                movieCollection.Insert(movie));    }

    @Test
    void get() throws MovieAlreadyExistsException, MovieDoesNotExistException {
        Movie movie = new Movie(
                "test",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        assertEquals(movieCollection.Get("test").getDuration(), 1);
    }

    @Test
    void getLeft() throws MovieAlreadyExistsException, MovieDoesNotExistException {
        Movie movie = new Movie(
                "b",
                "test",
                "test",
                "test",
                "test",
                2,
                2,
                2);
        movieCollection.Insert(movie);
        movie = new Movie(
                "a",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        assertEquals(movieCollection.Get("a").getDuration(), 1);
    }

    @Test
    void getRight() throws MovieAlreadyExistsException, MovieDoesNotExistException {
        Movie movie = new Movie(
                "a",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        movie = new Movie(
                "b",
                "test",
                "test",
                "test",
                "test",
                2,
                2,
                2);
        movieCollection.Insert(movie);
        assertEquals(movieCollection.Get("b").getDuration(), 2);
    }

    @Test
    void getDoesNotExist() {
        assertThrows(MovieDoesNotExistException.class, () ->
                movieCollection.Get("test"));
    }

    @Test
    void delete() throws MovieAlreadyExistsException, MovieDoesNotExistException {
        Movie movie = new Movie(
                "test",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        movieCollection.Delete("test");
    }

    @Test
    void deleteLeft() throws MovieAlreadyExistsException, MovieDoesNotExistException {
        Movie movie = new Movie(
                "b",
                "test",
                "test",
                "test",
                "test",
                2,
                2,
                2);
        movieCollection.Insert(movie);
        movie = new Movie(
                "a",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        movieCollection.Delete("a");
    }

    @Test
    void deleteRight() throws MovieAlreadyExistsException, MovieDoesNotExistException {
        Movie movie = new Movie(
                "a",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        movie = new Movie(
                "b",
                "test",
                "test",
                "test",
                "test",
                2,
                2,
                2);
        movieCollection.Insert(movie);
        movieCollection.Delete("b");
    }

    @Test
    void deleteDoesNotExist_1() {
        assertThrows(MovieDoesNotExistException.class, () ->
                movieCollection.Delete("test"));
    }

    @Test
    void deleteDoesNotExist_2() throws MovieAlreadyExistsException {
        Movie movie = new Movie(
                "test",
                "test",
                "test",
                "test",
                "test",
                1,
                1,
                1);
        movieCollection.Insert(movie);
        assertThrows(MovieDoesNotExistException.class, () ->
                movieCollection.Delete("test1"));
    }

    @Test
    void inOrder() {
    }
}