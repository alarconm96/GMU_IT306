/*
 * Marco Alarcon
 * IT 306-002
 * Assignment 2
 * Contains linear and binary search algorithms
 * */
package assignment2;

public class Search {

    // LINEAR SEARCH - O(n) 
    public static SearchReturn linear(int[] theArray, int searchValue) {	
        long comparisons = 0; 
        long elements = theArray.length;
        long endTime = 0;

        long startTime  = System.nanoTime(); 
        for (int idx = 0; idx < elements; idx++) {
            comparisons++;
            if (theArray[idx] == searchValue) {
                endTime = System.nanoTime() - startTime;
                return new SearchReturn("Linear Search", comparisons, endTime, elements, idx);
            }
        }
        endTime = System.nanoTime() - startTime; 

        // create return object to pass back all collected information
        return new SearchReturn("Linear Search", comparisons, endTime, elements, -1);
    }
    
    //BINEARY SEARCH - O(log n)
    public static SearchReturn binary(int[] theArray, int searchValue) {	
        long comparisons = 0; 
        long elements = theArray.length;
        long endTime = 0;

        long startTime  = System.nanoTime(); 
        
        int min = 0;
        int max = theArray.length-1;
        while(min <= max) {
        	comparisons++;
        	int curr = (min + max) / 2;
        	if (theArray[curr] == searchValue) {
        		endTime = System.nanoTime() - startTime; 
        		return new SearchReturn("Binary Search", comparisons, endTime, elements, curr);
			}else if (theArray[curr] > searchValue) {
				max = curr - 1;
				curr = (min + curr) / 2;
			}else if (theArray[curr] < searchValue) {
				min = curr + 1;
				curr = (curr + max) / 2;
			}
        }
        endTime = System.nanoTime() - startTime; 

        // create return object to pass back all collected information
        return new SearchReturn("Binary Search", comparisons, endTime, elements, -1);
    }
}
