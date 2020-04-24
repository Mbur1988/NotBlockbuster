package Members;

import CustomExceptions.MemberAlreadyExistsException;
import CustomExceptions.MembersOutOfBoundsException;
import CustomExceptions.MovieAlreadyExistsException;

public class MemberCollection {

    public static Member[] members; // kept sorted

    /**
     * Constructor
     */
    public MemberCollection() {
        this.members = new Member[20];
    }

    /**
     * Add a new member into the correct position of the sorted members array
     * @param member the new member to be inserted
     * @throws MemberAlreadyExistsException
     * @throws MembersOutOfBoundsException
     */
    public void add(Member member) throws MemberAlreadyExistsException, MembersOutOfBoundsException {
        // if the last array element is not null then the array is already full
        if (members[members.length - 1] != null) {
            // throw members out of bounds exception
            throw new MembersOutOfBoundsException();
        }
        // if there is space in the array
        else {
            // increment through each array element until either of the if statements are met
            for (int i = 0; i < members.length; i++) {
                // if the member name already exists then duplicate member can not be added
                if (member.getFull_name().equals(members[i].getFull_name())) {
                    // throw new member already exists exception
                    throw new MemberAlreadyExistsException();
                }
                // if the current array position member is greater than the new member then insert here
                else if (members[i].getFull_name().compareTo(member.getFull_name()) > 0) {
                    // first shift all elements greater than and including i one position to the right
                    for (int j = members.length - 1; j > i; j--) {
                        // shift element one position right
                        members[j] = members[j - 1];
                    }
                    // once elements greater than member shifted, insert new member at i
                    members[i] = member;
                    // end method
                    return;
                }
                // if the current position is null then the new member can be inserted here
                else if (members[i] == null) {
                    // insert new member
                    members[i] = member;
                    // end method
                    return;
                }
            }
        }
    }

    /**
     * Removes a current member from the sorted members array using binary search
     * @param member the member to be deleted
     */
    public void remove(Member member) {

    }

    /**
     * returns the index of the specified member if it exists else -1
     * @param full_name the name of the member to search for
     * @return the index of the element as a integer else -1
     */
    public int search(String full_name) {

    }
}