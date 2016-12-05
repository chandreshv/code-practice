package chandresh.practice.programs.ds.tree;

class RedBlackTree<T extends Comparable<T>>{
	private Node root;
	private static final boolean BLACK=false;
	private static final boolean RED=true;
	
	private class Node{
		private T data;
		private Node left,right;
		private boolean color;
		Node(T data, boolean color){
			this.data = data;
			this.color = color;
		}
	}
	
	public Node insert(T data){
		if(data==null)
			return null;
		if(this.root==null)
			this.root = new Node(data,BLACK);
		else
			this.root = insert(this.root,data);
		
		return this.root;
	}
	private Node insert(Node x, T data) { // 20, 10
		if(x==null) 
			return new Node(data,RED); // 10,red
		
		int cmp = data.compareTo((T) x.data); // 10 compare 20 -1
		
		if(cmp<0)
			x.left = insert(x.left,data); // null, 10
		else if(cmp>0)
			x.right = insert(x.right,data);
		else
			x.data = data;
		
		if(!isRed(x.left) && isRed(x.right))
			x= rotateLeft(x);
		if(isRed(x.left) && isRed(x.left.left))
			x = rotateRight(x);
		if(isRed(x.left) && isRed(x.right))
			flipColor(x);
			
		return x;
	}
	
	private boolean isRed(Node n){
		if(n==null)
			return false;
		
		if(n.color==RED)
			return true;
		
		return false;
	} 
	
	private Node rotateRight(Node x){
		Node temp = x;
		x = x.left;
		temp.left = x.right;
		x.right = temp;
		x.right.color = RED;
		
		return x;
	}
	
	private RedBlackTree<T>.Node rotateLeft(Node x){
		Node temp = x;
		x = x.right;
		temp.right = x.left;
		x.left = temp;
		x.left.color = BLACK;
		
		return x;
	}
	
	private void flipColor(Node x){
		x.left.color = BLACK;
		x.right.color = BLACK;
		x.color = RED;
	}
	
	public void display(){
		if(this.root==null)
			System.out.println("No elements to display");
		
		this.inOrder(this.root);
		System.out.println();
	}

	private void inOrder(RedBlackTree<T>.Node node) {
		if(node==null)
			return;
		
		inOrder(node.left);
		System.out.print(node.data.toString()+" ");
		inOrder(node.right);
	}
	
}

public class RedBlackTreeTest {

	public static void main(String[] args){
		RedBlackTree<Integer> rbt = new RedBlackTree<Integer>();
		rbt.insert(36);
		rbt.insert(20);
		rbt.insert(10);
		rbt.insert(25);
		rbt.insert(60);
		rbt.insert(50);
		rbt.insert(45);
		rbt.insert(55);
		rbt.insert(70);
		rbt.insert(53);
		rbt.insert(54);
		rbt.display();
	}
}
