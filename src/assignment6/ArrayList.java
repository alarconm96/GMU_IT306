package assignment6;

public class ArrayList{
    protected Entry[] data;
    protected int size;
    protected int capacity;

    public ArrayList() {
    	this.size = 0;
    	this.capacity = 0;
    }

    //initialize data array of type E[] and set the capacity
    public ArrayList(int capacity) {
       super();
       this.data = new Entry[capacity];
       this.capacity = capacity;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    //check if index valid, then return element at index i
    public Entry get(int i) throws IndexOutOfBoundsException {
    	//System.out.println("get element");
    	checkIndex(i, this.size);
        return this.data[i];
    }

    //check if index valid, then replace old element with new element, finally return old element
    public Entry set(int i, Entry e) throws IndexOutOfBoundsException {
    	checkIndex(i, this.size);
    	Entry replaced = this.data[i];
    	this.data[i] = e;
    	return replaced;
    }

    //check if index is valid & array is not full, then shift elements right starting from right to curr index
    public void add(int i, Entry e) throws IndexOutOfBoundsException, IllegalStateException {
    	//System.out.println("add element");
    	checkIndex(i, size + 1); 
    	if (size == data.length) throw new IllegalStateException("Array is full");
    	for (int j = size - 1; j >= i; j--)  // start by shifting to the rightmost
    		data[j+1] = data[j];
		data[i] = e; // add new element at index i
		size++;
    }

    public Entry remove(int i) throws IndexOutOfBoundsException {
    	//System.out.println("remove element");
    	checkIndex(i, size);
    	Entry removed = data[i];
    	for (int j = i; j < size - 1; j++) { // shift down for a removal at index i 
    		data[j] = data[j+1];
    	}
    	data[size - 1] = null;
    	size--;
        return removed; 
    }
   
    //check if index is within array bounds
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
    	//System.out.println("check index: i = " + i + " n = " + n);
        if (i < 0 || i >= n) throw new IndexOutOfBoundsException("Illegal index: " + i);
    }
    
    //nested Entry class
    protected class Entry {
        
        private String k;  // key
        private String v;  // value

        public Entry(String key, String value) {
          this.k = key;
          this.v = value;
        }

        // methods of the Entry interface
        public String getKey() { return k; }
        public String getValue() { return v; }

        // utilities not exposed as part of the Entry interface
        protected void setKey(String key) { k = key; }
        protected void setValue(String value) { v = value; }
      
      
    }

}
