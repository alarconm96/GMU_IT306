package assignment6;

public class ArrayList<E> {
    protected E[] data;
    protected int size = 0;
    protected int capacity = 0;

    //public ArrayList() { this(CAPACITY); }

    public ArrayList(int capacity) {
       data = (E[]) new Object[capacity];
       this.capacity = capacity;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E get(int i) throws IndexOutOfBoundsException {
    	//System.out.println("get element");
    	checkIndex(i, size);
        return data[i];
    }

    public E set(int i, E e) throws IndexOutOfBoundsException {
    	checkIndex(i, size);
    	E replaced = data[i];
    	data[i] = e;
    	return replaced;
    }

    public void add(int i, E e) throws IndexOutOfBoundsException, IllegalStateException {
    	//System.out.println("add element");
    	checkIndex(i, size + 1); 
    	if (size == data.length) throw new IllegalStateException("Array is full");
    	for (int j = size - 1; j >= i; j--)  // start by shifting to the rightmost
    		data[j+1] = data[j];
		data[i] = e; // add new element at index i
		size++;
    }

    public E remove(int i) throws IndexOutOfBoundsException {
    	//System.out.println("remove element");
    	checkIndex(i, size);
    	E removed = data[i];
    	for (int j = i; j < size - 1; j++) { // shift down for a removal at index i 
    		data[j] = data[j+1];
    	}
    	data[size - 1] = null;
    	size--;
        return removed; 
    }
   
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
    	//System.out.println("check index: i = " + i + " n = " + n);
        if (i < 0 || i >= n) throw new IndexOutOfBoundsException("Illegal index: " + i);
    }

}
