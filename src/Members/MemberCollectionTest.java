package Members;

import CustomExceptions.MemberAlreadyExistsException;
import CustomExceptions.MemberDoesNotExistException;
import CustomExceptions.MembersOutOfBoundsException;
import CustomExceptions.PasswordOutOfBoundsException;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberCollectionTest {

    private static final int MAX_MEMBERS = MemberCollection.MAX_MEMBERS;

    MemberCollection memberCollection;

    @BeforeEach
    void setUp() {
        memberCollection = new MemberCollection();
    }

    @Test
    void add_1() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        memberCollection.add(new Member(
                "test",
                "test",
                "test",
                "0000"));
        assertEquals(MemberCollection.memberCount, 1);
    }

    @Test
    void addMax() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        for (int i = 0; i < MAX_MEMBERS; i++) {
            memberCollection.add(new Member(
                    "test" + i,
                    "test",
                    "test",
                    "0000"));
        }
        assertEquals(MemberCollection.memberCount, MAX_MEMBERS);
    }

    @Test
    void addExceedMax() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        for (int i = 0; i < MAX_MEMBERS; i++) {
            memberCollection.add(new Member(
                    "test" + i,
                    "test",
                    "test",
                    "0000"));
        }
        assertThrows(MembersOutOfBoundsException.class, () ->
                memberCollection.add(new Member(
                        "test" + MAX_MEMBERS,
                        "test",
                        "test",
                        "0000")));
    }

    @Test
    void addAlreadyExists() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        memberCollection.add(new Member(
                "test",
                "test",
                "test",
                "0000"));
        assertThrows(MemberAlreadyExistsException.class, () ->
                memberCollection.add(new Member(
                        "test",
                        "test",
                        "test",
                        "0000")));
    }

    @Test
    void addExceedOverAlreadyExists() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        for (int i = 0; i < MAX_MEMBERS; i++) {
            memberCollection.add(new Member(
                    "test" + i,
                    "test",
                    "test",
                    "0000"));
        }
        assertThrows(MembersOutOfBoundsException.class, () ->
                memberCollection.add(new Member(
                        "test0",
                        "test",
                        "test",
                        "0000")));
    }

    @Test
    void remove_1() throws MemberDoesNotExistException, MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        memberCollection.add(new Member(
                "test",
                "test",
                "test",
                "0000"));
        memberCollection.remove("test");
        assertEquals(MemberCollection.memberCount, 0);
    }

    @Test
    void removeLast() throws MemberDoesNotExistException, MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        for (int i = 0; i < MAX_MEMBERS; i++) {
            memberCollection.add(new Member(
                    "test" + i,
                    "test",
                    "test",
                    "0000"));
        }
        memberCollection.remove("test" + (MAX_MEMBERS - 1));
        assertEquals(MemberCollection.memberCount, MAX_MEMBERS - 1);
    }

    @Test
    void removeCheckLastNull() throws MemberDoesNotExistException, MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        for (int i = 0; i < MAX_MEMBERS; i++) {
            memberCollection.add(new Member(
                    "test" + i,
                    "test",
                    "test",
                    "0000"));
        }
        memberCollection.remove("test" + (MAX_MEMBERS - 1));
        assertEquals(MemberCollection.members[MemberCollection.memberCount], null);
    }

    @Test
    void removeException() {
        assertThrows(MemberDoesNotExistException.class, () ->
                memberCollection.remove("test"));
    }

    @Test
    void removeExceptionFromFull() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        for (int i = 0; i < MAX_MEMBERS; i++) {
            memberCollection.add(new Member(
                    "test" + i,
                    "test",
                    "test",
                    "0000"));
        }
        assertThrows(MemberDoesNotExistException.class, () ->
                memberCollection.remove("test"));
    }

    @Test
    void search_1() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        memberCollection.add(new Member(
                "test",
                "test",
                "test",
                "0000"));
        assertEquals(memberCollection.search("test"), 0);
    }

    @Test
    void searchLast() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        for (int i = 0; i < MAX_MEMBERS - 1; i++) {
            memberCollection.add(new Member(
                    "test" + i,
                    "test",
                    "test",
                    "0000"));
        }
        memberCollection.add(new Member(
                "test_",
                "test",
                "test",
                "0000"));

        assertEquals(memberCollection.search("test_"), MAX_MEMBERS - 1);
    }

    @Test
    void searchDoesntExist1() throws MembersOutOfBoundsException, MemberAlreadyExistsException {
        assertEquals(memberCollection.search("aaa"), -1);
    }

    @Test
    void searchDoesntExist2() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        memberCollection.add(new Member(
                "test",
                "test",
                "test",
                "0000"));
        assertEquals(memberCollection.search("aaa"), -1);
    }

    @Test
    void addOrder() throws MembersOutOfBoundsException, MemberAlreadyExistsException, PasswordOutOfBoundsException {
        for (int i = 3; i > 0; i--) {
            memberCollection.add(new Member(
                    "test" + i,
                    "test",
                    "test",
                    "0000"));
        }
        assertEquals(memberCollection.search("test1"), 0);
        assertEquals(memberCollection.search("test2"), 1);
        assertEquals(memberCollection.search("test3"), 2);
        assertEquals(MemberCollection.members[3], null);
    }
}