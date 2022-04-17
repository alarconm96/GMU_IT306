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
    	int ascii = 0;
    	for (int i = 0; i < key.length(); i++) {
			ascii += (int) key.charAt(i);
		}
    	return ascii;
	}
    
    // compute and return the compressed hash index 
    private int compressHashCode(int h1){
    	int hash = h1 % capacity;
    	return hash;
    }
    
    // return the index for a key.  
    public int findSlot(String k){
    	int index = compressHashCode(computeHashCode(k));
    	checkIndex(index, size);
    	return index;
    }
    
    // return the value associated with key K
    public String tableSearch(String k){
    	int index = compressHashCode(computeHashCode(k));
    	checkIndex(index, size);
    	return data[index].getValue();
    }
    // inserts the value associated with key K  
    public String tableInsert(String k) {return null;}
    //remove the value associated with key K  
    public String tableRemove(String k) {return null;}
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
