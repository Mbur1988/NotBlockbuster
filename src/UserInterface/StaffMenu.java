package UserInterface;

import CustomExceptions.MovieAlreadyExistsException;
import Main.Main;
import Movies.Movie;
import static UserInterface.MainMenu.mainMenu;

public class StaffMenu {

    private static String[] genres = {
            "Drama",
            "Adventure",
            "Family",
            "Action",
            "Sci-Fi",
            "Comedy",
            "Animated",
            "Thriller",
            "Other"};

    private static String[] classifications = {
            "General (G)",
            "Parental Guidance (PG)",
            "Mature (M15+)",
            "Mature Accompanied (MA15+)"};

    static void staffLogin() {
        System.out.println();
        System.out.print("Enter Username: ");
        String username = Main.input.nextLine();
        System.out.print("Enter Password: ");
        String password = Main.input.nextLine();
        if (username.equals("staff") && password.equals("today123")) {
            staffMenu();
        }
        else {
            System.out.println("Username or password incorrect");
            mainMenu();
        }
    }

    private static void staffMenu() {
        System.out.println();
        System.out.println("===========Staff Menu============");
        System.out.println("1. Add a new movie DVD");
        System.out.println("2. Remove a movie DVD");
        System.out.println("3. Register a new member");
        System.out.println("4. Find a registered member's phone number");
        System.out.println("0. Return to main menu");
        System.out.println("================================");
        while (true) {
            System.out.print("Please make a selection (1-4, or 0 to return to main menu): ");

            String line = Main.input.nextLine();
            if (line.equals("0")) {
                mainMenu();
            } else if (line.equals("1")) {
                addMovie();
            } else if (line.equals("2")) {
                removeMovie();
            } else if (line.equals("3")) {
                registerMember();
            } else if (line.equals("4")) {
                findNumber();
            } else {
                System.out.println("Must me a valid integer!");
            }
        }
    }

    private static void addMovie() {
        System.out.print("\nEnter the movie title: ");
        String title = Main.input.nextLine();
        System.out.print("Enter the starring actor(s): ");
        String starring = Main.input.nextLine();
        System.out.print("Enter the director(s): ");
        String director = Main.input.nextLine();
        String genre = getGenre();
        String classification = getClassification();
        Integer duration = null;
        while(duration == null) {
            System.out.print("Enter the duration (minutes): ");
            try { duration = Integer.parseInt(Main.input.nextLine()); }
            catch (NumberFormatException e) { System.out.println("Must me a valid integer!"); }
        }
        Integer release_date = null;
        while(release_date == null) {
            System.out.print("Enter the release date (year): ");
            try { release_date = Integer.parseInt(Main.input.nextLine()); }
            catch (NumberFormatException e) { System.out.println("Must me a valid integer!"); }
        }
        Integer copies = null;
        while(copies == null) {
            System.out.print("Enter the number of copies available: ");
            try { copies = Integer.parseInt(Main.input.nextLine()); }
            catch (NumberFormatException e) { System.out.println("Must me a valid integer!"); }
        }
        Movie movie = new Movie(title,
                starring,
                director,
                genre,
                classification,
                duration,
                release_date,
                copies);
        try {
            Main.movieCollection.Insert(movie);
        }
        catch (MovieAlreadyExistsException e) {
            System.out.println("A movie with this title already exists in the movie collection");
        }
        staffMenu();
    }

    private static String getGenre() {
        System.out.println("");
        System.out.println("Select the genre:");
        for (int i = 0; i < genres.length; i++) {
            System.out.println(i + 1 + ". " + genres[i]);
        }
        Integer number = null;
        while(number == null) {
            System.out.print("Make selection(1-9): ");
            try {
                number = Integer.parseInt(Main.input.nextLine());
                if (number < 1 || number > 9) {
                    number = null;
                    System.out.println("Must me a valid integer!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Must me a valid integer!");
            }
        }
        return genres[number - 1];
    }

    private static String getClassification() {
        System.out.println("");
        System.out.println("Select the classification:");
        for (int i = 0; i < classifications.length; i++) {
            System.out.println(i + 1 + ". " + classifications[i]);
        }
        Integer number = null;
        while(number == null) {
            System.out.print("Make selection(1-4): ");
            try {
                number = Integer.parseInt(Main.input.nextLine());
                if (number < 1 || number > 4) {
                    number = null;
                    System.out.println("Must me a valid integer!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Must me a valid integer!");
            }
        }
        return classifications[number - 1];
    }

    private static void removeMovie() {
        System.out.print("\nEnter the title of the movie to be deleted: ");
        String title = Main.input.nextLine();
        if(!Main.movieCollection.Delete(title)) {
            System.out.println("No movie with this title exists in the movie collection");
        }
        staffMenu();
    }

    private static void registerMember() {

    }

    private static void findNumber() {

    }
}
