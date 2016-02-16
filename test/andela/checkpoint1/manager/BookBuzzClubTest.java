package andela.checkpoint1.manager;

import org.junit.*;
import static org.junit.Assert.*;
import andela.checkpoint1.main.*;
import andela.checkpoint1.members.*;

/**
 * Created by suadahaji.
 */

public class BookBuzzClubTest {
    BookBuzzClub bookBuzzClub;
    Member suada;
    Member penny;
    Member semiu;
    Book harryPotter;
    Book whatSheLeft;

    @Before
    public void setUp() throws Exception {
        bookBuzzClub = new BookBuzzClub();
        suada = new Staff("Suada", "Haji", "suada@abc.com","AS123", 50000.00);
        penny = new Staff("Penny", "Brown", "penny@andela.com","QS345", 60000.00);
        semiu = new Student("Semiu", "Hassan", "semiu@gmail.com", 1234, "Information Technology");
        harryPotter = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", "0-7475-3269-9", 1);
        whatSheLeft = new Book("What She Left", "T. R. Richmond", "978-1476773841", 3);
    }

    @Test
    public void testGetTotalBooks() throws Exception {

        assertEquals(bookBuzzClub.getTotalBooks(), 0);
    }

    @Test
    public void testGetTotalMembers() throws Exception {
        assertEquals(bookBuzzClub.getTotalMembers(), 0);
    }

    @Test
    public void testGetTotalBooksBorrowed() throws Exception {
        assertEquals(bookBuzzClub.getTotalBooksBorrowed(), 0);
    }

    @Test
    public void testGetBookList() throws Exception {
        assertEquals(bookBuzzClub.getTotalBooks(), 0);
        bookBuzzClub.addBookToClub(harryPotter);
        bookBuzzClub.addBookToClub(whatSheLeft);
        assertEquals(bookBuzzClub.getTotalBooks(), 2);
        assertEquals(bookBuzzClub.getBookPosition(harryPotter), 0);
        assertEquals(bookBuzzClub.getBookPosition(whatSheLeft), 1);
    }

    @Test
    public void testAddBookToClub() throws Exception {
        assertEquals(bookBuzzClub.getTotalBooks(), 0);
        bookBuzzClub.addBookToClub(harryPotter);
        assertEquals(bookBuzzClub.getTotalBooks(), 1);
    }

    /**
     * The addBookToClub2() method should not increase the size of booklist
     * but instead increase the number of copies
     */

    @Test
    public void testAddBookToClub2() throws Exception {
        bookBuzzClub.addBookToClub(harryPotter);
        bookBuzzClub.addBookToClub(harryPotter);
        assertEquals(bookBuzzClub.getTotalBooks(), 1);
        assertEquals(harryPotter.getNumberOfCopies(), 2);
    }

    @Test
    public void testAddMemberToClub() throws Exception {
        bookBuzzClub.addMemberToClub(suada);
        assertEquals(bookBuzzClub.getTotalMembers(), 1);
        bookBuzzClub.addMemberToClub(penny);
        bookBuzzClub.addMemberToClub(semiu);
        assertEquals(bookBuzzClub.getTotalMembers(), 3);
    }

    /**
     * When a borrower request for a book, they should be placed in the queue.
     * If the borrower is not a member, they should not be placed on the queue
     */

    @Test
    public void testReceiveBookRequest() throws Exception {
        assertEquals(bookBuzzClub.getTotalBooksBorrowed(),0);
        bookBuzzClub.addBookToClub(harryPotter);
        bookBuzzClub.receiveBookRequest(harryPotter, suada);
        assertTrue(bookBuzzClub.checkBookAvailability(harryPotter));
        assertFalse(bookBuzzClub.isAMember(suada));
        assertEquals(bookBuzzClub.getTotalBooksBorrowed(), 0);

        bookBuzzClub.addMemberToClub(suada);
        bookBuzzClub.addBookToClub(harryPotter);
        bookBuzzClub.receiveBookRequest(harryPotter, suada);
        assertTrue(bookBuzzClub.checkBookAvailability(harryPotter));
        assertTrue(bookBuzzClub.isAMember(suada));
        assertEquals(bookBuzzClub.getTotalBooksBorrowed(), 1);
    }

    /** When a borrower request for a book, they should be not be placed in the queue
     * if the book hasn't been borrowed
     */

    @Test
    public void testReceiveBookRequest2() throws Exception {
        assertEquals(bookBuzzClub.getTotalBooksBorrowed(),0);
        bookBuzzClub.addMemberToClub(suada);
        bookBuzzClub.addBookToClub(whatSheLeft);
        assertEquals(whatSheLeft.getNumberOfCopies(), 3);
        bookBuzzClub.receiveBookRequest(whatSheLeft, suada);
        assertEquals(bookBuzzClub.getTotalBooksBorrowed(), 1);
    }

    @Test
    public void testAddMemberToQueue() throws Exception {
        assertEquals(bookBuzzClub.getTotalBooksBorrowed(), 0);
        bookBuzzClub.addMemberToQueue(harryPotter, suada);
        assertTrue(bookBuzzClub.isRequestedBookInQueue(harryPotter));
        assertEquals(bookBuzzClub.getTotalBooksBorrowed(), 1);
    }

    @Test
    public void testGrantBookToMember() throws Exception {
        bookBuzzClub.addMemberToClub(suada);
        bookBuzzClub.addMemberToClub(penny);
        bookBuzzClub.addMemberToClub(semiu);
        bookBuzzClub.addBookToClub(harryPotter);
        assertEquals(harryPotter.getNumberOfCopies(), 1);

        bookBuzzClub.receiveBookRequest(harryPotter, suada);
        bookBuzzClub.receiveBookRequest(harryPotter, penny);
        bookBuzzClub.receiveBookRequest(harryPotter, semiu);

        bookBuzzClub.grantBookToMember(harryPotter);

        MemberBookQueue bookQueue = bookBuzzClub.getRequestQueue(harryPotter.getBookTitle());
        assertEquals(bookQueue.getSizeOfQueue(), 2);
    }

    @Test
    public void testGetRequestQueue() throws Exception {
        bookBuzzClub.addMemberToClub(suada);
        bookBuzzClub.addMemberToClub(penny);

        bookBuzzClub.addBookToClub(harryPotter);
        bookBuzzClub.addBookToClub(whatSheLeft);

        bookBuzzClub.receiveBookRequest(harryPotter, suada);
        bookBuzzClub.receiveBookRequest(whatSheLeft, penny);

        MemberBookQueue bookAQueue = bookBuzzClub.getRequestQueue(harryPotter.getBookTitle());
        MemberBookQueue bookBQueue = bookBuzzClub.getRequestQueue(whatSheLeft.getBookTitle());

        assertEquals(bookAQueue, bookBuzzClub.getRequestQueue(harryPotter.getBookTitle()));
        assertTrue(bookBQueue != bookAQueue);
    }

    @Test
    public void testIsAMember() throws Exception {
        assertFalse(bookBuzzClub.isAMember(semiu));
        bookBuzzClub.addMemberToClub(semiu);
        assertTrue(bookBuzzClub.isAMember(semiu));
    }

    @Test
    public void testCheckBookAvailability() throws Exception {
        assertFalse(bookBuzzClub.checkBookAvailability(harryPotter));
        bookBuzzClub.addBookToClub(harryPotter);
        assertTrue(bookBuzzClub.checkBookAvailability(harryPotter));
    }
}

