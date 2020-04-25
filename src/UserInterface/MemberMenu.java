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
            MainMenu.mainMenu();
        }
        System.out.print("Enter password: ");
        String pass = input.nextLine();
        int password = 0;
        try {
            password = Integer.parseInt(pass);
        } catch (NumberFormatException e) {
            System.out.println("Password incorrect");
            MainMenu.mainMenu();
        }
        if (password == memberCollection.members[memberCollection.search(username)].getPassword()) {
            memberMenu();
        } else {
            System.out.print("Password incorrect");
            MainMenu.mainMenu();
        }
    }

    private static void memberMenu() {
        System.out.println();
        System.out.println("===========Member Menu============");
        System.out.println("1. Display all movies");
        System.out.println("2. Borrow a movie DVD");
        System.out.println("3. Return a movie DVD");
        System.out.println("4. List current borrowed movie DVDs");
        System.out.println("5. Display top 10 most popular movies");
        System.out.println("0. Return to main menu");
        System.out.println("================================");
        while (true) {
            System.out.print("Please make a selection (1-4, or 0 to return to main menu): ");

            String line = input.nextLine();
            if (line.equals("0")) {
                mainMenu();
            } else if (line.equals("1")) {
                displayMovies();
            } else if (line.equals("2")) {
                borrowMovie();
            } else if (line.equals("3")) {
                returnMovie();
            } else if (line.equals("4")) {
                listCurrentRentals();
            } else if (line.equals("5")) {
                displayTop10();
            } else {
                System.out.println("Must me a valid integer!");
            }
        }
    }

    private static void displayMovies() {
        movieCollection.inOrder();
        memberMenu();
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
            memberMenu();
        } catch (MovieDoesNotExistException e) {
            System.out.println("Movie " + movieTitle + " does not exist");
            memberMenu();
        } catch (CopiesOutOfBoundsException e) {
            System.out.println("Sorry, there are no copies of " + movieTitle + " available to rent");
            memberMenu();
        } catch (RentalsOutOfBoundsException e) {
            System.out.println("You can't borrow more then 10 movies - please return one first");
            memberMenu();
        } catch (MovieAlreadyExistsException e) {
            System.out.println("You are already renting a copy of " + movieTitle);
            memberMenu();
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
            memberMenu();
        } catch (MovieDoesNotExistException e) {
            System.out.println("You are not currently renting " + movieTitle);
            memberMenu();
        } catch (CopiesOutOfBoundsException e) {
            e.printStackTrace();
        }
    }

    private static void listCurrentRentals() {
        memberCollection.members[memberCollection.search(username)].showRenting();
        memberMenu();
    }

    private static void displayTop10() {

    }
}
