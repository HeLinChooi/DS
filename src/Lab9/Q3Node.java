package Lab9;
//He Lin's code
public class Q3Node<K, V>
{
    private K key;
    private V value;
    
    public Q3Node() {
        key = null;
        value = null;
    }
    
    public Q3Node(K a, V b) {
        key = a;
        value = b;
    }
    
    public void setKey(K a) {key = a;}
    public K getKey() {return key;}
    public void setValue(V a) {value = a;}
    public V getValue() {return value;}    
    public String toString() { return key + ":" + value + " --> " ; }
    
}  
