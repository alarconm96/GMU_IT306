/*
 * Marco Alarcon
 * IT 306-002
 * March 23, 2022
 * In-class Assignment (Priority Queue)
 * */

package week8Inclass;

public class List<E>{

	// vars
    private Node<E> head;
    private Node<E> tail;
    private int size;
    
    // default constructor
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
    
    public void addToHead(int key, E data) {
    	Node<E> newNode = new Node<>(key, data);
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

    public void addToTail(int key, E data) {
    	Node<E> newNode = new Node<>(key, data);
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
    
    //returns and removes element of list
    public String removeMin() {
		if (isEmpty()) {
			return null;
		}
		Node<E> min = this.head;
    	Node<E> curr = this.head;
    	while (curr.hasNext()) {
    		if (min.getKey() > curr.getKey()) {
				min = curr;
			}
			curr = curr.getNext();
		}
    	
    	if (head != min) {
    		Node<E> prev = min.getPrev();
        	Node<E> next = min.getNext();
        	prev.setNext(next);
        	next.setPrev(prev);
    		min.setPrev(null);
    		min.setNext(null);
    		size--;
    		return String.format("(%d,%c)", min.getKey(), min.getData());
		} else {
    		if (min.hasNext()) {
    			this.head = min.getNext();
    			min.setNext(null);
			}else {
				this.head = null;
			}
    		size--;
    		return String.format("(%d,%c)", min.getKey(), min.getData());
		}
    	
	}
    
    //finds node with min key
    public String min() {
    	if (isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty list");
		}
    	Node<E> min = this.head;
    	Node<E> curr = this.head;
    	while (curr.getNext() != null) {
			if (min.getKey() > curr.getKey()) {
				min = curr;
			}
			curr = curr.getNext();
		}
    	return String.format("(%d,%c)", min.getKey(), min.getData());
    }
    
    public Node<E> findMin() {
    	if (isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty list");
		}
    	Node<E> min = this.head;
    	Node<E> curr = this.head;
    	while (curr.getNext() != null) {
			if (min.getKey() > curr.getKey()) {
				min = curr;
			}
			curr = curr.getNext();
		}
    	return min;
    }
    

    public boolean isEmpty() {
          return size == 0;
    }

    public int size() {
        return this.size;
    }

    //overridden toString()
    public String toString() {
        if (isEmpty()) return "{}";
        else {
            Node<E> currentNode = this.head;
            String returnValue = "{" + "(" + currentNode.getKey() + "," + currentNode.getData() + ")";
            while (currentNode.next != null) { 
                currentNode = currentNode.next;
                returnValue += "," + "(" + currentNode.getKey() + "," + currentNode.getData() + ")";
            }
            returnValue += "}";
            return returnValue;
        } 
    }

    /** Node class definition (inner class) **/

    private class Node<E> {

        private Node<E> prev;
        private Node<E> next;
        private int key;
        private E data;

        private Node(int key, E data) {
            this.key = key;
        	this.data = data;
        }
        
        private boolean hasNext() {
        	if (this.next == null) {
				return false;
			} else {
				return true;
			}
        }
        private int getKey() {return this.key;}
        private E getData() {return this.data;}
		private Node<E> getPrev() {return this.prev;}
		private Node<E> getNext() {return this.next;}
		private void setPrev(Node<E> prev) {this.prev = prev;}
		private void setNext(Node<E> next) {this.next = next;}
    }
    
}
