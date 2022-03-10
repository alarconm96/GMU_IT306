/*
 * Marco Alarcon
 * IT 306-002
 * Assignment 2
 * Contains bubble, selection, and insertion sorting algorithms
 * */
package assignment2;

public class Sort {

    //BUBBLE SORT - O(n^2)
    public static SortReturn bubble(int[] data) {		
        long elements = data.length;
        long comparisons = 0; 
        long swaps = 0;       

        boolean sorted = false;
        long startTime = System.nanoTime(); 
        while (!sorted) {
            sorted = true;
            for (int idx = 1; idx < data.length; idx++) {
                comparisons++; 
                if (data[idx] < data[idx-1]) {
                    swaps++; 
                    int tmpData = data[idx-1];
                    data[idx-1] = data[idx];
                    data[idx] = tmpData;
                    sorted = false;
                } 
            } 
        }
        long totalTime = (System.nanoTime() - startTime); 

        // create return object to pass back all collected information
        SortReturn sr = new SortReturn("Bubble Sort",comparisons,swaps,totalTime,elements);
        return sr;
    }

    //SELECTION SORT - O(n^2)
    public static SortReturn selection(int[] data) {		
        long elements = data.length;
        long comparisons = 0; 
        long swaps = 0;       

        long startTime = System.nanoTime(); 
        for (int i = 0; i < data.length - 1; i++) {
            int min = data[i];
            int index = i;
            for(int j = i+1; j < data.length; j++) {
            	comparisons++; 
            	if (data[j] < min) {                		
                    min = data[j];
                    index = j;
                } 
            	if(data[i] > min) {
            		swaps++; 
            		int temp = data[i];
            		data[i] = min;
            		data[index] = temp;
            	}
            }
            
        } 
        long totalTime = (System.nanoTime() - startTime); // capture final processing time

        // create return object to pass back all collected information
        SortReturn sr = new SortReturn("Selection Sort",comparisons,swaps,totalTime,elements);
        return sr;
    }
    
    //INSERTION SORT - O(n^2)
    public static SortReturn insertion(int[] data) {		
        long elements = data.length;
        long comparisons = 0; 
        long swaps = 0;      

        long startTime = System.nanoTime(); 
        for (int i = 1; i < data.length; i++) {
            int j = i;
            while(j > 0 && data[j-1] > data[j]) {
            	comparisons++; 
            	swaps++;
            	int temp = data[j-1];
            	data[j-1] = data[j];
            	data[j] = temp;
            	j--;
            }
            
        } 
        long totalTime = (System.nanoTime() - startTime); // capture final processing time

        // create return object to pass back all collected information
        SortReturn sr = new SortReturn("Insertion Sort",comparisons,swaps,totalTime,elements);
        return sr;
    }
}




