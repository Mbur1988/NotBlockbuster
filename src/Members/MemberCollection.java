package Members;

import CustomExceptions.MemberAlreadyExistsException;
import CustomExceptions.MemberDoesNotExistException;
import CustomExceptions.MembersOutOfBoundsException;

public class MemberCollection {

    static final int MAX_MEMBERS = 10;

    public static Member[] members; // kept sorted
    static int memberCount;

    /**
     * Constructor
     */
    public MemberCollection() {
        this.members = new Member[MAX_MEMBERS];
        this.memberCount = 0;
    }

    /**
     * Add a new member into the correct position of the sorted members array
     * @param member the new member to be inserted
     * @throws MemberAlreadyExistsException
     * @throws MembersOutOfBoundsException
     */
    public void add(Member member) throws MemberAlreadyExistsException, MembersOutOfBoundsException {
        // if the last array element is not null then the array is already full
        if (memberCount == MAX_MEMBERS) {
            // throw members out of bounds exception
            throw new MembersOutOfBoundsException();
        }
        // if there is space in the array
        else {
            // increment through each array element until either of the if statements are met
            for (int i = 0; i < memberCount; i++) {
                // if the member name already exists then duplicate member can not be added
                if (member.getFull_name().equals(members[i].getFull_name())) {
                    // throw new member already exists exception
                    throw new MemberAlreadyExistsException();
                }
                // if the current array position member is greater than the new member then insert here
                if (members[i].getFull_name().compareTo(member.getFull_name()) > 0) {
                    // first shift all elements greater than and including i one position to the right
                    for (int j = memberCount; j > i; j--) {
                        // shift element one position right
                        members[j] = members[j - 1];
                    }
                    // once elements greater than member shifted, insert new member at i
                    members[i] = member;
                    memberCount++;
                    // end method
                    return;
                }
            }
            // if this code is reached then the new member is greater then all current members and inserts at the end
            members[memberCount] = member;
            memberCount++;
        }
    }

    /**
     * Removes a current member from the sorted members array using binary search
     * Not currently used in the program other then for testing purposes
     * @param member full name of the member to be deleted
     */
    void remove(String member) throws MemberDoesNotExistException {
        // find the index of the member to be removed
        int index = search(member);
        // if the member does not exist in the members array then throw exception
        if (index == -1) {
            throw new MemberDoesNotExistException();
        }
        // shift all members in higher indexes 1 position to the left to close the gap left by the deleted entry
        for (int i = index; i < memberCount - 1; i++) {
            members[i] = members[i + 1];
        }
        // set the last populated index to null
        members[memberCount - 1] = null;
        // update members count to account for the deleted member
        memberCount--;
    }

    /**
     * returns the index of the specified member if it exists else -1
     * @param full_name the name of the member to search for
     * @return the index of the element as a integer else -1
     */
    public int search(String full_name) {
        // set lower search index to be the starting index of the array
        int lower = 0;
        // set upper search index to be the last populated index of the array
        int upper = memberCount - 1;
        // initiate current search index
        int mid = (lower + upper) / 2;
        // loop until the search is exhausted
        while (lower <= upper) {
            // if the member is found then return the index
            if (full_name.equals(members[mid].getFull_name())) {
                // return index
                return mid;
            }
            // if the member is less than the member at current index then continue search on the left side
            else if (full_name.compareTo(members[mid].getFull_name()) < 0) {
                // set high upper index to current index -1
                upper = mid - 1;
            }
            // if the member is greater than the member at current index then continue search on the right side
            else {
                // set lower index to current index +1
                lower = mid + 1;
            }
            // update current search index
            mid = (lower + upper) / 2;
        }
        // if the member does not exist in the members array then throw member does not exist exception
        return -1;
    }
}