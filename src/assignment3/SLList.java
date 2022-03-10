/*
 * Marco Alarcon
 * IT 306-002
 * Assignment 3
 * March 2, 2022
 * */

package assignment3;

public class SLList<E> implements Listable<E>{
	private Node<E> head;
	private Node<E> tail;
	private int size = 0;
	
	//nested Node class
	private class Node<E>{
		private E data;
		private Node<E> next;
		
		private Node(E data) {
			this.data = data;
		}
		
		public E getData() {return data;}
		
		public Node<E> getNext() {return next;}
		
		private void setNext(Node<E> next) {this.next = next;}
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size == 0;}
	
	public E first() {
    	if (isEmpty()) {
			throw new IllegalStateException("Cannot get data from empty list");
		}
    	return head.getData();
    }
	
	public void addToHead(E data) {
    	Node<E> newNode = new Node<>(data);
    	if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.setNext(head);
			head = newNode;
		}
    	size++;
    }
	
	public void addToTail(E data) {
		Node<E> newNode = new Node<>(data);
		if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}else {
			tail.setNext(newNode);
			tail = newNode;
		}
	}
	
	//returns and removes first element of list
	public E remove() {
		if (isEmpty()) {
			return null;
		}
		Node<E> curr = head;
		if (size() == 1) {
			head = null;
			curr.setNext(null);
			return curr.getData();
		}
		head = head.getNext();
		curr.setNext(null);
		return curr.getData();
	}
	
	//overridden toString()
	public String toString() {
        if (isEmpty()) return "{}";
        else {
            Node<E> currentNode = head;
            String returnValue = "{" + currentNode.getData();
            while (currentNode.next != null) { 
                currentNode = currentNode.next;
                returnValue += "," + currentNode.getData();
            }
            returnValue += "}";
            return returnValue;
        } 
    }
}
