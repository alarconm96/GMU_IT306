/*
 * Marco Alarcon
 * IT 306-002
 * March 2, 2022
 * Assignment 3
 * */

//package/folder declaration
package assignment3;

public class List<E> implements Listable<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    public List() {
    	this.head = null;
    	this.tail = null;
    	this.size = 0;
    }
    
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
			head.setPrev(newNode);
			head = head.getPrev();
		}
    	size++;
    }

    public void addToTail(E data) {
    	Node<E> newNode = new Node<>(data);
    	if (isEmpty()) {
			head = newNode;
			tail = newNode;
		}else {
			newNode.setPrev(tail);
			tail.setNext(newNode);
			tail = tail.getNext();
		}
    	size++;
    }
    
    //returns and removes first element of list
    public E remove() {
		if (isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty list");
		}
		Node<E> curr = head;
		if (curr.getNext() == null) {
			head = null;
			tail = null;
			size--;
			return curr.getData();
		}else {
			head = curr.getNext();
			curr.setNext(null);
			size--;
			return curr.getData();
		}
		
	}

    public boolean isEmpty() {
          return size == 0;
    }

    public int size() {
        return size;
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

    /** Node class definition (inner class) **/

    private class Node<E> {

        private Node<E> prev;
        private Node<E> next;
        private E data;

        private Node(E data) {
            this.data = data;
        }
        
        private E getData() {return data;}
		private Node<E> getPrev() {return this.prev;}
		private Node<E> getNext() {return this.next;}
		private void setPrev(Node<E> prev) {this.prev = prev;}
		private void setNext(Node<E> next) {this.next = next;}
    }
    
}
