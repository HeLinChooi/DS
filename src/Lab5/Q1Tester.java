package Lab5;

public class Q1Tester {

    public static void main(String[] args) {
        Q1Stack<String> candies = new Q1Stack<>();
        Q1Stack<String> tempCandies = new Q1Stack<>();
        candies.push("Orange");
        candies.push("Red");
        candies.push("Blue");
        candies.push("Orange");
        candies.push("Yellow");
        candies.push("Yellow");
        candies.push("Blue");
        System.out.println("The candies in the container:");
        candies.showStack();
        System.out.println("Ali takes all teh candies one by "
                + "one from the container and\n"
                + "eats the blue ones. Then, "
                + "he put back the rest of candies in order. ");
        int index = candies.indexOf("Orange");
        while (index != -1) {
            System.out.println("Index is " + index);
            //if index!=1, means the particular candy found
            for (int i = 0; i < index; i++) {
                tempCandies.push(candies.pop());
            }
            //removet that string
            candies.pop();
            //add them back
            for (int i = 0; i < index; i++) {
                candies.push(tempCandies.pop());
            }
            index = candies.indexOf("Orange");
        }
        System.out.println("The candies in the container:");
        candies.showStack();
    }
}
