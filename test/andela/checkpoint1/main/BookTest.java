package andela.checkpoint1.main;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by suadahaji.
 */

public class BookTest {
    Book harryPotter = new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", "0-7475-3269-9", 2);

    @Test
    public void testSetNumberOfCopies() throws Exception {

        harryPotter.setNumberOfCopies(10);

        assertEquals(harryPotter.getNumberOfCopies() == 10, true);
    }

    @Test
    public void testIncreaseNumberOfCopies() throws Exception {

        harryPotter.increaseNumberOfCopies();

        assertTrue(harryPotter.getNumberOfCopies() == 3);
    }

    @Test
    public void testReduceNumberOfCopies() throws Exception {
        harryPotter.reduceNumberOfCopies();

        assertTrue(harryPotter.getNumberOfCopies() == 1);
    }
}