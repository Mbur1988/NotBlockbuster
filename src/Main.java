import Movies.Movie;
import Movies.MovieCollection;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Movie movie = new Movie("Pulp Fiction",
                new ArrayList<String>(Arrays.asList("John Travolta", "Uma Thurman", "Samuel L. Jackson", "Bruce Willis")),
                "Quentin Tarantino",
                Duration.ofMinutes(178),
                "Crime/Comedy",
                "MA15+",
                LocalDate.of(1994, Month.NOVEMBER, 24));

        MovieCollection mc = new MovieCollection();

        mc.Insert(movie);
        mc.Insert(movie);

        System.out.println(mc.Find("Pulp Fiction"));

        movie = new Movie("lp Fiction",
                new ArrayList<String>(Arrays.asList("John Travolta", "Uma Thurman", "Samuel L. Jackson", "Bruce Willis")),
                "Quentin Tarantino",
                Duration.ofMinutes(178),
                "Crime/Comedy",
                "MA15+",
                LocalDate.of(1994, Month.NOVEMBER, 24));

        mc.Insert(movie);

        System.out.println(mc.Find("Pulp Fiction"));
        System.out.println(mc.Find("lp Fiction"));

        System.out.println(mc.Get("lp Fiction").getMovie().getDirector());
        System.out.println(mc.Get("Pulp Fiction").getMovie().getCopies());
        System.out.println(mc.Get("lp Fiction").getMovie().getGenre());

        mc.Delete("Pulp Fiction");
        System.out.println(mc.Find("Pulp Fiction"));
    }
}