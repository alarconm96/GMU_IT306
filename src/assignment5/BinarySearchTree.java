/* Marco Alarcon
 * IT 306-002
 * April 6, 2022
 * Assignment 5
 * */
package assignment5;
public class BinarySearchTree extends BinaryTree{
   // add a node in the BST
   public void add(int k){
       add(k, root);
    }
   //recursive add method
   private int add(int k, Node node) {
	   if (isEmpty()) {
		   Node newNode = new Node(k);
		   root = newNode;
		   size++;
		} else {
			if (k < node.getKey()) {
				//if k is less than
				if (node.getLeft() != null) {
					add(k, node.getLeft());
				}else {
					node.setLeft(k);
					size++;
				}
			}else if (k > node.getKey()) {
				//if k is greater than
				if (node.getRight() != null) {
					add(k, node.getRight());
				} else {
					node.setRight(k);
					size++;
				}
			}else {
				throw new IllegalArgumentException("Cannot add duplicate elements");
			}
		}
	return k;
   }
    
    // delete a node from the BST. Implement all the three cases for deletion. 
    public int remove(int k){
    	//exception if empty tree
    	if (isEmpty()) {
			throw new IllegalStateException("Cannot remove from empty tree");
		}
    	
    	//search for key; exception if not found
    	search(k);
    	remove(k, this.root).getKey();
    	return k;
    }
    
    //recursive remove method
    private Node remove(int k, Node node) {
    	if (node == null) {
			return node;
		}
    	if (k > node.getKey()) {
			node.right = remove(k, node.right);
		}else if (k < node.getKey()) {
			node.left = remove(k, node.left);
		}else {
			if (node.left == null && node.right == null) {
				node = null;
			}else if (node.right != null) {
				node.key = next(node);
				node.right = remove(node.key, node.right);
			}else {
				node.key = pre(node);
				node.left = remove(node.key, node.left);
			}
		}
    	return node;
    }
    
    private int next(Node node) {
    	node = node.right;
    	while (node.left != null) {
			node = node.left;
		}
    	return node.key;
    }
    private int pre(Node node) {
    	node = node.left;
    	while (node.right != null) {
			node = node.right;
		}
    	return node.key;
    }
    
    
    
    // search for a node with a key k. return the key if found; else throw an exeption
    public int search(int k){
    	return search(k, root);
    }
    
    //search for key in node; exception if not found
    private int search(int k, Node node) {
        //key found in current node
    	if (k == node.getKey()) {
            return node.getKey();
        }
    	
    	//recursive call to node's right child
        if (k > node.getKey() && node.hasRight()) {
           return search(k, node.getRight());
        }
        
        //recursive call to node's left child
        if (k < node.getKey() && node.hasLeft()) {
			return search(k, node.getLeft());
		}
        
        //key not found
        throw new IllegalArgumentException("Key not found");
    }
    
}
