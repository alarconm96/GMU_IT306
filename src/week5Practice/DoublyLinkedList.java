package week5Practice;

public class DoublyLinkedList<E> {
	
	private Node<E> head;
	private Node<E> tail;
	public int size = 0;
	
	private class Node<E> {
		private E data;
		private Node<E> prev;
		private Node<E> next;
		
		private Node(E data, Node<E> prev, Node<E> next){
			this.data = data;
			this.prev = prev;
			this.next = next;
		}
		public E getData() {return data;}
		public Node<E> getPrev() {return this.prev;}
		public Node<E> getNext() {return this.next;}
		public void setPrev(Node<E> prev) {this.prev = prev;}
		public void setNext(Node<E> next) {this.next = next;}
	}
	
	public DoublyLinkedList() {
		head = new Node<>(null, null, null);
		tail = new Node<>(null, head, null);
		head.setNext(tail);
	}
	
	public int size() {return size;}
	
	public boolean isEmpty() {return size == 0;}
	
	//return but does NOT remove first item
	public E first() {
		if (isEmpty()) {
			return null;
		}
		return head.getNext().getData();
	}
	
	//returns but does NOT remove last item
	public E last() {
		if (isEmpty()) {
			return null;
		}
		return tail.getPrev().getData();
	}
	
	//general add method to be used by other methods
	private void add(E data, Node<E> prev, Node<E> next) {
		Node<E> newNode = new Node<>(data, prev, next);
		prev.setNext(newNode);
		next.setPrev(newNode);
		size++;
	}
	
	//general remove method to be used by other methods
	private E remove(Node<E> node) {
		Node<E> prev = node.getPrev();
		Node<E> next = node.getNext();
		prev.setNext(next);
		next.setPrev(prev);
		size--;
		return node.getData();
	}
	
	public void addFirst(E data) {
		add(data, head, head.getNext());
	}
	
	public void addLast(E data) {
		add(data, tail.getPrev(), tail);
	}
	
	public E removeFirst() {
		if (isEmpty()) {
			return null;
		}
		return remove(head.getNext());
	}
	
	public E removeLast() {
		if (isEmpty()) {
			return null;
		}
		return remove(tail.getPrev());
	}
	
}