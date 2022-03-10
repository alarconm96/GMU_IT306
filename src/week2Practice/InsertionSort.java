package week2Practice;

public class InsertionSort {

	private static int[] insertionSort(int[] arr) {
		//TODO - insertion sort practice
		for (int i = 1; i < arr.length; i++) {
			int j = i;
			while(j > 0 && arr[j-1] > arr[j]) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {7,9,1,10,14,5,3};
		for (int i : insertionSort(data)) {
			System.out.print(i + " ");
		}
	}

}
