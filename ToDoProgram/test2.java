import java.util.*;
import java.io.*;


class Node { 
	int data; 
	Node left, right; 

	public Node(int val) { 
		data = val; 
	} 
} 

class BinaryTree{
	/*Root Of the binary tree*/
	Node root;  

	/*Post order traversal*/
	public List<Integer> postorderTraversal(Node root) {
	    List<Integer> result = new ArrayList<>();
	    if (root == null) return result;
	    
	    Stack<Node> s = new Stack<>();
	    Stack<Node> out = new Stack<>();
	    
	    s.push(root);
	    
	    while ( ! s.isEmpty()) {
	        Node currNode = s.pop();
	        if (currNode != null) out.push(currNode);
	        if (currNode.left != null) s.push(currNode.left);
	        if (currNode.right != null) s.push(currNode.right);
	    }
	    
	    while ( ! out.isEmpty()) {
	        Node outNode = out.pop();
	        result.add(outNode.data);
	    }
	    
	    return result;
	}
}

class test2 { 

	public static void main(String[] args) { 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 

		List<Integer> ans_list = tree.postorderTraversal(tree.root); 
		System.out.println("Postorder traversal : " + ans_list); 	
	}
} 






























