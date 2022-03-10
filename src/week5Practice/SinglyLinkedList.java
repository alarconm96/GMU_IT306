package week5Practice;

public class SinglyLinkedList<E> {
	
	//nested Node class
	private static class Node<E>{
		
		//referencing element inside this Node object
		private E element;
		
		//pointing to the next Node location
		private Node<E> next;
		
		//constructor for Node object (element and its next pointer)
		public Node(E e, Node<E> n) {
			element = e;
			next = n;
		}
		
		public E getElement() {return element;}
		public Node<E> getNext() {return next;}
		public void setNext(Node<E> n) {next = n;}
		
	}
	
	//SinglyLinkedList instance variables
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	
	//accessors
	public int size() {return size;}
	public boolean isEmpty() {return size == 0;}
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getElement();
	}
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getElement();
	}
	
	//mutators
	public void addFirst(E e) {
		//new head connects to old head reference
		head = new Node<>(e, head);
		if(size == 0)
			//makes tail head also if this is the first node in list
			tail = head;
		size++;
	}
	public void addLast(E e) {
		Node<E> newest = new Node<>(e, null);
		if (isEmpty()) {
			head = newest;
		}else {
			tail.setNext(newest);
		}
		tail = newest;
		size++;
	}
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		E answer = head.getElement();
		head = head.getNext();
		size--;
		if (size == 0) {
			tail = null;
		}
		return answer;
	}
	

}
