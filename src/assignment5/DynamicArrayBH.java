package assignment5;

public class DynamicArrayBH {
	private int size;
	private int cap;
	int[] arr;
	
	public DynamicArrayBH() {
		this.cap = 3;
		this.arr = new int[cap];
		this.size = 0;
	}
	
	public void extend() {
		int[] newArr = new int[(cap*2)+1];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		this.arr = newArr;
	}
}
