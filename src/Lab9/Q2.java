package Lab9;
//He Lin's code
public class Q2 {
    public static void main(String[] args) {
        Q2LinkedList<Integer> test = new Q2LinkedList<>();
        int elementToBeFind = 11;
        int begin = 17;
        int end = 20;
        test.generateRamdonList(0, 10);
        test.showList();
        test.isFound(elementToBeFind);
        test.linearSearchCount(elementToBeFind);
        test.isFoundByRange(begin, end);
        test.linearSearchCountByRange(begin, end);
    }
}
