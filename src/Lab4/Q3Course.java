package Lab4;

public class Q3Course {

    private String code;
    private String name;
    private int credit;
    private char grade;

    public Q3Course(String code, String name, int credit, char grade) {
        this.code = code;
        this.name = name;
        this.credit = credit;
        this.grade = grade;
    }

    public int getCredit() {
        return credit;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return String.format("Course : %s (%s) - %d credit hours"
                + ". Grade : %c", code,name,credit,grade);
    }
    
}
