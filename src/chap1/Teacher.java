package chap1;

public class Teacher extends Person {
    private String staffID;

    public Teacher(String fullname, String staffID) {
        super("Teacher");
        this.fullname = fullname;
        this.staffID = staffID;
    }
         
    public String getFullname() {
        return fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public String getStaffID() {
        return staffID;
    }

    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public String toString() {
        return super.toString() + fullname + " (" + staffID + ")";
    }
    
}
