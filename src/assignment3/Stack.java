/*
 * Marco Alarcon
 * IT 306-002
 * March 2, 2022
 * Assignment 3
 * */

//pacakge/folder declaration
package assignment3;

public class Stack<E> implements Stackable<E>{
	//create list object for stack class
	private List<E> list = new List<>();
	public Stack() {}
	
	//stack methods
	public void push(E data) {list.addToHead(data);}
	public E pop() {return list.remove();}
	public E top() {return list.first();}
	public int size() {return list.size();}
	public boolean isEmpty() {return list.isEmpty();}
	
	//postfix method
	//accepts String postfix expression and returns double answer, using Stack for calculations
	public double postFix(String exp){
		Stack<Double> tmpStack = new Stack<>();
		//tokenize expression with spaces used as delimiters
		String[] tokens = exp.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			//if token element is num, add to stack, else chek if operator and calculate
			//throws exception if anything other than number or operator is in expression
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
	public String toString() {return list.toString();}
}
