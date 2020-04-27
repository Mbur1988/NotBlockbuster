package Main;

import java.util.Scanner;
import Members.MemberCollection;
import Movies.MovieCollection;
import static UserInterface.MainMenu.mainMenu;

public class Main {
    // Create static instances for use in program
    public static boolean exit;
    public static Scanner input; // to get user input from console
    public static MovieCollection movieCollection; // a binary search tree class used to store movies
    public static MemberCollection memberCollection; // an array class used to store members

    // Main method
    public static void main(String[] args) {

        // Initialise global variables
        exit = false;
        input = new Scanner(System.in);
        movieCollection = new MovieCollection();
        memberCollection = new MemberCollection();
        // enter mainMenu()
        while (!exit) {
            mainMenu();
        }
    }
}