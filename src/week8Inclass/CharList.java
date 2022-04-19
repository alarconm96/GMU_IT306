/*
 * Marco Alarcon
 * IT 306-002
 * March 23, 2022
 * In-class Assignment (Priority Queue)
 * */

package week8Inclass;

public class CharList extends List<Character>{
	
	private List<Character> pq = new List<>();

    /** Inserts an element at the end of the queue */
    public void insert(int key, char element) {
    	pq.addToTail(key, element);
    }
    

    /** Removes and returns the first element 
     OR IllegalStateException if empty */ 
    public String removeMin() {
    	// TODO - return string of element (k,v)
    	return pq.removeMin();
    }
    
    /* Returns but does not remove element with min key
     * */
    public String min() {
    	return pq.min();
    }

    /** Tests if the queue is empty
     * @return true if queue is empty; else false */
    public boolean isEmpty() {
    	return pq.isEmpty();
    }

    /** Returns the number of elements in the Queue
     * @return number of elements in the Queue */
    public int size() {
      return pq.size();
    }
    
    /** Display queue */
    public String toString() {
    	return pq.toString();
    }

}