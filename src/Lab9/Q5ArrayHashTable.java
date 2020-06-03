package Lab9;
//He Lin's code

public class Q5ArrayHashTable<K,V> {
    public static final int SIZE = 20;
    public Q5LinkedList<K,V>[] ht = new Q5LinkedList[SIZE];
    public int size = 0;
    public Q5ArrayHashTable() {}
    public boolean isEmpty(){return size == 0;}
    public boolean isFull(){return size == SIZE;}
    public int getSize(){return size;}
    public void clear(){
        for (int i = 0; i < this.ht.length; i++) {
            ht[i] = null;
        }
    }
    public void showHashTable(){
        System.out.println("HashTable");
        for (int i = 0; i < this.ht.length; i++) {
            if(!(ht[i] == null)){
                ht[i].showList();
            }
        }
    }
    public boolean containsKey(K key){
        for (Q5LinkedList l : this.ht) {
            if(l !=null){
                if (l.searchBasedOnKey(key) != null) {
                    return true;
                }
            }
        }
        System.out.println("can't found");
        return false;
    }
//    public boolean containsValue(V value){
//        for (Q5LinkedList l : this.ht) {
//            if(l !=null){
//                if (l.searchBasedOnValue(value) != null) {
//                    System.out.println("found!");
//                    return true;
//                }
//            }
//        }
//        System.out.println("can't found");
//        return false;
//    }
    public V get(K key){
        for (Q5LinkedList l : this.ht) {
            if(l !=null){
                Q5Node temp = l.searchBasedOnKey(key);
                if (temp != null) {
                    return (V)temp.getValue();
                }
            }
        }
        System.out.println("can't found");
        return null;
    }
    public Q5Node getNode(K key){
        for (Q5LinkedList l : this.ht) {
            if(l !=null){
                Q5Node temp = l.searchBasedOnKey(key);
                if (temp != null) {
                    return temp;
                }
            }
        }
        System.out.println("can't found");
        return null;
    }
    public void put(K key, V value){
        if(!this.isFull()){
            if(ht[hashcode(key)]==null){
                ht[hashcode(key)] = new Q5LinkedList<>(key, value);
            }else{
                ht[hashcode(key)].addNode(key, value);
            }
        }else{
            System.out.println("The array is full.");
        }
    }
    //Q4 special method
    private int hashcode(K key){
        if(key instanceof Integer){
            return (Integer)key%ht.length;
        }else{
            System.out.println("key is not a integer");
            return -1;
        }
    }
    public void getLocation(K key){
        for (int i = 0; i < ht.length; i++) {
            if(ht[i]!=null){
                if (ht[i].searchBasedOnKey(key) != null) {
                    ht[i].showList();
                    return;
                }
            }
        }
        System.out.println("No such key.");
    }
}


