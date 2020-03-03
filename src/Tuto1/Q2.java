package Tuto1;

public class Q2 {
    public static void displayDetails(String sen){
        System.out.println("The sentence is : " + sen);
        System.out.println("The length of the sentence : "+ sen.length());
        int numOfVowel = 0;
        for (int i = 0; i < sen.length(); i++) {
            char cha = sen.charAt(i);
            cha = Character.toLowerCase(cha);
            if(cha=='a'||cha=='e'||cha=='i'||cha=='o'||cha=='u'){
                numOfVowel++;
            }
        }
        System.out.println("The number of vowels : " + numOfVowel);
        System.out.println("The number of words : " +sen.split(" ").length);
    }
    public static void main(String[] args) {
        displayDetails("How are you?");
    }
}
