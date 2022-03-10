package week6Practice;

public interface Listable<E> {
	//return size of ArrayList object
	public int size();
	
	//check if ArrayList is empty
	public boolean isEmpty();
	
	//returns element at index i
	public E get(int i) throws IndexOutOfBoundsException;
	
	//sets element e at index i
	public void set(E e, int i) throws IndexOutOfBoundsException;
	
	//adds element e to index i, shifts all subsequent elements
	public void add(E  e, int i) throws IndexOutOfBoundsException;
	
	//removes and returns element at index i
	public E remove(int i) throws IndexOutOfBoundsException;
}
