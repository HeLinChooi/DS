package Lab9;
//He Lin's code
public class Q5Node<K, V>
{
    private K key;
    private V value;
    private Q5Node nextNode;
    
    public Q5Node() {}
    
    public Q5Node(K a, V b, Q5Node c) {
        key = a;
        value = b;
        nextNode = c;
    }
    
    public void setKey(K a) {key = a;}
    public K getKey() {return key;}
    public void setValue(V a) {value = a;}
    public V getValue() {return value;}  

    public void setNextNode(Q5Node nextNode) {
        this.nextNode = nextNode;
    }
    public Q5Node getNextNode() {
        return nextNode;
    }
    public String toString() { return key + ":" + value + " --> " ; }
}  
