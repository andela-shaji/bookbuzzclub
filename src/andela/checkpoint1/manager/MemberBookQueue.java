package andela.checkpoint1.manager;

import java.util.PriorityQueue;
import andela.checkpoint1.main.Member;

/**
 * Created by suadahaji.
 */
public class MemberBookQueue {
    private PriorityQueue<Member> queue;

    Member.CompareMembers compareMembers = new Member().new CompareMembers();

    public MemberBookQueue() {
        queue = new PriorityQueue<>(10, compareMembers);
    }

    /**
     * Add requesting member to the Queue.
     */

    public void addMemberToQueue(Member member) {
        queue.add(member);
    }

    /**
     * Remove requesting member from the queue after granted the book.
     */

    public Member returnMemberGrantedBook() {
        return queue.remove();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public boolean containsBorrower(Member member) {
        return queue.contains(member);
    }

    public int getSizeOfQueue( ){
        return queue.size();
    }

    public PriorityQueue<Member> getRequestQueue() {
        return queue;
    }
}
