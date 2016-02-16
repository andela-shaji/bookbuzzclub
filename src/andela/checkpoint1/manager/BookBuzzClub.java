package andela.checkpoint1.manager;

import java.util.*;
import andela.checkpoint1.main.*;

/**
 * Created by suadahaji.
 */

public class BookBuzzClub {
   private ArrayList<Book> booklist;
   private ArrayList<Member> memberList;
   private HashMap<String, MemberBookQueue> booksBorrowed;

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

    public int getBookPosition(Book book) {
        return booklist.indexOf(book);
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

    public void addBookToClub(Book newBook) {
        for (Book book: this.booklist) {
            if (book == newBook) {
                book.increaseBookNumberByCopies(newBook.getNumberOfCopies());
                return;
            }
        }
        booklist.add(newBook);
    }

    public void addMemberToClub(Member newMember) {
        if(!isAMember(newMember)) {
            memberList.add(newMember);
        }
    }

    /**
     * Borrower requesting book from club.
     */

    public void receiveBookRequest(Book requestedBook, Member requestingMember) {
        if (isAMember(requestingMember) && checkBookAvailability(requestedBook)) {

            addMemberToQueue(requestedBook, requestingMember);
            grantBookToMember(requestedBook);
        }
    }


    public void addMemberToQueue(Book requestedBook, Member requestingMember) {
        String bookTitle = requestedBook.getBookTitle();
        if (isRequestedBookInQueue(requestedBook)) {
            MemberBookQueue queue = getRequestQueue(bookTitle);
            queue.addMemberToQueue(requestingMember);
        } else {
            MemberBookQueue queueBook = new MemberBookQueue();
            queueBook.addMemberToQueue(requestingMember);
            booksBorrowed.put(bookTitle, queueBook);
        }
    }

    /**
     * Grant book to borrower
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

    public boolean isRequestedBookInQueue(Book requestedBook) {
        return booksBorrowed.containsKey(requestedBook.getBookTitle());
    }
}