package assignment4;
public class ArrayList implements List {

    public static final int CAPACITY = 16;
    protected int[] data;
    protected int size = 0;

    public ArrayList() { this(CAPACITY); }

    public ArrayList(int capacity) {
        // your code here
    }

    public int size() {
        // your code here
        return 0; // stub code
    }

    public boolean isEmpty() {
        // your code here
        return true; // stub code
    }

    public int get(int i) throws IndexOutOfBoundsException {
        // your code here
        return 0; // stub code
    }

    public int set(int i, int e) throws IndexOutOfBoundsException {
        // your code here
        return 0; // stub code
    }

    public void add(int i, int e) throws IndexOutOfBoundsException, IllegalStateException {
        // your code here
    }

    public int remove(int i) throws IndexOutOfBoundsException {
        // your code here
        return 0; // stub code
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        // your code here
    }
    
    public void increaseCapacity() throws IllegalStateException {
        // your code here
    }

    public void minimize() throws IllegalStateException {
        // your code here
    }

    public int capacity() throws IllegalStateException {
        // your code here
        return -999; // stub line 
    }
    public void quickSort(){
      //your code here
    }

}