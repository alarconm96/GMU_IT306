package assignment6;
public class HashTable{
    private static int numElement;
    private Entry DEFUNCT = new Entry(null, null); // sentinel for deleted item
    private int collisions; // counts the total number of collisions during insertion

    public HashTable(int capacity){
      ArrayList<Entry> table = new ArrayList<Entry>(capacity);  
    }
    
    //Returns true if location is either empty or the defunct sentinel
    private boolean isAvailable(int j) {
        return false;
    }
    // compute and return hash code given the key
    private int computeHashCode(String key){return 0;}
    
    // compute and return the compressed hash index 
    private int compressHashCode(){return 0;}
    
    // return the index for a key.  
    public int findSlot(int k){return 0;}
    
    // return the value associated with key K
    public String tableSearch(String K){return null;}
    // inserts the value associated with key K  
    public String tableInsert(String K) {return null;}
    //remove the value associated with key K  
    public String tableRemove(String K) {return null;}
    //print the content of the table
    public void tablePrint(){}
    
    
}  
