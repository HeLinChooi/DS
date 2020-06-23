
package chap1;

public class Student1 extends Person {
    private String matric;

    public Student1(String fullname, String matric) {
        super("Student");
        this.fullname = fullname;
        this.matric = matric;
    }

    public String getFullname() {
        return fullname;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public String getMatric() {
        return matric;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public String toString() {
        return super.toString() + fullname + " (" + matric + ")";
    }    
}
