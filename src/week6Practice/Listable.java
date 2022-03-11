package week6Practice;

public interface Listable {
	//return size of ArrayList object
	public int size();
	
	//check if ArrayList is empty
	public boolean isEmpty();
	
	//returns element at index i
	public int get(int i) throws IndexOutOfBoundsException;
	
	//sets element e at index i
	public void set(int e, int i) throws IndexOutOfBoundsException;
	
	//adds element e to index i, shifts all subsequent elements
	public void add(int  e, int i) throws IndexOutOfBoundsException;
	
	//removes and returns element at index i
	public int remove(int i) throws IndexOutOfBoundsException;
}
