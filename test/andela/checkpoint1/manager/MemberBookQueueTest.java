package andela.checkpoint1.manager;

import org.junit.*;
import static org.junit.Assert.*;
import andela.checkpoint1.members.*;
import andela.checkpoint1.main.*;

/**
 * Created by suadahaji.
 */

public class MemberBookQueueTest {
    MemberBookQueue memberBookQueue;
    Staff suada;
    Staff penny;
    Member semiu;
    Book harryPotter;
    Book whatSheLeft;


    @Before
    public void setUp() throws Exception {
        memberBookQueue = new MemberBookQueue();
        suada = new Staff("Suada", "Haji", "suada@abc.com","AS123", 50000.00);
        penny = new Staff("Penny", "Brown", "penny@andela.com","QS345", 60000.00);
        semiu = new Student("Semiu", "Hassan", "semiu@gmail.com", 1234, "Information Technology");
        harryPotter = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", "0-7475-3269-9", 1);
        whatSheLeft = new Book("What She Left", "T. R. Richmond", "978-1476773841", 2);
    }

    @Test
    public void testAddMemberToQueue() throws Exception {
        assertEquals(memberBookQueue.getSizeOfQueue(), 0);
        memberBookQueue.addMemberToQueue(suada);
        memberBookQueue.addMemberToQueue(semiu);
        assertEquals(memberBookQueue.getSizeOfQueue(), 2);
    }

    @Test
    public void testReturnMemberGrantedBook() throws Exception {
        assertEquals(memberBookQueue.getSizeOfQueue(), 0);
        memberBookQueue.addMemberToQueue(suada);
        assertEquals(memberBookQueue.getSizeOfQueue(), 1);
        memberBookQueue.returnMemberGrantedBook();
        assertEquals(memberBookQueue.getSizeOfQueue(), 0);
    }

    @Test
    public void testIsEmpty() throws Exception {
        assertEquals(memberBookQueue.getSizeOfQueue(), 0);
        assertTrue(memberBookQueue.isEmpty());

        memberBookQueue.addMemberToQueue(suada);
        assertEquals(memberBookQueue.getSizeOfQueue(), 1);

        assertFalse(memberBookQueue.isEmpty());
    }

    @Test
    public void testContainsBorrower() throws Exception {
        memberBookQueue.addMemberToQueue(suada);
        assertTrue(memberBookQueue.containsBorrower(suada));
        assertFalse(memberBookQueue.containsBorrower(semiu));
    }

    @Test
    public void testGetSizeOfQueue() throws Exception {
        assertEquals(memberBookQueue.getSizeOfQueue(), 0);
        memberBookQueue.addMemberToQueue(penny);
        assertEquals(memberBookQueue.getSizeOfQueue(), 1);
    }

    @Test
    public void testGetRequestQueue() throws Exception {
        assertEquals(memberBookQueue.getSizeOfQueue(),0);
        memberBookQueue.addMemberToQueue(suada);
        memberBookQueue.addMemberToQueue(semiu);
        assertEquals(memberBookQueue.getSizeOfQueue(),2);

    }
}