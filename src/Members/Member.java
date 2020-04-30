package Members;

import CustomExceptions.MovieAlreadyExistsException;
import CustomExceptions.MovieDoesNotExistException;
import CustomExceptions.PasswordOutOfBoundsException;
import CustomExceptions.RentalsOutOfBoundsException;

public class Member {

    private String full_name;
    private String address;
    private String number;
    private int password;
    String[] renting; // kept unsorted

    /**
     * Constructor
     * @param full_name member's full name
     * @param address member's residential address
     * @param number member's contact phone number
     * @param password member's password
     * @throws PasswordOutOfBoundsException
     */
    public Member(String full_name, String address, String number, String password) throws PasswordOutOfBoundsException {
        this.full_name = full_name;
        this.address = address;
        this.number = number;
        setPassword(password);
        this.renting = new String[10];
    }

    /**
     * gets the full name of the member
     * @return full name as string
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * gets the contact phone number of the member
     * @return phone number as string
     */
    public String getNumber() {
        return number;
    }

    /**
     * gets the password of the member
     * @return password as integer
     */
    public int getPassword() {
        return password;
    }

    /**
     * sets the password of the member
     * @param password as integer
     */
    public void setPassword(String password) throws PasswordOutOfBoundsException {
        // if the password does not comprise 4 characters then throw out of bounds exception
        if (password.length() != 4) {
            // throw exception
            throw new PasswordOutOfBoundsException();
        }
        // try to parse password from string to integer
        try {
            this.password = Integer.parseInt(password);
        }
        // if the password string does not comprise integers then throw out of bounds exception
        catch (NumberFormatException e) {
            // throw exception
            throw new PasswordOutOfBoundsException();
        }
    }

    /**
     * adds movie to the unsorted renting list
     * @param movieTitle
     * @throws MovieAlreadyExistsException
     */
    public void Rent(String movieTitle) throws MovieAlreadyExistsException, RentalsOutOfBoundsException {
        // if the member is already renting 10 movies then throw exception
        if (renting[renting.length - 1] != null) {
            // throw exception
            throw new RentalsOutOfBoundsException();
        }
        // iterate through existing renting list to find empty slot for new movie rental
        for (int i = 0; i < renting.length; i++) {
            // if member is currently already renting the movie then trow exception
            if (movieTitle.equals(renting[i])) {
                // throw exception
                throw new MovieAlreadyExistsException();
            }
            // find the index of the first empty slot in the renting array
            if (renting[i] == null) {
                // add movie title to array and end method
                renting[i] = movieTitle;
                return;
            }
        }
    }

    /**
     * removes movie from the unsorted renting list
     * @param movieTitle
     * @throws MovieDoesNotExistException
     */
    public void Return(String movieTitle) throws MovieDoesNotExistException {
        // find movie title in renting array to return
        for (int i = 0; i < renting.length; i++) {
            // if the member is currently renting the movie they wish to return it can be returned
            if (movieTitle.equals(renting[i])) {
                // shift all movies in the array, in indexes higher the movie to be returned, 1 space left
                for (int j = i; j < renting.length - 1; j++) {
                    // shift movies to close the gap left by the entry been removed
                    renting[j] = renting[j+1];
                }
                // finally, ensure that the last array element is null
                renting[renting.length - 1] = null;
                return;
            }
        }
        // if the member is not currently renting the movie to be returned then throw exception
        throw new MovieDoesNotExistException();
    }

    /**
     * checks whether the member is currently renting a specific movie title
     * used only for test purposes
     * @param movieTitle
     * @return true if member is currently renting the movie title else false
     */
    boolean Renting(String movieTitle) {
        // iterate through renting array to check for the movie title
        for (int i = 0; i < renting.length; i++) {
            // if the movie title exists in the array then return true
            if (movieTitle.equals(renting[i])) {
                return true;
            }
        }
        // if the movie title does not exist in the array then return false
        return false;
    }

    /**
     * print a list of the movies that are currently being rented by the member
     */
    public void showRenting() {
        // iterate through the renting array
        for (int i = 0; i < renting.length; i++) {
            // print all entries that are not null
            if (renting[i] != null) {
                System.out.println(renting[i]);
            }
            // when a null entry is found then return from method
            else {
                return;
            }
        }
    }
}
