package Main;

import java.util.Random;
import java.util.Scanner;

import CustomExceptions.MovieAlreadyExistsException;
import Members.MemberCollection;
import Movies.Movie;
import Movies.MovieCollection;

import static UserInterface.MainMenu.mainMenu;

public class Main {
    // Create static instances for use in program
    public static boolean exit;
    public static Scanner input; // to get user input from console
    public static MovieCollection movieCollection; // a binary search tree class used to store movies
    public static MemberCollection memberCollection; // an array class used to store members

    // Main method
    public static void main(String[] args) throws MovieAlreadyExistsException {

        // Initialise global variables
        exit = false;
        input = new Scanner(System.in);
        movieCollection = new MovieCollection();
        memberCollection = new MemberCollection();
        Movie movie = new Movie("movie00", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(2);
        movieCollection.Insert(movie);
        movie = new Movie("movie01", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(3);
        movieCollection.Insert(movie);
        movie = new Movie("movie02", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(5);
        movieCollection.Insert(movie);
        movie = new Movie("movie03", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(4);
        movieCollection.Insert(movie);
        movie = new Movie("movie04", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(8);
        movieCollection.Insert(movie);
        movie = new Movie("movie05", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(9);
        movieCollection.Insert(movie);
        movie = new Movie("movie06", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(7);
        movieCollection.Insert(movie);
        movie = new Movie("movie07", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(9);
        movieCollection.Insert(movie);
        movie = new Movie("movie08", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(7);
        movieCollection.Insert(movie);
        movie = new Movie("movie09", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(1);
        movieCollection.Insert(movie);
        movie = new Movie("movie10", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(0);
        movieCollection.Insert(movie);
        movie = new Movie("movie11", "test", "test", "test", "test", 1, 1, 1);
        movie.setCount(3);
        movieCollection.Insert(movie);
        movieCollection.displayTop10();
        // enter mainMenu()
        while (!exit) {
            mainMenu();
        }
//        int array[] = {4, 8, -1,-1, 6, 2, 6, 4, 8, 311, 6, 6, 56, 5, 61, -99, 61, 6, 4, 6, 4, 61, 65, 1, 0, -409, 6, 6, 26, 61, 6626, 64, 61,656, 3, 9, 0};
//        int array[] = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
//        quickSort(array);
//        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    private static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Partition the array list[first..last]
     */
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }
}