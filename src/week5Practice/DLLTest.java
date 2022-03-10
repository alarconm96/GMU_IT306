package week5Practice;

public class DLLTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedList<Integer> newDLL = new DoublyLinkedList<>();
		
		System.out.println(newDLL.isEmpty());
		
		newDLL.addFirst(70);
		
		System.out.println(newDLL.isEmpty());
		
		newDLL.addLast(1000);
		
		System.out.println(newDLL.first());
		
		newDLL.addFirst(5);
		
		System.out.println(newDLL.first());
		System.out.println(newDLL.last());
		
		newDLL.removeLast();
		
		System.out.println(newDLL.last());
	}

}
