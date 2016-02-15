package andela.checkpoint1.main;

/**
 * Created by suadahaji.
 */
public class Book {

    private String isbnNumber;
    private String bookTitle;
    private String authorName;
    private int numberOfCopies;

    public Book() {}

    public Book(String isbnNumber, String bookTitle, String authorName, int numberOfCopies) {

        setBookTitle(bookTitle);
        setAuthorName(authorName);
        setIsbnNumber(isbnNumber);
        setNumberOfCopies(numberOfCopies);
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNumberOfCopies() {
        return numberOfCopies;
    }

    public void setNumberOfCopies(int numberOfCopies) {
        this.numberOfCopies = numberOfCopies;
    }

    public void increaseNumberOfCopies() {
        this.setNumberOfCopies(numberOfCopies + 1);
    }

    public void reduceNumberOfCopies() {
        this.setNumberOfCopies(numberOfCopies - 1);
    }

    public void increaseBookNumberByCopies(int numberOfCopies) {

        this.setNumberOfCopies(numberOfCopies + this.getNumberOfCopies());

    }
}
