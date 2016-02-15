package andela.checkpoint1.main;

import java.util.Comparator;
import java.util.Date;
import andela.checkpoint1.members.*;
/**
 * Created by suadahaji.
 */
public class Member {

    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfMembership;

    public Member() {}

    public Member(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfMembership() {
        return dateOfMembership;
    }

    public void setDateOfMembership(Date dateOfMembership) {
        this.dateOfMembership = new Date();
    }

    public class CompareMembers implements Comparator<Member> {

        @Override
        public int compare(Member member1, Member member2) {

            if (member1.getClass() == member2.getClass()) {
                return member1.getDateOfMembership().compareTo(member2.getDateOfMembership());
            }
            if(member1 instanceof Staff && member2 instanceof Student) {
                return -1;
            }
            return 1;
        }
    }
}
