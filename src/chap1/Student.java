package chap1;

public class Student {
    private String fullname, matric;

    public Student() {
        fullname = "";
        matric = "";
    }

    public Student(String fullname, String matric) {
        this.fullname = fullname;
        this.matric = matric;
    }

    public String getFullname() {
        return fullname;
    }

    public String getMatric() {
        return matric;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setMatric(String matric) {
        this.matric = matric;
    }

    public String toString() {
        return "Student : " + fullname + " (" + matric + ")";
    }
}
