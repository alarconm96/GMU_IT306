/*
 * Marco Alarcon
 * IT 306-002
 * March 2, 2022
 * Assignment 3
 * */

//package/folder declaration
package assignment3;

public class SLQueue<E> implements Queueable<E>{
	SLList<E> sll = new SLList<>();
	
	//queue methods relying on Singly LinkedList (SLList)
	public int size() {return sll.size();}
	public boolean isEmpty() {return sll.isEmpty();}
	public E first() {return sll.first();}
	public void enqueue(E data) {sll.addToHead(data);}
	public E dequeue() {return sll.remove();}
	
	//overridden toString()
	public String toString() {return sll.toString();}
}
