package assignment6;

public class HashTable extends ArrayList{
    private static int numElement;
    private Entry DEFUNCT = new Entry(null, null); // sentinel for deleted item
    private int collisions; // counts the total number of collisions during insertion

    public HashTable(int capacity){
      ArrayList table = new ArrayList(capacity);  
    }
    
    //Returns true if location is either empty or the defunct sentinel
    private boolean isAvailable(int j) {
    	checkIndex(j, capacity);
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
    	checkIndex(index, capacity);
    	return index;
    }
    
    // return the value associated with key K
    public String tableSearch(String k){
    	int index = compressHashCode(computeHashCode(k));
    	checkIndex(index, capacity);
    	if (data[index] == null || data[index].equals(DEFUNCT)) {
			return null;
		}
    	return data[index].getValue();
    }
    
    // inserts the value associated with key K if table is not full
    // if collision, probe each element linearly until available element is found
    public String tableInsert(String k) {
    	if (size == capacity) {
			throw new IllegalStateException("Table is at maximum capacity - remove an element before inserting a new one");
		}
    	int index = compressHashCode(computeHashCode(k));
    	checkIndex(index, capacity);
    	Entry e = new Entry(Integer.toString(index), k);
    	if (isAvailable(index)) {
			set(index, e);
			numElement++;
		}else {
			while (!isAvailable(index)) {
				collisions++;
				index = ++index % capacity;
				checkIndex(index, capacity);
				if (isAvailable(index)) {
					set(index, e);
					numElement++;
					break;
				}
			}
		}
    	return k;
    }
    
    //remove the value associated with key K  
    public String tableRemove(String k) {
    	int index = compressHashCode(computeHashCode(k));
    	checkIndex(index, capacity);
    	if (tableSearch(k) == null) {
			throw new IllegalArgumentException("Element " + k + " does not exist");
		}
    	Entry replaced = set(index, DEFUNCT);
    	numElement--;
    	return replaced.getValue();
	}
    
    //print the content of the table
    public void tablePrint(){
    	System.out.println("Printing table");
    	System.out.print("[");
    	for (int i = 0; i < data.length; i++) {
			System.out.printf("%s", data[i].getValue());
			if (i < data.length - 1) {
				System.out.print(",");
			}
		}
    	System.out.println("]");
    }
    
    public int getNumElements() {
    	return HashTable.numElement;
    }
    
    public int getCollisions() {
    	return this.collisions;
    }
    
    public void numElements() {
    	System.out.printf("Number of elements in table: %d%n", getNumElements());
    }
    
    public void numCollisions() {
    	System.out.printf("Number of collisions: %d%n", getCollisions());
    }
}  
