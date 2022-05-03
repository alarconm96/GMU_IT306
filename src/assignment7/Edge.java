/*
 * Marco Alarcon
 * IT306-002
 * May 4, 2022
 * Assignment 7
 * */
package assignment7;


/**
 * An edge of a graph.
 **/
public interface Edge<E> {
  /** Returns the element associated with the edge. */
	E getElement();
	/**Returns edge label used for traversals*/
	String getLabel();
	/**Sets edge label, used for traversals*/
	void setLabel(String s);
}
