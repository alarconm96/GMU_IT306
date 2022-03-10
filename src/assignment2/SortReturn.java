/*
 * Marco Alarcon
 * IT 306-002
 * Assignment 2
 * SortReturn object that holds stats of sorting algorithms used
 * */
package assignment2;

public class SortReturn {

    private String description;
    private long comparisons = 0;
    private long swaps = 0;
    private long time = 0;
    private long elements = 0;

    public SortReturn (String description, long comparisons, long swaps, long time, long elements) {
        this.description = description;
        this.comparisons = comparisons;
        this.swaps = swaps;
        this.time = time;
        this.elements = elements;
    }

    // NEW - return runtime of SortReturn object
    public long getRuntime() {
    	return this.time;
    }
    
    public String toString() {
        return this.description + ":\n" +
               "Elements: " + this.elements + "\n" +
               "Comparisons: " + this.comparisons + "\n" +
               "Swaps: " + this.swaps + "\n" +
               "Time: " + this.time + "\n";
    }    

}
