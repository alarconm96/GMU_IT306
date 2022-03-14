/*
 * Marco Alarcon
 * IT 306-002
 * March 16, 2022
 * */
package assignment4;
import java.util.Random;
public class ArrayList implements List {
	//instance vars
    public static final int CAPACITY = 16;
    protected int[] data;
    protected int size = 0;
    
    //default constructor
    public ArrayList() { this(CAPACITY); }
    //constructor with parameterized capacity
    public ArrayList(int capacity) {
        data = new int[capacity];
    }
    
    //return ArrayList object's size
    public int size() {
        return size;
    }
    
    //check if ArrayList object is empty
    public boolean isEmpty() {
        //check if empty
        return size == 0;
    }

    //returns element at index i, but does not remove
    public int get(int i) throws IndexOutOfBoundsException {
    	checkIndex(i, size);
        return data[i];
    }

    //replace element at index i with new element; return old element
    public int set(int i, int e) throws IndexOutOfBoundsException {
    	checkIndex(i, size);
    	int replaced = data[i];
    	data[i] = e;
        return replaced; // stub code
    }

    //adds element to index i; pushes subsequent elements down
    public void add(int i, int e) throws IndexOutOfBoundsException, IllegalStateException {   
    	checkIndex(i, size+1);
    	if (size == data.length) {
    		increaseCapacity();
		}
    	for (int j = size-1; j > i; j--) {
			data[j] = data[j-1];
		}
    	data[i] = e;
    	size++;
    }

    //remove and return element at index i
    public int remove(int i) throws IndexOutOfBoundsException {
    	checkIndex(i, size);
    	int e = data[i];
    	for (int j = i+1; j < data.length; j++) {
			data[j-1] = data[j];
		}
    	size--;
        return e;
    }
    

    
    //SPECIAL PURPOSE METHODS
    
    //verify index is within bounds
    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
    	if (i < 0 || i >= n) {
			throw new IndexOutOfBoundsException("Illegal index: " + i);
		}
    }
    
    //replaces array with new array of double size if full
    public void increaseCapacity() throws IllegalStateException {
    	if (data == null) {
			throw new IllegalStateException("Array does not exist");
		}
    	int[] newArr = new int[size * 2];
    	for (int i = 0; i < this.data.length; i++) {
			newArr[i] = this.data[i];
		}
    	this.data = newArr;
    }

    //trims empty elements from data array
    public void minimize() throws IllegalStateException {
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

    //returns length of array object (not size)
    public int capacity() throws IllegalStateException {
        if (data == null) {
			throw new IllegalStateException("Array does not exist");
		}
    	return data.length;
    }
    
    //public quicksort method to be called by user
    public void quickSort(){
    	//only runs if more than one element in array
    	if (size > 1)
    		quickSort(data, 0, size-1);
    }
    
    //private quicksort method that recursively calls itself for each partition
    private void quickSort(int[] arr, int low, int high) {
    	int pivot = partition(arr, low, high);
    	if (pivot-1 > low)
    		quickSort(arr, low, pivot-1);
    	if (pivot < high)
    		quickSort(arr, pivot, high);
    }
    
    //private method to swap low and high indexes
    private void swap(int[] arr, int low, int high) {
    	int tmp = arr[low];
    	arr[low] = arr[high];
    	arr[high] = tmp;
    }
    
    //private method to partition sub-array
    private int partition(int[] arr, int low, int high) {
    	//randomly choose pivot for initial partition
    	Random rand = new Random();
    	int pivot = arr[rand.nextInt((high - low) + low)];
    	//while-loop until low and high indexes meet
    	while (low <= high) {
			//find index of element less than pivot to swap
    		while (arr[low] < pivot)
				low++;
    		//find index of element greater than pivot to swap
			while (arr[high] > pivot)
				high--;
			//swap once misplaced elements are found
			if (low <= high) {
				swap(arr, low, high);
				low++;
				high--;
			}
		}
    	//returns new partition index
    	return low;
    }

}