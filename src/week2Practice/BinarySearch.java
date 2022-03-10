package week2Practice;

public class BinarySearch {
	public static int binary(int[] arr, int t) {
		//TODO - binary search
		int min = 0;
		int max = arr.length-1;
		//while
		while(min <= max) {
			int curr = (min + max) / 2;
			if (arr[curr] == t) {
				return curr;
			}else if (arr[curr] > t) {
				max = curr - 1;
				curr = (min + curr) / 2;
			}else if (arr[curr] < t) {
				min = curr + 1;
				curr = (curr + max) / 2;
			}
		}
		System.out.println("finished");
		return -1;
	}
	
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		
		System.out.println(binary(arr, arr.length/2));
	}

}
