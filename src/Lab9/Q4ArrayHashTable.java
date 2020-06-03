package Lab9;
//He Lin's code
public class Q4ArrayHashTable<K,V> {
    public static final int SIZE = 20;
    public Q3Node<K,V>[] ht = new Q3Node[SIZE];
    public int size = 0;
    public Q4ArrayHashTable() {}
    public boolean isEmpty(){return size == 0;}
    public boolean isFull(){return size == SIZE;}
    public int getSize(){return size;}
    public void clear(){
        for (int i = 0; i < this.ht.length; i++) {
            ht[i] = null;
        }
    }
    public void showHashTable(){
        for (int i = 0; i < this.ht.length; i++) {
            if(!(ht[i] == null)){
                System.out.print(ht[i].getKey() + " :"+ ht[i].getValue());
                System.out.println("");
            }
        }
    }
    public boolean containsKey(K key){
        //what's the diff btw these 2 ?
//        for (Q3Node ht1 : this.ht) {
        for (Q3Node<K, V> ht1 : this.ht) {
            if(ht1 !=null){
                if (ht1.getKey().equals(key)) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean containsValue(V value){
        for (Q3Node<K, V> ht1 : this.ht) {
            if (ht1.getValue().equals(value)) {
                return true;
            }
        }
        return false;
    }
    public V get(K key){
        for (Q3Node<K, V> ht1 : this.ht) {
            if(ht1!=null){
                if (ht1.getKey().equals(key)) {
                    return ht1.getValue();
                }
            }
        }
        return null;
    }
    public void put(K key, V value){
        if(!this.isFull()){
            if(ht[hashcode(key)]==null){
                ht[hashcode(key)] = new Q3Node<>(key, value);
            }else{
                for (int i = hashcode(key) + 1; i < ht.length; i++) {
                    //linear probing
                    if (ht[i] == null) {
                        ht[i] = new Q3Node<>(key, value);
                        break;
                    }
                }
            }
        }else{
            System.out.println("The array is full.");
        }
    }
    public Q3Node remove(K key){
        if(!this.isEmpty()){
            Q3Node temp ;
            for (int i = 0;i<this.ht.length;i++) {
                if (ht[i].getKey().equals(key)) {
                    temp = ht[i];
                    ht[i] = null;
                    size--;
                    return temp;
                }
            }
        }else{
            System.out.println("The array is empty.");
        }
        return null;
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
    public int getLocation(K key){
        for (int i = 0; i < ht.length; i++) {
            if(ht[i]!=null){
                if(ht[i].getKey().equals(key)){
                    return i;
                }
            }
        }
        return -1;
    }
}

