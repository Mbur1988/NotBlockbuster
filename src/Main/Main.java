package Main;

import Members.MemberCollection;
import Movies.Movie;
import Movies.MovieCollection;
import java.util.Scanner;
import static UserInterface.MainMenu.mainMenu;

public class Main {

    public static Scanner input;
    public static MovieCollection movieCollection;
    public static MemberCollection memberCollection;

    public static void main(String[] args) {

        input = new Scanner(System.in);
        movieCollection = new MovieCollection();
        memberCollection = new MemberCollection();
        mainMenu();
    }
}