/*
 * Marco Alarcon
 * IT 306 - 002
 * Assignment 2
 * Implementation class that creates random arrays of various sizes
 * 	and queries using different criteria in order to test the efficiency
 * 	of different sorting and searching algorithms.
 * */
package assignment2;

import java.util.Random;

public class TestSearchAndSort {

    public static void main (String[] args) {
    	/* arrays of 3 different sizes created below using Random() method
    	 * 
    	 * SMALL = 100 elements
    	 * MEDIUM = 1000 elements
    	 * LARGE = 10,000 elements
    	 * 
    	 * */
    	
    	// create SMALL array and populate and array with random numbers
        int sizeS = 100;
        int[] testDataS = new int[sizeS];
        Random rndm = new Random(); // use a Random object to generate data
        for (int idx = 0; idx < sizeS; idx++) {
            testDataS[idx] = rndm.nextInt(100); // Random integers between 0 & 1000
        }
    	
        // create MEDIUM array and populate and array with random numbers
        int sizeM = 1000;
        int[] testDataM = new int[sizeM];
        rndm = new Random(); // use a Random object to generate data
        for (int idx = 0; idx < sizeM; idx++) {
            testDataM[idx] = rndm.nextInt(1000); // Random integers between 0 & 1000
        }
        
        // create LARGE array and populate and array with random numbers
        int sizeL = 10000;
        int[] testDataL = new int[sizeL];
        rndm = new Random(); // use a Random object to generate data
        for (int idx = 0; idx < sizeL; idx++) {
            testDataL[idx] = rndm.nextInt(10000); // Random integers between 0 & 1000
        }
        

        
        /*
         * create copies of each sized array to be used by bubble, selection, and insertion sort
         * in order to independently test each sorting algorithm's efficiency.
         * 
         * */
        
        // BUBBLE SORT - O(n^2)
        //create copy of original SMALL testData array for bubble sort
        int[] bubbleArrayS = new int[sizeS];
        for (int i = 0; i < testDataS.length; i++) {
			bubbleArrayS[i] = testDataS[i];
		}
        // Sort the array with bubble sort and print results
        SortReturn srBubbleS = Sort.bubble(bubbleArrayS);
        System.out.println(srBubbleS.toString());
        
        //create copy of original MEDIUM testData array for bubble sort
        int[] bubbleArrayM = new int[sizeM];
        for (int i = 0; i < testDataM.length; i++) {
			bubbleArrayM[i] = testDataM[i];
		}
        // Sort the array with bubble sort and print results
        SortReturn srBubbleM = Sort.bubble(bubbleArrayM);
        System.out.println(srBubbleM.toString());
        
        //create copy of original LARGE testData array for bubble sort
        int[] bubbleArrayL = new int[sizeL];
        for (int i = 0; i < testDataL.length; i++) {
			bubbleArrayL[i] = testDataL[i];
		}
        // Sort the array with bubble sort and print results
        SortReturn srBubbleL = Sort.bubble(bubbleArrayL);
        System.out.println(srBubbleL.toString());
        
        
        //SELECTION SORT - O(n^2)
        //create copy of original SMALL testData array for selection sort
        int[] selectionArrayS = new int[sizeS];
        for (int i = 0; i < testDataS.length; i++) {
			selectionArrayS[i] = testDataS[i];
		}
        //Sort array with selection sort and print results
        SortReturn srSelectionS = Sort.selection(selectionArrayS);
        System.out.println(srSelectionS.toString());
        
        //create copy of original MEDIUM testData array for selection sort
        int[] selectionArrayM = new int[sizeM];
        for (int i = 0; i < testDataM.length; i++) {
			selectionArrayM[i] = testDataM[i];
		}
        //Sort array with selection sort and print results
        SortReturn srSelectionM = Sort.selection(selectionArrayM);
        System.out.println(srSelectionM.toString());
        
        //create copy of original LARGE testData array for selection sort
        int[] selectionArrayL = new int[sizeL];
        for (int i = 0; i < testDataL.length; i++) {
			selectionArrayL[i] = testDataL[i];
		}
        //Sort array with selection sort and print results
        SortReturn srSelectionL = Sort.selection(selectionArrayL);
        System.out.println(srSelectionL.toString());
        
        
        //INSERTION SORT - O(n^2)
        /*
         * NOTE - I did not make copies of the following array for insertion since testData arrays would
         * need to be sorted anyways  in order for binary search to work in the searching tests.
         * As a result, both linear and binary searches use testData arrays in order to use the same
         * data for testing purposes.
         * 
         * */
        //create copy of original SMALL testData array for insertion sort
        int[] insertionArrayS = new int[sizeS];
        for (int i = 0; i < testDataS.length; i++) {
			insertionArrayS[i] = testDataS[i];
		}
        // Sort the array with insertion sort and print results
        SortReturn srInsertionS = Sort.insertion(testDataS);
        System.out.println(srInsertionS.toString());
        
        //create copy of original MEDIUM testData array for insertion sort
        int[] insertionArrayM = new int[sizeM];
        for (int i = 0; i < testDataM.length; i++) {
			insertionArrayM[i] = testDataM[i];
		}
        // Sort the array with insertion sort and print results
        SortReturn srInsertionM = Sort.insertion(testDataM);
        System.out.println(srInsertionM.toString());
        
        //create copy of original LARGE testData array for insertion sort
        int[] insertionArrayL = new int[sizeL];
        for (int i = 0; i < testDataL.length; i++) {
			insertionArrayL[i] = testDataL[i];
		}
        // Sort the array with insertion sort and print results
        SortReturn srInsertionL = Sort.insertion(testDataL);
        System.out.println(srInsertionL.toString());

        
        
        // Searches -- pull an element out of the array (e.g. testData[position])
        // so that it's known to exist in the array
        
        
        // LINEAR - O(n)
        // Linear Searches SMALL
        // Search for an element that is known to be in the 10% position
        SearchReturn srchLinearS10 = Search.linear(testDataS,testDataS[sizeS/10]);
        System.out.println(srchLinearS10.toString()); // display the performance info

        // Search for an element that is known to be in the 50% position
        SearchReturn srchLinearS50 = Search.linear(testDataS,testDataS[sizeS/2]);
        System.out.println(srchLinearS50.toString()); // display the performance info
        
        // Search for an element that is known to be in the 90% position
        SearchReturn srchLinearS90 = Search.linear(testDataS,testDataS[(int)(sizeS*0.9)]);
        System.out.println(srchLinearS90.toString()); // display the performance info

        // Search for an element that is known not to exist (
        SearchReturn srchLinearSNone = Search.linear(testDataS,9999);
        System.out.println(srchLinearSNone.toString()); // display the performance info
        
        
        // Linear Searches MEDIUM
        // Search for an element that is known to be in the 10% position
        SearchReturn srchLinearM10 = Search.linear(testDataM,testDataM[sizeM/10]);
        System.out.println(srchLinearM10.toString()); // display the performance info

        // Search for an element that is known to be in the 50% position
        SearchReturn srchLinearM50 = Search.linear(testDataM,testDataM[sizeM/2]);
        System.out.println(srchLinearM50.toString()); // display the performance info
        
        // Search for an element that is known to be in the 90% position
        SearchReturn srchLinearM90 = Search.linear(testDataM,testDataM[(int)(sizeM*0.9)]);
        System.out.println(srchLinearM90.toString()); // display the performance info

        // Search for an element that is known not to exist (
        SearchReturn srchLinearMNone = Search.linear(testDataM,9999);
        System.out.println(srchLinearMNone.toString()); // display the performance info
        
        
        // Linear Searches LARGE
        // Search for an element that is known to be in the 10% position
        SearchReturn srchLinearL10 = Search.linear(testDataL,testDataL[sizeL/10]);
        System.out.println(srchLinearL10.toString()); // display the performance info

        // Search for an element that is known to be in the 50% position
        SearchReturn srchLinearL50 = Search.linear(testDataL,testDataL[sizeL/2]);
        System.out.println(srchLinearL50.toString()); // display the performance info
        
        // Search for an element that is known to be in the 90% position
        SearchReturn srchLinearL90 = Search.linear(testDataL,testDataL[(int)(sizeL*0.9)]);
        System.out.println(srchLinearL90.toString()); // display the performance info

        // Search for an element that is known not to exist (
        SearchReturn srchLinearLNone = Search.linear(testDataL,9999);
        System.out.println(srchLinearLNone.toString()); // display the performance info
        
        
        
        // BINARY - O(log n)
        // Binary Searches SMALL
        // Search for an element that is known to be in the 10% position
        SearchReturn srchBinaryS10 = Search.binary(testDataS,testDataS[sizeS/10]);
        System.out.println(srchBinaryS10.toString()); // display the performance info
        
        // Search for an element that is known to be in the 50% position
        SearchReturn srchBinaryS50 = Search.binary(testDataS,testDataS[sizeS/2]);
        System.out.println(srchBinaryS50.toString()); // display the performance info
        
        // Search for an element that is known to be in the 90% position
        SearchReturn srchBinaryS90 = Search.binary(testDataS,testDataS[(int)(sizeS*0.9)]);
        System.out.println(srchBinaryS90.toString()); // display the performance info
        
        // Search for an element that is known not to exist
        SearchReturn srchBinarySNone = Search.binary(testDataS,9999);
        System.out.println(srchBinarySNone.toString()); // display the performance info
        
        
        // Binary Searches MEDIUM
        // Search for an element that is known to be in the 10% position
        SearchReturn srchBinaryM10 = Search.binary(testDataM,testDataM[sizeM/10]);
        System.out.println(srchBinaryM10.toString()); // display the performance info
        
        // Search for an element that is known to be in the 50% position
        SearchReturn srchBinaryM50 = Search.binary(testDataM,testDataM[sizeM/2]);
        System.out.println(srchBinaryM50.toString()); // display the performance info
        
        // Search for an element that is known to be in the 90% position
        SearchReturn srchBinaryM90 = Search.binary(testDataM,testDataM[(int)(sizeM*0.9)]);
        System.out.println(srchBinaryM90.toString()); // display the performance info
        
        // Search for an element that is known not to exist
        SearchReturn srchBinaryMNone = Search.binary(testDataM,9999);
        System.out.println(srchBinaryMNone.toString()); // display the performance info
        
        
        // Binary Searches LARGE
        // Search for an element that is known to be in the 10% position
        SearchReturn srchBinaryL10 = Search.binary(testDataL,testDataL[sizeL/10]);
        System.out.println(srchBinaryL10.toString()); // display the performance info
        
        // Search for an element that is known to be in the 50% position
        SearchReturn srchBinaryL50 = Search.binary(testDataL,testDataL[sizeL/2]);
        System.out.println(srchBinaryL50.toString()); // display the performance info
        
        // Search for an element that is known to be in the 90% position
        SearchReturn srchBinaryL90 = Search.binary(testDataL,testDataL[(int)(sizeL*0.9)]);
        System.out.println(srchBinaryL90.toString()); // display the performance info
        
        // Search for an element that is known not to exist
        SearchReturn srchBinaryLNone = Search.binary(testDataL,9999);
        System.out.println(srchBinaryLNone.toString()); // display the performance info
        
        
        
        // PRINT SORT RUNTIMES
        System.out.println("Formatted runtimes of bubble, selection, and insertion sorting algorithms in seconds");
        System.out.println("Arrays of size 100, 1000, and 10,000");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%14s||%14s||%14s||%14s%n", " ", "Size 100", "Size 1000", "Size 10,000");
        System.out.printf("%14s||%1.11fs||%1.11fs||%1.11fs%n", "Bubble Sort", (double) srBubbleS.getRuntime() * 0.000000001, (double) srBubbleM.getRuntime() * 0.000000001, (double) srBubbleL.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs||%1.11fs%n", "Selection Sort", (double) srSelectionS.getRuntime() * 0.000000001, (double) srSelectionM.getRuntime() * 0.000000001, (double) srSelectionL.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs||%1.11fs%n", "Insertion Sort", (double) srInsertionS.getRuntime() * 0.000000001, (double) srInsertionM.getRuntime() * 0.000000001, (double) srInsertionL.getRuntime() * 0.000000001);
        System.out.println("--------------------------------------------------------------\n");
        
        // PRINT SEARCH RUNTIMES
        System.out.println("Formatted runtimes of linear/binary search algorithms in seconds");
        System.out.println("Search queries of positions at 10%, 50%, 90%, and \"Not found\" used for each array size");
        System.out.println("----------------------------------------------");
        System.out.printf("%14s||%14s||%14s%n", " ", "Linear", "Binary");
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "100 - 10%", srchLinearS10.getRuntime() * 0.000000001, srchBinaryS10.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "100 - 50%", srchLinearS50.getRuntime() * 0.000000001, srchBinaryS50.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "100 - 90%", srchLinearS90.getRuntime() * 0.000000001, srchBinaryS90.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n%n", "Not found", srchLinearSNone.getRuntime() * 0.000000001, srchBinarySNone.getRuntime() * 0.000000001);
        System.out.printf("%14s||%14s||%14s%n", " ", "Linear", "Binary");
        
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "1000 - 10%", srchLinearM10.getRuntime() * 0.000000001, srchBinaryM10.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "1000 - 50%", srchLinearM50.getRuntime() * 0.000000001, srchBinaryM50.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "1000 - 90%", srchLinearM90.getRuntime() * 0.000000001, srchBinaryM90.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n%n", "Not found", srchLinearMNone.getRuntime() * 0.000000001, srchBinaryMNone.getRuntime() * 0.000000001);
        System.out.printf("%14s||%14s||%14s%n", " ", "Linear", "Binary");
        
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "10,000 - 10%", srchLinearL10.getRuntime() * 0.000000001, srchBinaryL10.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "10,000 - 50%", srchLinearL50.getRuntime() * 0.000000001, srchBinaryL50.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "10,000 - 90%", srchLinearL90.getRuntime() * 0.000000001, srchBinaryL90.getRuntime() * 0.000000001);
        System.out.printf("%14s||%1.11fs||%1.11fs%n", "Not found", srchLinearLNone.getRuntime() * 0.000000001, srchBinaryLNone.getRuntime() * 0.000000001);
        System.out.println("----------------------------------------------");
        
    }
    
    
    // this method will display the array contents if you want to view them
    private static void displayArray(int[] testData) {
        for (int theInt: testData) {
            System.out.print(theInt + ",");
        } System.out.println();
    }
}
