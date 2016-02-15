package andela.checkpoint1.members;

import andela.checkpoint1.main.*;

/**
 * Created by suadahaji.
 */

public class Staff extends Member {

    private String staffId;
    private Double salary;

    public Staff(){}

    public Staff(String firstName, String lastName, String email, String staffId, Double salary){
        super(firstName, lastName, email);
        setStaffId(staffId);
        setSalary(salary);
    }

    /**
     * Creates setters and getters for staff ID
     */

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getStaffId() {
        return staffId;
    }

    /**
     * Creates setters and getters for staff salary
     */

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Double getSalary() {
        return salary;
    }
}
