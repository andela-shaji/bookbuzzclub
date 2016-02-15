package andela.checkpoint1.manager;

import java.util.ArrayList;
import java.util.HashMap;
import andela.checkpoint1.main.*;

/**
 * Created by suadahaji.
 */
public class BookBuzzClub {
    ArrayList<Book> booklist;
    ArrayList<Member> memberList;
    HashMap<String, MemberBookQueue> booksBorrowed;

    public BookBuzzClub() {
        booklist = new ArrayList<Book>();
        memberList = new ArrayList<Member>();
        booksBorrowed = new HashMap<String, MemberBookQueue>();
    }

    public int getTotalBooks() {
        return booklist.size();
    }

    public int getTotalMembers() {
        return memberList.size();
    }

    public int getTotalBooksBorrowed() {
        return booksBorrowed.size();
    }

    /**
     * Return a list of books in the club.
     */
    public ArrayList<Book> getBooklist() {
        return this.booklist;
    }

    /**
     * Returns a list of members in the club.
     */

    public ArrayList<Member> getMemberList() {
        return this.memberList;
    }

    public void addBookToClub(Book addBook) {
        for (Book book: this.booklist) {
            if (book == addBook) {
                book.increaseBookNumberByCopies(addBook.getNumberOfCopies());
                return;
            }
        }
        booklist.add(addBook);
    }

    public void addMemberToClub(Member addMember) {
        if(!isAMember(addMember)) {
            memberList.add(addMember);
        }
    }

    /**
     * Borrower requesting book from club.
     */

    public void recieveBookRequest(Book requestedBook, Member requestingMember) {
        if (isAMember(requestingMember) && checkBookAvailability(requestedBook)) {

            addMemberToQueue(requestedBook, requestingMember);
            grantBookToMember(requestedBook);
        }
    }


    public void addMemberToQueue(Book requestedBook, Member requestingMember) {
        String bookTitle = requestedBook.getBookTitle();
        if (booksBorrowed.containsKey(bookTitle)) {
            MemberBookQueue queue =getRequestQueue(bookTitle);
            queue.addMemberToQueue(requestingMember);
        } else {
            MemberBookQueue queueBook = new MemberBookQueue();
            queueBook.addMemberToQueue(requestingMember);
            booksBorrowed.put(bookTitle, queueBook);
        }
    }

    /**
     * Grant book to borrower and determine who's the borrower
     */

    public void grantBookToMember(Book requestedBook) {
        MemberBookQueue queue = getRequestQueue(requestedBook.getBookTitle());
        while (requestedBook.getNumberOfCopies() > 0 && !(queue.isEmpty())) {
            requestedBook.reduceNumberOfCopies();
            queue.returnMemberGrantedBook();
        }
    }

    public MemberBookQueue getRequestQueue(String bookTitle) {
        return booksBorrowed.get(bookTitle);
    }

    public boolean isAMember(Member member) {
        return memberList.contains(member);
    }

    /**
     * Checks if book is available for borrowing.
     */

    public boolean checkBookAvailability(Book requestedBook) {
        return booklist.contains(requestedBook);
    }
}