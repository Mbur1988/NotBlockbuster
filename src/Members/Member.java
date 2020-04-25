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
     *
     * @param full_name members full name
     * @param address   members residential address
     * @param number    members contact phone number
     * @param password  members password
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
     *
     * @return full name as string
     */
    public String getFull_name() {
        return full_name;
    }

    /**
     * sets the full name of the member
     *
     * @param full_name as string
     */
    public void setFirst_name(String full_name) {
        this.full_name = full_name;
    }

    /**
     * sets the full name of the member
     *
     * @param first_name as string
     * @param last_name  as string
     */
    public void setFirst_name(String first_name, String last_name) {
        this.full_name = last_name + first_name;
    }

    /**
     * gets the residential address of the member
     *
     * @return residential address as string
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets the residential address of the member
     *
     * @param address as string
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gets the contact phone number of the member
     *
     * @return phone number as string
     */
    public String getNumber() {
        return number;
    }

    /**
     * sets the contact phone number of the member
     *
     * @param number as string
     */
    public void setNumber(String number) {
        this.number = number;
    }

    /**
     * gets the password of the member
     *
     * @return password as integer
     */
    public int getPassword() {
        return password;
    }

    /**
     * sets the password of the member
     *
     * @param password as integer
     */
    public void setPassword(String password) throws PasswordOutOfBoundsException {
        if (password.length() != 4) {
            throw new PasswordOutOfBoundsException();
        }
        this.password = Integer.parseInt(password);
    }

    /**
     * adds movie to the unsorted renting list
     * @param movieTitle
     * @throws MovieAlreadyExistsException
     */
    public void Rent(String movieTitle) throws MovieAlreadyExistsException, RentalsOutOfBoundsException {
        if (renting[renting.length - 1] != null) {
            throw new RentalsOutOfBoundsException();
        }
        for (int i = 0; i < renting.length; i++) {
            if (movieTitle.equals(renting[i])) {
                throw new MovieAlreadyExistsException();
            }
            if (renting[i] == null) {
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
        for (int i = 0; i < renting.length; i++) {
            if (movieTitle.equals(renting[i])) {
                for (int j = i; j < renting.length - 1; j++) {
                    renting[j] = renting[j+1];
                }
                renting[renting.length - 1] = null;
                return;
            }
        }
        throw new MovieDoesNotExistException();
    }

    /**
     * checks whether the member is currently renting a specific movie title
     * @param movieTitle
     * @return true if member is currently renting the movie title else false
     */
    public boolean Renting(String movieTitle) {
        for (int i = 0; i < renting.length; i++) {
            if (movieTitle.equals(renting[i])) {
                return true;
            }
        }
        return false;
    }

    public void showRenting() {
        for (int i = 0; i < renting.length; i++) {
            if (renting[i] != null) {
                System.out.println(renting[i]);
            }
            else {
                return;
            }
        }
    }
}
