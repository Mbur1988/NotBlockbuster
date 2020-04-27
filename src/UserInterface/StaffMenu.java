package UserInterface;

import CustomExceptions.*;
import Members.Member;
import Movies.Movie;
import static Main.Main.input;
import static Main.Main.memberCollection;
import static Main.Main.movieCollection;
import static UserInterface.MainMenu.mainMenu;

public class StaffMenu {

    private static final String[] GENRES = {
            "Drama",
            "Adventure",
            "Family",
            "Action",
            "Sci-Fi",
            "Comedy",
            "Animated",
            "Thriller",
            "Other"};

    private static final String[] CLASSIFICATIONS = {
            "General (G)",
            "Parental Guidance (PG)",
            "Mature (M15+)",
            "Mature Accompanied (MA15+)"};

    static void staffLogin() {
        System.out.println();
        System.out.print("Enter Username: ");
        String username = input.nextLine();
        if (!username.equals("staff")) {
            System.out.println("User " + username + " does not exist.");
            return;
        }
        System.out.print("Enter Password: ");
        String password = input.nextLine();
        if (username.equals("staff") && password.equals("today123")) {
            staffMenu();
            return;
        }
        else {
            System.out.println("Password incorrect");
            return;
        }
    }

    private static void staffMenu() {
        staffMenuMessage();
        while (true) {
            System.out.print("Please make a selection (1-4, or 0 to return to main menu): ");

            String line = input.nextLine();
            if (line.equals("0")) {
                return;
            }
            else if (line.equals("1")) {
                addMovie();
                staffMenuMessage();
            }
            else if (line.equals("2")) {
                removeMovie();
                staffMenuMessage();
            }
            else if (line.equals("3")) {
                registerMember();
                staffMenuMessage();
            }
            else if (line.equals("4")) {
                findNumber();
                staffMenuMessage();
            }
            else {
                System.out.println("Must me a valid integer!");
            }
        }
    }

    private static void staffMenuMessage() {
        System.out.println();
        System.out.println("===========Staff Menu============");
        System.out.println("1. Add a new movie DVD");
        System.out.println("2. Remove a movie DVD");
        System.out.println("3. Register a new member");
        System.out.println("4. Find a registered member's phone number");
        System.out.println("0. Return to main menu");
        System.out.println("================================");
    }

    private static void addMovie() {
        System.out.println();
        System.out.print("Enter the movie title: ");
        String title = input.nextLine();
        System.out.print("Enter the starring actor(s): ");
        String starring = input.nextLine();
        System.out.print("Enter the director(s): ");
        String director = input.nextLine();
        String genre = getGenre();
        String classification = getClassification();
        Integer duration = null;
        while(duration == null) {
            System.out.print("Enter the duration (minutes): ");
            try { duration = Integer.parseInt(input.nextLine()); }
            catch (NumberFormatException e) { System.out.println("Must me a valid integer!"); }
        }
        Integer release_date = null;
        while(release_date == null) {
            System.out.print("Enter the release date (year): ");
            try { release_date = Integer.parseInt(input.nextLine()); }
            catch (NumberFormatException e) { System.out.println("Must me a valid integer!"); }
        }
        Integer copies = null;
        while(copies == null) {
            System.out.print("Enter the number of copies available: ");
            try { copies = Integer.parseInt(input.nextLine()); }
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
            movieCollection.Insert(movie);
            System.out.println(movie.getTitle() + " was added");
        }
        catch (MovieAlreadyExistsException e) {
            System.out.println("A movie with this title already exists in the movie collection");
        }
    }

    private static String getGenre() {
        System.out.println("");
        System.out.println("Select the genre:");
        for (int i = 0; i < GENRES.length; i++) {
            System.out.println(i + 1 + ". " + GENRES[i]);
        }
        Integer number = null;
        while(number == null) {
            System.out.print("Make selection(1-9): ");
            try {
                number = Integer.parseInt(input.nextLine());
                if (number < 1 || number > 9) {
                    number = null;
                    System.out.println("Must me a valid integer!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Must me a valid integer!");
            }
        }
        return GENRES[number - 1];
    }

    private static String getClassification() {
        System.out.println("");
        System.out.println("Select the classification:");
        for (int i = 0; i < CLASSIFICATIONS.length; i++) {
            System.out.println(i + 1 + ". " + CLASSIFICATIONS[i]);
        }
        Integer number = null;
        while(number == null) {
            System.out.print("Make selection(1-4): ");
            try {
                number = Integer.parseInt(input.nextLine());
                if (number < 1 || number > 4) {
                    number = null;
                    System.out.println("Must me a valid integer!");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Must me a valid integer!");
            }
        }
        return CLASSIFICATIONS[number - 1];
    }

    private static void removeMovie() {
        System.out.println();
        System.out.print("Enter movie title: ");
        String title = input.nextLine();
        try {
            movieCollection.Delete(title);
            System.out.println(title + " was deleted");

        }
        catch (MovieDoesNotExistException e) {
            System.out.println("No movie with this title exists in the movie collection");
        }
    }

    private static void registerMember() {
        System.out.println();
        System.out.print("Enter member's first name: ");
        String first = input.nextLine();
        System.out.print("Enter member's last name ");
        String last = input.nextLine();
        if (memberCollection.search(last+first) != -1) {
            System.out.println(first + " " + last + " has already registered.");
            return;
        }
        System.out.print("Enter member's address: ");
        String address = input.nextLine();
        System.out.print("Enter member's phone number: ");
        String phone = input.nextLine();
        System.out.print("Enter member's password(4 digits): ");
        String password = input.nextLine();
        try {
            Member member = new Member(last+first, address, phone, password);
            memberCollection.add(member);
            System.out.println("Successfully added " + first + " " + last);
        }
        catch (PasswordOutOfBoundsException e) {
            System.out.println("Invalid password - password must be 4 digits");
        }
        catch (MemberAlreadyExistsException e) {
            System.out.println("A member with this name already exists - member names must be unique");
        }
        catch (MembersOutOfBoundsException e) {
            System.out.println("Member collection is full");
        }
    }

    private static void findNumber() {
        System.out.println();
        System.out.print("Enter member's first name: ");
        String first = input.nextLine();
        System.out.print("Enter member's last name: ");
        String last = input.nextLine();
        int index = memberCollection.search(last + first);
        if (index == -1) {
            System.out.println("User " + last + first + " does not exist.");
            return;
        }
        String number = memberCollection.members[index].getNumber();
        System.out.println(first + " " + last + "'s phone number is: " + number);
    }
}