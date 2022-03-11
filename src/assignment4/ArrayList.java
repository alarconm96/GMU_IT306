package assignment4;
public class ArrayList implements List {

    public static final int CAPACITY = 16;
    protected int[] data;
    protected int size = 0;

    public ArrayList() { this(CAPACITY); }

    public ArrayList(int capacity) {
        data = new int[capacity];
    }

    public int size() {
        //size of ArrayList
        return size; // stub code
    }

    public boolean isEmpty() {
        //check if empty
        return size == 0; // stub code
    }

    public int get(int i) throws IndexOutOfBoundsException {
        //return element at index i
    	checkIndex(i, size);
        return data[i]; // stub code
    }

    public int set(int i, int e) throws IndexOutOfBoundsException {
        //replace element at index i with new element; return old element
    	checkIndex(i, size);
    	int replaced = data[i];
    	data[i] = e;
        return replaced; // stub code
    }

    public void add(int i, int e) throws IndexOutOfBoundsException, IllegalStateException {
        //adds element to index i; pushes subsequent elements down
    	checkIndex(i, size+1);
    	if (size == data.length) {
    		//TODO - change to add capacity to array
    		increaseCapacity();
		}
    	for (int j = size-1; j > i; j--) {
			data[j] = data[j-1];
		}
    	data[i] = e;
    	size++;
    }

    public int remove(int i) throws IndexOutOfBoundsException {
        //remove and return element at index i
    	checkIndex(i, size);
    	int e = data[i];
    	for (int j = i+1; j < data.length; j++) {
			data[j-1] = data[j];
		}
    	size--;
        return e;
    }
    

    
    //SPECIAL PURPOSE METHODS
    
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        //verify index is within bounds
    	if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + i);
		}
    }
    
    public void increaseCapacity() throws IllegalStateException {
        //replaces array with new array of double size if full
    	if (data == null) {
			throw new IllegalStateException("Array does not exist");
		}
    	int[] newArr = new int[size * 2];
    	for (int i = 0; i < this.data.length; i++) {
			newArr[i] = this.data[i];
		}
    	this.data = newArr;
    }

    public void minimize() throws IllegalStateException {
        //trims empty elements from data array
    	if (data == null) {
			throw new IllegalStateException("Array does not exist");
		}
    	if (size == 0) {
			throw new IllegalStateException("Array is empty and cannot be minimized further");
		}
    	int[] newArr = new int[size];
    	for (int i = 0; i < size; i++) {
			newArr[i] = data[i];
		}
    	data = newArr;
    }

    public int capacity() throws IllegalStateException {
        //returns length of array object (not size)
        if (data == null) {
			throw new IllegalStateException("Array does not exist");
		}
    	return data.length;
    }
    public void quickSort(){
      //TODO - implement quicksort algorithm
    }

}