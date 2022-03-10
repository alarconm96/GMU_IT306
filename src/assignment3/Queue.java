/*
 * Marco Alarcon
 * IT 306-002
 * March 2, 2022
 * Assignment 3
 * */

//pacakge/folder declaration
package assignment3;

public class Queue<E> implements Queueable<E> {
	private List<E> list = new List<>();
	
	//queue methods relying on List
	public int size() {return list.size();}
	public E first() {return list.first();}
	public void enqueue(E data) {list.addToTail(data);}
	public boolean isEmpty() {return list.isEmpty();}
	public E dequeue() {return list.remove();}
	
	//overridden toString()
	public String toString() {return list.toString();}
}
