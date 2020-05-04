package UserInterface;

import CustomExceptions.CopiesOutOfBoundsException;
import CustomExceptions.MovieAlreadyExistsException;
import CustomExceptions.MovieDoesNotExistException;
import CustomExceptions.RentalsOutOfBoundsException;
import Movies.Movie;
import static Main.Main.*;
import static UserInterface.MainMenu.mainMenu;

public class MemberMenu {

    private static String username;

    static void memberLogin() {
        System.out.println();
        System.out.print("Enter your Username(LastnameFirstname): ");
        username = input.nextLine();
        if (memberCollection.search(username) == -1) {
            System.out.println("User " + username + " does not exist.");
            return;
        }
        System.out.print("Enter password: ");
        String pass = input.nextLine();
        int password = 0;
        try {
            password = Integer.parseInt(pass);
        } catch (NumberFormatException e) {
            System.out.println("Password incorrect");
            return;
        }
        if (password == memberCollection.members[memberCollection.search(username)].getPassword()) {
            memberMenu();
            return;
        }
        else {
            System.out.println("Password incorrect");
            return;
        }
    }

    private static void memberMenu() {
        memberMenuMessage();
        while (true) {
            System.out.print("Please make a selection (1-4, or 0 to return to main menu): ");

            String line = input.nextLine();
            if (line.equals("0")) {
                return;
            }
            else if (line.equals("1")) {
                displayMovies();
                memberMenuMessage();
            }
            else if (line.equals("2")) {
                borrowMovie();
                memberMenuMessage();
            }
            else if (line.equals("3")) {
                returnMovie();
                memberMenuMessage();
            }
            else if (line.equals("4")) {
                listCurrentRentals();
                memberMenuMessage();
            }
            else if (line.equals("5")) {
                displayTop10();
                memberMenuMessage();
            }
            else {
                System.out.println("Must me a valid integer!");
            }
        }
    }

    private static void memberMenuMessage() {
        System.out.println();
        System.out.println("===========Member Menu============");
        System.out.println("1. Display all movies");
        System.out.println("2. Borrow a movie DVD");
        System.out.println("3. Return a movie DVD");
        System.out.println("4. List current borrowed movie DVDs");
        System.out.println("5. Display top 10 most popular movies");
        System.out.println("0. Return to main menu");
        System.out.println("================================");
    }

    private static void displayMovies() {
        movieCollection.displayInOrder();
    }

    private static void borrowMovie() {
        System.out.println();
        System.out.print("Enter movie title: ");
        String movieTitle = input.nextLine();
        Movie movie;
        try {
            movie = movieCollection.Get(movieTitle);
            movie.decrementCopies();
            memberCollection.members[memberCollection.search(username)].Rent(movieTitle);
            movie.incrementCount();
            System.out.println("You borrowed " + movieTitle);
        }
        catch (MovieDoesNotExistException e) {
            System.out.println("Movie " + movieTitle + " does not exist");
        }
        catch (CopiesOutOfBoundsException e) {
            System.out.println("Sorry, there are no copies of " + movieTitle + " available to rent");
        }
        catch (RentalsOutOfBoundsException e) {
            System.out.println("You can't borrow more then 10 movies - please return one first");
        }
        catch (MovieAlreadyExistsException e) {
            System.out.println("You are already renting a copy of " + movieTitle);
        }
    }

    private static void returnMovie() {
        System.out.println();
        System.out.print("Enter movie title: ");
        String movieTitle = input.nextLine();
        try {
            memberCollection.members[memberCollection.search(username)].Return(movieTitle);
            movieCollection.Get(movieTitle).incrementCopies();
            System.out.println("You returned " + movieTitle);
        }
        catch (MovieDoesNotExistException e) {
            System.out.println("You are not currently renting " + movieTitle);
        }
        catch (CopiesOutOfBoundsException e) {
            System.out.println("You can not return " + movieTitle);
        }
    }

    private static void listCurrentRentals() {
        memberCollection.members[memberCollection.search(username)].showRenting();
    }

    public static void displayTop10() {
        Movie[] movies = movieCollection.getTopMovies();
        int count = 0;
        while (count < 10) {
            try {
                System.out.println(count + 1 + ". " + movies[count].getTitle());
                count++;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                return;
            }
        }
    }
}
