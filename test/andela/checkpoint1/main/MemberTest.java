package andela.checkpoint1.main;

import org.junit.*;
import static org.junit.Assert.*;
import andela.checkpoint1.members.*;


/**
 * Created by suadahaji.
 */

public class MemberTest {
    Member eston;
    Member penny;
    Member semiu;
    Member edwin;
    Student vundi;
    Member.CompareMembers compareMembers;

    @Before
    public void setUp() throws Exception {
        vundi = new Student();
        compareMembers = new Member().new CompareMembers();
        eston = new Staff();
        edwin = new Staff();
        penny = new Staff("Penmy", "Brown", "penny@andela.com","QS345", 60000.00);
        semiu = new Student("Semiu", "Hassan", "semiu@gmail.com", 1234, "Information Technology");
    }

    // Test if student is an instance of Member Class
    @Test
    public void testStudentInstance() {
        assertTrue(vundi instanceof Member);
    }

    // Test if student is an instance of Student Class
    @Test
    public void testStudentInstance2() {
        assertTrue(vundi instanceof Student);
    }


    @Test
    public void testGetFirstName() throws Exception {
        penny.setFirstName("Suzzane");
        assertEquals(penny.getFirstName(), "Suzzane");
    }

    @Test
    public void testGetEmail() throws Exception {
        eston.setEmail("susan@gmail.com");
        assertEquals(eston.getEmail(), "susan@gmail.com");
    }

    @Test
    public void testToCompareMembersOnRegistrationDate() throws Exception {
        try {
            Member jee = new Staff();
            Thread.sleep(500);
            Member tosin = new Staff();
            Member wale = new Staff();
            Member.CompareMembers compareMembers1= new Member().new CompareMembers();

            // Test that returns -1 if the first member was registered before the second member
            assertEquals(compareMembers1.compare(jee, tosin), -1);
            // Test that returns -1 if the first member was registered after the second member
            assertEquals(compareMembers1.compare(tosin, jee), 1);
            // Test that returns 0 if both members were registered on the same date
            assertEquals(compareMembers1.compare(tosin, wale), 0);
        } catch (Exception e) {
            //re-interrupt the current thread
            Thread.currentThread().interrupt();
        }
    }

    @Test
    public void testToCompareMembersOnRanks() throws Exception {
        // Test that returns -1 the first member is a staff and the second a  student
        assertEquals(compareMembers.compare(eston, semiu), -1);

        // Test that returns -1 the first member is a student and the second a  staff
        assertEquals(compareMembers.compare(semiu, penny), 1);
    }
}