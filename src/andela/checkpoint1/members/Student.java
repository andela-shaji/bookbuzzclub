package andela.checkpoint1.members;

import andela.checkpoint1.main.*;


/**
 * Created by suadahaji.
 */
public class Student extends Member {

    private int studentRegNumber;
    private String courseName;

    public Student() {}

    public Student(String firstName, String lastName, String email, int studentRegNumber, String courseName) {
        super(firstName, lastName, email);
        setStudentRegNumber(studentRegNumber);
        setCourseName(courseName);
    }

    /**
     * Creates setters and getters for student registration number
     */

    public void setStudentRegNumber(int studentRegNumber) {
        this.studentRegNumber = studentRegNumber;
    }

    public int getStudentRegNumber() {
        return studentRegNumber;
    }

    /**
     * Creates setters and getters for student course name
     */

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }
}
