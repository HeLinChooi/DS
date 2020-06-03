package Tuto9;
//Dr. Ang's code
public class HashTable<K,V> {
    private MapNode head;

    public HashTable() {
        head = null;
    }

    public boolean isEmpty() {
        return (head==null);
    }
    
    public int getSize() {
        int count=0;    
        MapNode currentNode = head;
        while (currentNode != null) {
            currentNode = currentNode.getLink();
            count++;
        }
        return count;
    }
    
    public void showHashTable() {
        MapNode currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.toString());
            currentNode = currentNode.getLink();
        }
    }
    
    public void clear() {
        head=null;
    }
    
    public boolean containsKey(Comparable<K> k) {        
        MapNode currentNode = head;
        while (currentNode != null) {
            if (k.compareTo((K)currentNode.getKey())==0) {
                return true;                
            }            
            else {
                currentNode = currentNode.getLink();
            }
        }
        return false;
   }
    
    public boolean containsValue(Comparable<V> v) {
        MapNode currentNode = head;
        while (currentNode != null) {
            if (v.compareTo((V)currentNode.getValue())==0) {
                return true;                
            }            
            else {
                currentNode = currentNode.getLink();
            }
        }
        return false;
    } 
   
   public V get(Comparable<K> k) {
       MapNode currentNode = head;
       while (currentNode != null) {
         if (k.compareTo((K)currentNode.getKey())==0) {
            return (V) currentNode.getValue();
         }
         else {            
            currentNode = currentNode.getLink();
         }         
       } 
       return null;
   }
   
   public V put(Comparable<K> k, V v) {
        if (isEmpty()) {
            head = new MapNode(k, v, null);
        }
        else {
            MapNode newNode =new MapNode(k, v, null);
            MapNode currentNode = head;
            MapNode previousNode = null;
            while(currentNode != null) {
                if (k.compareTo((K)currentNode.getKey())==0) {
                    V temp = (V) currentNode.getValue();
                    currentNode.setValue(v);
                    //if the key is same with current node
                    //return the previous value stored with the key
                    //but now the key has linked with new value
                    return temp;
                }   
                else {
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }       
            }
            //previous node will never be null. From He Lin
//            if (previousNode==null) {
//                //if the table is not empty, got only 1 node and the key id diff
//                //make this newNode infront of head
//                System.out.println("the table got only 1 node");
//                newNode.setLink(head);
//                head = newNode;
//            }
//            else {    
                //the table got more than 1 node, add new Node to the end
                previousNode.setLink(newNode);
                //currentNode is null
                newNode.setLink(currentNode);
//            }
        }
        return null;
    }
    
    public V remove(Comparable<K> k) {
        if (isEmpty()) {
            return null;
        }
        else {
            MapNode currentNode = head;
            MapNode previousNode = null;
            boolean found = false;
            while(currentNode != null) {
                if (k.compareTo((K)currentNode.getKey())==0) {                    
                    found =true;
                    break;
                }
                else {
                    previousNode = currentNode;
                    currentNode = currentNode.getLink();
                }                 
            }
            if (found) {
                V temp = (V) currentNode.getValue();
                if (previousNode==null) 
                    head = head.getLink();
                else {
                     previousNode.setLink(currentNode.getLink());
                }
                return temp;
            }
            else
                return null;
        }    
   }    
    
}
