package week2Practice;

public class SelectionSort {
	public static int[] selection(int[] arr) {
		//TODO figure out selection sort algorithm
		for (int i = 0; i < arr.length-1; i++) {
			int min = arr[i];
			int index = i;
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] < min) {
					min = arr[j];
					index = j;
				}
			}
			if(index != i) {
				int temp = arr[i];
				arr[i] = min;
				arr[index] = temp;
				System.out.println("swapped");
			}
			
		}
		return arr;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {7, 10, 4, 8, 5, 1};
		
		selection(arr);
		
		//print array
		String output = "";		
		for (int i : arr) {
			output+= i + " ";
		}
		System.out.println(output);
	}

}
