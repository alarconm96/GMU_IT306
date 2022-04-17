package assignment6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HashTable extends ArrayList{
    private static int numElement;
    private Entry DEFUNCT = new Entry(null, null); // sentinel for deleted item
    private int collisions; // counts the total number of collisions during insertion

    public HashTable(int capacity){
      ArrayList table = new ArrayList(capacity);  
    }
    
    //Returns true if location is either empty or the defunct sentinel
    private boolean isAvailable(int j) {
    	checkIndex(j, size);
    	if (data[j] == null || data[j].equals(DEFUNCT)) {
			return true;
		}
    	return false;
    }
    
    // compute and return hash code given the key
    private int computeHashCode(String key){
    	return 0;
	}
    
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
    
    //read from file input and return String
    private String read(String file) throws FileNotFoundException {
    	Scanner sc = new Scanner(new FileReader("HashTable.csv"));
    	String input = "";
    	while (sc.hasNext()) {
			input+= sc.nextLine() + "\n";
		}
    	return input;
    }
    
}  
