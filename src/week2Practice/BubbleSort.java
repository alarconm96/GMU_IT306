package week2Practice;

public class BubbleSort {
	
	public static int[] bubble(int[] arr) {
		int temp = 0;
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-1-i; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		
		return arr;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] newArr = {42,35,12,77,5,101};
		
		//bubble sort method
		String output = "";
		newArr = bubble(newArr);
		
		for (int i : newArr) {
			output+= i+" ";
		}
		
		System.out.println(output);
	}

}
