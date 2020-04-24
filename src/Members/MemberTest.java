package Members;

import CustomExceptions.MovieAlreadyExistsException;
import CustomExceptions.MovieDoesNotExistException;
import CustomExceptions.PasswordOutOfBoundsException;
import CustomExceptions.RentalsOutOfBoundsException;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {

    Member member;

    @BeforeEach
    void setUp() throws PasswordOutOfBoundsException {
        member = new Member("test", "test", "test", "1234");
    }

    @Test
    void passwordSet() {
        assertEquals(member.getPassword(), 1234);
    }

    @Test
    void passwordNumberFormat() {
        assertThrows(NumberFormatException.class, () ->
                member.setPassword("test"));
    }

    @Test
    void passwordOutOfBoundsMax() {
        assertThrows(PasswordOutOfBoundsException.class, () ->
                member.setPassword("00000"));
    }

    @Test
    void passwordOutOfBoundsMin() {
        assertThrows(PasswordOutOfBoundsException.class, () ->
                member.setPassword("000"));
    }

    @Test
    void rent() throws MovieAlreadyExistsException, RentalsOutOfBoundsException {
        member.Rent("test");
        assertEquals(member.renting[0], "test");
    }

    @Test
    void rentMax() throws MovieAlreadyExistsException, RentalsOutOfBoundsException {
        for (int i = 0; i < member.renting.length; i++) {
            member.Rent("test" + i);
        }
        assertNotEquals(member.renting[member.renting.length - 1], null);
    }

    @Test
    void rentOutOfBounds() throws MovieAlreadyExistsException, RentalsOutOfBoundsException {
        for (int i = 0; i < member.renting.length; i++) {
            member.Rent("test" + i);
        }
        assertThrows(RentalsOutOfBoundsException.class, () ->
                member.Rent("test"));
    }

    @Test
    void rentAlreadyExists() throws MovieAlreadyExistsException, RentalsOutOfBoundsException {
        member.Rent("test");
        assertThrows(MovieAlreadyExistsException.class, () ->
                member.Rent("test"));
    }

    @Test
    void return1() throws RentalsOutOfBoundsException, MovieAlreadyExistsException, MovieDoesNotExistException {
        member.Rent("test");
        member.Return("test");
        assertEquals(member.renting[0], null);
    }

    @Test
    void returnMax() throws RentalsOutOfBoundsException, MovieAlreadyExistsException, MovieDoesNotExistException {
        for (int i = 0; i < member.renting.length; i++) {
            member.Rent("test" + i);
        }
        member.Return("test" + (member.renting.length - 1));
        assertEquals(member.renting[member.renting.length - 1], null);
    }

    @Test
    void returnMany() throws RentalsOutOfBoundsException, MovieAlreadyExistsException, MovieDoesNotExistException {
        for (int i = 0; i < member.renting.length; i++) {
            member.Rent("test" + i);
        }
        for (int i = 0; i < member.renting.length; i++) {
            member.Return("test" + i);
        }
        assertEquals(member.renting[0], null);
    }

    @Test
    void returnNotExist1() {
        assertThrows(MovieDoesNotExistException.class, () ->
                member.Return("test"));
    }

    @Test
    void returnNotExist2() throws RentalsOutOfBoundsException, MovieAlreadyExistsException {
        member.Rent("test");
        assertThrows(MovieDoesNotExistException.class, () ->
                member.Return("test1"));
    }

    @Test
    void renting() throws RentalsOutOfBoundsException, MovieAlreadyExistsException {
        member.Rent("test");
        assertEquals(member.Renting("test"), true);
    }

    @Test
    void notRenting() throws RentalsOutOfBoundsException, MovieAlreadyExistsException {
        assertEquals(member.Renting("test"), false);
    }
}