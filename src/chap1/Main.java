package chap1;

public class Main {

    public static void main(String[] args) {
        //Example 1
        /*
        // object without argument
        Student a = new Student();
        a.setFullname("Ahmad");
        a.setMatric("WEK111");
        System.out.println(a.toString());

        // object without argument
        Student b = new Student("Siti", "WEK222");
        System.out.println(b.toString());

        System.out.println("List of students matric number");
        System.out.println("1. " + a.getMatric());
        System.out.println("2. " + b.getMatric());
        */
        
        //Example 2
        /*
        String[] name = {"Ahmad", "Siti", "Thomas"};
        String[] matric = {"WEK111", "WEK222", "WEK333"};
        
        // array of object
        Student[] a = new Student[3];
        for(int i=0; i<a.length; i++) 
            a[i] = new Student(name[i], matric[i]);

        System.out.println("List of students: ");
        for(int i=0; i<a.length; i++)
            System.out.println(a[i].toString()); 

        System.out.println("List of students matric number");
        for(int i=0; i<a.length; i++)
            System.out.println(i+1 + ". " + a[i].getMatric());     
        */
        
        //Example 3
        /*
        Teacher a = new Teacher("Hafiz", "S002");
        Student1 b = new Student1("Ahmad", "WEK111");
        System.out.println(a.toString()); 
        System.out.println(b.toString()); 
        System.out.println("They are " + b.getTypeOfPerson() + " and " + a.getTypeOfPerson()); 
        */
        
        //Example 4
        /*
        Teacher a = new Teacher("Hafiz", "S002");
        Student1 b = new Student1("Ahmad", "WEK111");
        display(a);
        display(b);        
        System.out.println("They are " + getType(b) + " and " + getType(a));         
        */
        
        //Example 5
        /*
        double sales = 340.2;
        WeekDayDiscount a = new WeekDayDiscount(sales);
        FirstDayOfMonthDiscount b = new FirstDayOfMonthDiscount(sales);
        System.out.println("Original Price : " + sales); 
        display(a);
        display(b);  
        */
        
        //Example 6
        /*
        double sales = 310, pay = 400;
        WeekEndDiscount a = new WeekEndDiscount(sales, pay);
        FirstDayOfYear b = new FirstDayOfYear(sales, pay);
        System.out.println("Original Price : " + sales); 
        System.out.println(a.toString()); 
        System.out.println(b.toString()); 
        */
        //Example 7
        /*
        Desk a = new Desk();
        Desk b = new Desk();
        System.out.println("The number of desk created is " + Desk.getCount());
        */
    }
    
    public static void display(Discount p) {
        System.out.println(p.toString()); 
    }
    
    public static void display(Person p) {
        System.out.println(p.toString()); 
    }
    
    public static String getType(Person p) {
        return p.getTypeOfPerson();
    }
    
}
