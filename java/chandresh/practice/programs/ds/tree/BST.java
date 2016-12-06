package chandresh.practice.programs.ds.tree;

public class BST<T extends Comparable<T>> {
	private Node root;
	
	
	class Node{
		private T data;
		private Node left,right;
		private Node parent;
		private int count;
		
		Node(T data){
			this.data = data;
		}
		
		public T getData(){
			return this.data;
		}
	}
	//10-2,8,12
	/**
	 * @param data
	 * Insert elements into BST
	 */
	public void insert(T data){
		if(data==null){
			System.out.println("No data to insert");
			return;
		}
		Node newNode = new Node(data);
		newNode.count=1;
		if(this.root==null){
			this.root=newNode;
		}else{
			Node parent = null;
			Node current = this.root;
			
			while(current!=null){
				parent = current;
				current.count = 2+size(current.left)+size(current.right);
				if(newNode.data.compareTo(current.data)<0){
					current = current.left;
				}else{
					current  = current.right;
				}
			}
			
			newNode.parent = parent;
			if(parent.data.compareTo(newNode.data)>0)
				parent.left = newNode;
			else
				parent.right = newNode;
		}
	}
	
	/**
	 * @param x
	 * @return size of any node i.e number of nodes under it 1
	 */
	private int size(Node x) {
		if(x==null)
			return 0;
		else
			return x.count;
	}

	/**
	 * @param data
	 * @return The node corresponding to the data.
	 * Null otherwise
	 */
	public Node search(T data){
		Node current = this.root;
		
		while(current!=null){
			if(current.data.compareTo(data)==0){
				return current;
			}else if(current.data.compareTo(data)<0){
				current=current.right;
			}else{
				current = current.left;
			}
		}
		return null;
	}
	
	private Node findSuccessor(Node node){
		Node current = node;
		if ((current = current.right) != null) {
			while (current.left != null) {
				current = current.left;
			}
			
		}else{
			Node temp  = node;
			current = temp.parent;
			while(current!=null && temp==current.right){
				temp = temp.parent;
				current = current.parent;
			}
		}
		return current;
	}
	public T findSuccessor(T data){
		Node node = search(data);
		return node==null?null:findSuccessor(node).data;
	}
	
	public void delete (T data){
		if(data==null)
			return;
		delete(this.root,data);
	}
	
	private Node delete(Node x, T data){
		
		if(x==null)
			return null;

		int cmp = data.compareTo((T) x.data);
		if(cmp<0)
			x.left = delete(x.left,data);
		else if(cmp>0)
			x.right = delete(x.right,data);
		else{
			if(x.right==null)
				return x.left;
			if(x.left==null)
				return x.right;
			
			Node temp = x;
			x = min(x.right);
			x.right = deleteMin(temp.right);
			x.left = temp.left;
		}
		
		x.count = 1+size(x.left)+size(x.right);
		return x;
	}
	
	public Node min(Node x){
		if(x==null)
			return null;
		
		if(x.left==null)
			return x;
		
		return min(x.left);
	}
	
	public Node max(Node x){
		if(x==null)
			return null;
		
		if(x.right==null)
			return x;
		
		return min(x.right);
	}
	
	public Node deleteMin(Node x){
		if(x.left==null)
			return x.right;
		
		x.left = deleteMin(x.left);
		x.count = 1+size(x.left)+size(x.right);
		
		return x;
	}
	
	public void display(){
		if(this.root==null)
			System.out.println("No elements to display");
		
		this.inOrder(this.root);
		System.out.println();
	}

	private void inOrder(BST<T>.Node node) {
		if(node==null)
			return;
		
		inOrder(node.left);
		System.out.print(node.data.toString()+" ");
		inOrder(node.right);
	}
	
	public int rank(T data){
		if(data==null){
			return -1;
		}
		
		return rank(data,root);
		
	}
	
	private int rank(T data, BST<T>.Node x) {
		if(x==null)
			return -1;
		int cmp = data.compareTo((T) x.data);
		if(cmp==0)
			return 1+size(x.left);
		else if(cmp>0)
			return 1 + size(x.left) + rank(data,x.right);
		else
			return rank(data,x.left);
	}

	
	public int rangeCount(T lo, T hi){
		if(lo==null || hi==null || this.root==null){
			return 0;
		}
		
		return rangeCount(this.root, lo, hi);
	}

	/**
	 * @param n
	 * @param lo
	 * @param hi
	 * @return return the number of nodes falling under the provided range (boundaries included)
	 */
	private int rangeCount(Node n, T lo, T hi){
		if(n==null)
			return 0;
		int temp=0,leftCount=0,rightCount=0;
		if(min(n).data.compareTo(lo)>=0 && max(n).data.compareTo(hi)<=0){
			return n.count;
		}
		if(n.data.compareTo(lo)>=0 && n.data.compareTo(hi)<=0)
			temp++;
		if(n.data.compareTo(lo)>=0)		
			leftCount = rangeCount(n.left, lo, hi);
		if(n.data.compareTo(hi)<=0)
			rightCount=rangeCount(n.right, lo, hi);
		
		return temp+leftCount+rightCount;
	}

	public static void main(String args[]){
		BST<Integer> bst = new BST<Integer>();
		bst.insert(36);
		bst.insert(20);
		bst.insert(10);
		bst.insert(25);
		bst.insert(60);
		bst.insert(50);
		bst.insert(45);
		bst.insert(55);
		bst.insert(70);
		bst.insert(53);
		bst.insert(54);
		bst.display();
		bst.delete(50);
		
		bst.deleteMin(bst.root);
		bst.display();
		System.out.println(bst.min(bst.root).data);
		System.out.println(bst.rank(70));
		System.out.println(bst.rangeCount(25, 55));
		System.out.println(bst.rangeCount(10, 37));
		System.out.println(bst.rangeCount(5, 80));
		System.out.println(bst.root.count);
	}
}
