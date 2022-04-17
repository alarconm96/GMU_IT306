/* Marco Alarcon
 * IT 306-002
 * April 6, 2022
 * Assignment 5
 * */
package assignment5;
public class BinaryTree {
	//instance vars
	Node root;
    int size;
 
    // Constructor
    BinaryTree(){
         root = null;
         size = 0;
    }

    
    // find and return the minimum key of the tree
    public int findMin(){
    	Node node = root;
        if (node != null) {
			while (node.hasLeft()) {
				node = node.left;
			}
		}else {
			throw new IllegalStateException("Binary Tree is empty");
		}
    	return node.key;
    }
    
    //find min from starting node (subtree)
    public int findMin(Node n) {
    	Node node = n;
        if (node != null) {
			while (node.hasLeft()) {
				node = node.left;
			}
		}else {
			throw new IllegalStateException("Subtree is empty");
		}
    	return node.key;
    }
    
  //find and return min NODE
    public Node findMinNode() {
    	Node node = root;
        if (node != null) {
			while (node.hasLeft()) {
				node = node.left;
			}
		}else {
			throw new IllegalStateException("Subtree is empty");
		}
    	return node;
    }
    
  //find and return min NODE from starting node (subtree)
    public Node findMinNode(Node n) {
    	Node node = n;
        if (node != null) {
			while (node.hasLeft()) {
				node = node.left;
			}
		}else {
			throw new IllegalStateException("Subtree is empty");
		}
    	return node;
    }
    
    public int leftChild(Node p){
      return p.left.key;
    }
    
    public int rightChild(Node p){
      return p.right.key;
    }
    
    
    // find and return the maximum key of the tree
    public int findMax (){
        Node node = root;
        if (node != null) {
			while (node.hasRight()) {
				node = node.right;
			}
		}else {
			throw new IllegalStateException("Binary Tree is empty");
		}
    	return node.key;
    }
    // Tests if the list is empty. return true if Tree is empty; else false 
    public boolean isEmpty(){
        return size == 0;
    }
    //Returns the number of elements in the tree
    public int size(){
        return this.size;
    } 
    
    // print tree nodes in an inorder traversal 
    public void displayInOrder() {
    	System.out.println("\nInOrder Traversal");
    	System.out.println("------------------------------");
    	displayInOrder(root);
    }
    
    //recursive inOrder
    private void displayInOrder(Node node){
        if (node != null) {
			displayInOrder(node.left);
			System.out.println(node.key);
			displayInOrder(node.right);
		}
    }
    
    // print tree nodes in an preorder traversal 
    public void displayPreOrder(){
    	System.out.println("\nPreOrder Traversal");
    	System.out.println("------------------------------");
    	displayPreOrder(root);
    }
    
    //recursive preOrder
    private void displayPreOrder(Node node) {
    	if (node != null) {
    		System.out.println(node.key);
        	displayPreOrder(node.left);
        	displayPreOrder(node.right);
		}
    }
    
    // print tree nodes in an postorder traversal 
    public void displayPostOrder(){
    	System.out.println("\nPostOrder Traversal");
    	System.out.println("------------------------------");
    	displayPostOrder(root);
    }
    
    //recursive postOrder
    private void displayPostOrder(Node node) {
    	if (node != null) {
    		displayPostOrder(node.left);
        	displayPostOrder(node.right);
        	System.out.println(node.key);
		}
    }
    
    
    protected class Node {

        protected Node left;
        protected Node right;
        protected int key;
        
        protected Node(int data) {
            this.key = data;
            left = right = null;
        }
        
        protected int getKey() {
        	return this.key;
        }
        protected Node getLeft() {
        	return this.left;
        }
        protected Node getRight() {
        	return this.right;
        }
        protected void setKey(int k) {
        	this.key = k;
        }
        protected void setLeft(int k) {
        	Node node = new Node(k);
        	this.left = node;
        }
        protected void setLeft(Node node) {
        	this.left = node;
        }
        protected void setRight(int k) {
        	Node node = new Node(k);
        	this.right = node;
        }
        protected void setRight(Node node) {
        	this.right = node;
        }
        protected void removeLeft() {
        	this.left = null;
        }
        protected void removeRight() {
        	this.right = null;
        }
        
        //check if node has children
        protected boolean hasChildren() {
        	if (this.hasLeft() || this.hasRight()) {
				return true;
			}else {
				return false;
			}
        }
        
        //check if node has left child
        protected boolean hasLeft() {
        	if (this.left != null) {
    			return true;
    		}else {
    			return false;
    		}
        }
        
        //check if node has right child
        protected boolean hasRight() {
        	if (this.right != null) {
    			return true;
    		}else {
    			return false;
    		}
        }
    }
 
}
