package chap1;

public class Person {
    private String typeOfPerson;
    protected String fullname;

    public Person(String typeOfPerson) {
        this.typeOfPerson = typeOfPerson;
    }

    public String getTypeOfPerson() {
        return typeOfPerson;
    }

    public void setTypeOfPerson(String typeOfPerson) {
        this.typeOfPerson = typeOfPerson;
    }

    public String toString() {
        return typeOfPerson + " : ";
    }
    
    
}
