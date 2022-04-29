package assignment7;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * This class provides a utility to build a graph from a list of edges.
 *

 */
public class GraphExamples {

  /**
   * Constructs a graph from an array of array strings.
   *
   * An edge can be specified as { "SFO", "LAX" }, in which case edge is created
   * with default edge value of 1, or as { "SFO", "LAX", "337" }, in which case
      labels.add(edge[0]);
   * the third entry should be a string that will be converted to an integral value.
   */
  public static Graph<String,Integer> graphFromEdgelist(String[][] edges, boolean directed) {
    Graph<String,Integer> g = new AdjacencyMapGraph<>(directed);

    // first pass to get sorted set of vertex labels
    TreeSet<String> labels = new TreeSet<>();
    for (String[] edge : edges) {
      labels.add(edge[0]);
      labels.add(edge[1]);
    }

    // now create vertices (in alphabetical order)
    HashMap<String, Vertex<String> > verts = new HashMap<>();
    for (String label : labels)
      verts.put(label, g.insertVertex(label));
    

    // now add edges to the graph
    for (String[] edge : edges) {
      Integer cost = (edge.length == 2 ? 1 : Integer.parseInt(edge[2]));
      g.insertEdge(verts.get(edge[0]), verts.get(edge[1]), cost);
    }
    return g;
  }

  /** Returns the unweighted, directed graph from Figure 14.12 of DSAJ6. */
  
  
  public static Graph<String,Integer> Graph0() {
    String[][] edges = {
      {"A","C"}, {"A","D"}, {"B","D"}, {"B", "F"}, {"C","D"}, {"C","E"},
      {"D","F"}, {"E","G"}, {"F","G"}, {"F","H"}, {"G","H"}
    };
    return graphFromEdgelist(edges, true);
  }
  
  //creates graph1 and returns edgelist
  public static Graph<String,Integer> Graph1() {
	    String[][] edges = {
	      {"A", "E"}, {"A", "F"}, {"A", "B"}, {"B", "A"}, {"B", "F"}, {"B", "C"}, {"C", "B"}, 
	      {"C", "G"}, {"C", "D"}, {"D", "C"}, {"D", "G"}, {"D", "H"}, {"E", "A"}, {"E", "F"}, 
	      {"E", "I"}, {"F", "E"}, {"F", "I"}, {"F", "A"}, {"F", "B"}, {"G", "C"}, {"G", "D"}, {"G", "J"}, {"G", "K"}, {"G", "L"}, 
	      {"H", "D"}, {"H", "L"}, {"I", "E"}, {"I", "F"}, {"I", "J"}, {"I", "M"}, {"I", "N"}, 
	      {"J", "I"}, {"J", "G"}, {"J", "K"}, {"K", "J"}, {"K", "G"}, {"K", "N"}, {"K", "O"}, 
	      {"L", "G"}, {"L", "H"}, {"L", "P"}, {"M", "I"}, {"M", "N"}, {"N", "K"}, {"N", "M"}, 
	      {"N", "I"}, {"O", "K"}, {"P", "L"}
	    };
	    return graphFromEdgelist(edges, true);
	  }
  
  //creates graph2 and returns edgelist
  public static Graph<String,Integer> Graph2() {
	    String[][] edges = {
	    		{"V0", "V1", "2"},
	    		{"V0", "V3", "1"},
	    		{"V1", "V3", "3"},
	    		{"V1", "V4", "10"},
	    		{"V2", "V0", "4"},
	    		{"V2", "V5", "5"},
	    		{"V3", "V2", "2"},
	    		{"V3", "V4", "4"},
	    		{"V3", "V5", "8"},
	    		{"V3", "V6", "4"},
	    		{"V4", "V6", "6"},
	    		{"V6", "V5", "1"}
	    };
	    return graphFromEdgelist(edges, true);
	  }
  
  

  public static void main(String[] args) {
  
	  //graph objects
	  Graph<String, Integer> g0 = Graph0();
	  Graph<String, Integer> g1 = Graph1();
	  Graph<String, Integer> g2 = Graph2();
	  
	//print graph0
	System.out.println("Graph 0");
	System.out.println(g0);
	
	//print graph1
	System.out.println("Graph 1");
	System.out.println(g1);
	
	//print graph2
	System.out.println("Graph 2");
	System.out.println(g2);
	
	//DFS for graph1
	System.out.println("DFS Traversal for Graph 1");
	//TODO - determine how to access refs to vertices
	
  }

}
