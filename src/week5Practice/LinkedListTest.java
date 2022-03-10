package week5Practice;

public class LinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
		list.addFirst(7);
		list.addFirst(1);
		list.addLast(99);
		
		System.out.println(list.isEmpty());
		System.out.println(list.size());
	}

}
