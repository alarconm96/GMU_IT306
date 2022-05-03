/*
 * Marco Alarcon
 * IT306-002
 * May 4, 2022
 * Assignment 7
 * */
package assignment7;
/**
 * A vertex of a graph.
 */
public interface Vertex<V> {
  /** Returns the element associated with the vertex. */
  V getElement();
  /**Returns label used for traversal*/
  String getLabel();
  /**Sets label to String s, used for traversal*/
  void setLabel(String s);
  /**Returns vertex weight used for Dijkstra's Algorithm*/
  int getWeight();
  /**Sets vertex weight, used for Dijkstra's Algorithm*/
  void setWeight(int weight);
}
