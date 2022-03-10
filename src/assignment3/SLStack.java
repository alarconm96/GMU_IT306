/*
 * Marco Alarcon
 * IT 306-002
 * March 2, 2022
 * Assignment 3
 * */

//package/folder declaration
package assignment3;

public class SLStack<E> implements Stackable<E> {
	private SLList<E> sll = new SLList<>();
	
	//stack methods
	public int size() {return sll.size();}
	public boolean isEmpty() {return sll.isEmpty();}
	public E top() {return sll.first();}
	public void push(E data) {sll.addToHead(data);}
	public E pop() {return sll.remove();}
	
	//postfix method
	//see Stack.java for postFix info
	public double postFix(String exp){
		Stack<Double> tmpStack = new Stack<>();
		String[] tokens = exp.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			if (isNum(tokens[i])) {
				tmpStack.push(Double.parseDouble(tokens[i]));
			}else {
				double x = 0;
				double y = 0;
				switch (tokens[i]) {
				case "*":
					x = tmpStack.pop();
					y = tmpStack.pop();
					tmpStack.push(y*x);
					break;
				case "/":
					x = tmpStack.pop();
					y = tmpStack.pop();
					tmpStack.push(y/x);
					break;
				case "+":
					x = tmpStack.pop();
					y = tmpStack.pop();
					tmpStack.push(y+x);
					break;
				case "-":
					x = tmpStack.pop();
					y = tmpStack.pop();
					tmpStack.push(y-x);
					break;
				default:
					throw new IllegalArgumentException("Unexpected value: " + tokens[i]);
				}
			}
			
		}
		push((E) tmpStack.top());
		return tmpStack.pop();
	}
	
	//check if string is num
	private boolean isNum(String s) {
		try {
			Double.parseDouble(s);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	//overridden toString()
	public String toString() {return sll.toString();}
}
