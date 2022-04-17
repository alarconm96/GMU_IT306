/* Marco Alarcon
 * IT 306-002
 * April 6, 2022
 * Assignment 5
 * */
package assignment5;
public class BinaryHeap{
	int[] arr;
	int size;
	int cap;
	
	public BinaryHeap() {
		this.size = 0;
		this.cap = 3;
		this.arr = new int[cap];
	}
	
	//insert k at next available spot
	public void insert(int k){
		if (this.size == this.cap) {
			extend();
		}
		this.arr[size] = k;
		upheap();
		size++;
	}
	
	//remove and return min key; downheaps after fetching
	public int removeMin(){
		size--;
		int min = this.arr[0];
		this.arr[0] = this.arr[size];
		this.arr[size] = 0;
		downheap();
		return min;
	}
	
	public void upheap(){
		int z = size;
		int curr = this.arr[z];
		int parent = this.arr[(z - 1) / 2];
		while (curr < parent) {
			this.arr[z] = parent;
			this.arr[(z-1)/2] = curr;
			z = (z-1)/2;
			if (z == 0) {
				break;
			}
			curr = this.arr[z];
			parent = this.arr[(z-1)/2];
		}
	}
	
	public void downheap(){
		//TODO - finish downheap
		int p = 0;
		int left = (2*p)+1;
		while(left <= size) {
			int min = left;
			int right = left + 1;
			if (right <= size) {
				if (this.arr[right] < this.arr[left]) {
					min++;
				}
			}
			if (this.arr[p] > this.arr[min]) {
				int tmp = this.arr[p];
				this.arr[p] = this.arr[min];
				this.arr[min] = tmp;
				p = min;
				left = (2*p)+1;
			}else {
				break;
			}
		}
	}
	
	//returns sorted heap by calling removeMin() until empty
	public void heapSort(){
		//TODO - finish heapsort
		while (size != 0) {
			int num = removeMin();
			if (num != 0) {
				System.out.printf("%d ", num);
			}
		}
	}
	
	
	private void extend() {
		cap = (this.cap * 2) + 1;
		int[] newArr = new int[cap];
		for (int i = 0; i < this.arr.length; i++) {
			newArr[i] = this.arr[i];
		}
		this.arr = newArr;
	}
	
	
	public int findMin() {
		return this.arr[0];
	}
	public int findMax() {
		int max = this.arr[cap/2];
		for (int i = 1 + cap/2; i < cap; i++) {
			if (this.arr[i] == 0) {
				break;
			}
			max = max < this.arr[i] ? this.arr[i] : max;
		}
		return max;
	}
	
	
	public void displayInOrder() {
		displayInOrder(0);
		System.out.println("");
	}
	
	private void displayInOrder(int i) {
		if (i < (cap/2)) {
			displayInOrder((2*i)+1);
		}
		System.out.printf(" %d ", this.arr[i]);
		if (i < (cap/2)) {
			displayInOrder((2*i)+2);
		}
	}
	
	public int size() {return this.size;}
}