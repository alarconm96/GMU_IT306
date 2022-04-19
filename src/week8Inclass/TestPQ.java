package week8Inclass;

public class TestPQ {

	public static void main (String[] args) {
		   
	      CharList myPQ = new CharList();
	      
	      myPQ.insert(1,'A');
	      System.out.println(myPQ);
	      
	      myPQ.insert(7,'C');
	      System.out.println(myPQ);
	      
	      myPQ.insert(3,'B');
	      System.out.println(myPQ);
	      
	      System.out.println(myPQ.min());
	      System.out.println(myPQ.removeMin());
	      
	      myPQ.insert(9,'D');
	      System.out.println(myPQ);
	      
	      System.out.println(myPQ.removeMin());
	      System.out.println(myPQ.removeMin());
	      System.out.println(myPQ.removeMin());
	      System.out.println(myPQ.removeMin());
	      
	      System.out.println(myPQ);
	      System.out.println(myPQ.isEmpty());
	      
	   }

}
