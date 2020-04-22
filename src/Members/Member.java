package Members;

import CustomExceptions.RentalsOutOfBoundsException;
import Movies.Movie;
import java.util.ArrayList;

public class Member {

    private String first_name;
    private String last_name;
    private String address;
    private String number;
    private int password;
    private ArrayList<Movie> renting;

    /**
     * Constructor
     * @param full_name members full name
     * @param address members residential address
     * @param number members contact phone number
     */
    public Member(String full_name, String address, String number) {
        this.first_name = full_name;

        this.address = address;
        this.number = number;
        this.renting = new ArrayList<Movie>();
    }

    /**
     * gets the first name of the member
     * @return first name as string
     */
    public String getFirst_name() {
        return first_name;
    }

    /**
     * sets the first name of the member
     * @param first_name as string
     */
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    /**
     * gets the last name of the member
     * @return last name as string
     */
    public String getLast_name() {
        return last_name;
    }

    /**
     * sets the last name of the member
     * @param last_name as string
     */
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    /**
     * gets the residential address of the member
     * @return residential address as string
     */
    public String getAddress() {
        return address;
    }

    /**
     * sets the residential address of the member
     * @param address as string
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * gets the contact phone number of the member
     * @return phone number as string
     */
    public String getNumber() {
        return number;
    }

    /**
     * sets the contact phone number of the member
     * @param number as string
     */
    public void setNumber(String number) {
        this.number = number;
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
    public void setPassword(int password) {
        this.password = password;
    }

    /**
     * adds movie to the renting list
     * @param movie
     * @throws RentalsOutOfBoundsException throws exception if the list contains more than 10 movies
     */
    public void Rent(Movie movie) throws RentalsOutOfBoundsException {
        if (renting.size() > 10) {
            throw new RentalsOutOfBoundsException("Members can not rent more than 10 DVDs at a time");
        }
        else {
            this.renting.add(movie);
        }
    }

    /**
     * removes movie from renting list
     * @param movie
     */
    public void Return(String movie) {
        this.renting.remove(movie);
    }

    /**
     * get the list of movies that are being rented by the member
     * @return
     */
    public ArrayList<Movie> getRenting() {
        return renting;
    }

    /**
     * set the list of movies that are being rented by the member
     * @param renting array list of movies that are being rented
     * @throws RentalsOutOfBoundsException throws exception if the list contains more than 10 movies
     */
    public void setRenting(ArrayList<Movie> renting) throws RentalsOutOfBoundsException {
        if (renting.size() > 10) {
            throw new RentalsOutOfBoundsException("Members can not rent more than 10 DVDs at a time");
        }
        else {
            this.renting = renting;
        }
    }
}
