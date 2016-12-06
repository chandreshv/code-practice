package chandresh.practice.programs.ds.queue;

/**
 * @author CHANDREV
 * QUEUE WITH MAX
 * How would you implement a queue so that any series of m combined
		enqueue, dequeue, and max operations can be done in 0{m) time?
 * @param <T>
 */
class QueueWithMax<T extends Comparable<T>>{
	private Node head;
	private Node tail;
	private Stack<T> stack;
	public QueueWithMax(){
		stack = new Stack<T>();
	}

	class Node {
		private T data;
		private Node next;

		Node(T data) {
			this.data = data;
		}
	}

	public void enque(T data) {
		if (data == null)
			return;

		Node n = new Node(data);

		if (this.head == null) {
			this.head = n;
			this.tail = n;
			stack.push(data);
			return;
		}
		
		this.tail.next = n;
		this.tail = n;
		if(data.compareTo(this.stack.peek())>0){
			this.stack.push(data);
		}
	}
	
	public T deque(){
		if(this.head==null)
			return null;
		
		T result = this.head.data;
		this.head = this.head.next;
		if(result.compareTo(this.stack.peek())==0){
			this.stack.pop();
		}
		return result;
	}
	
	public T max(){
		return this.stack.peek();
	}
	
	public void display(){
		Node temp = this.head;
		
		while(temp!=null){
			System.out.print(temp.data + "  ");
			temp = temp.next;
		}
		
		System.out.println();
			
	}
}

class Stack<T extends Comparable<T>>{
	private StackNode head;
	class StackNode{
		private T data;
		private StackNode next;
		StackNode(T data){
			this.data = data;
		}
	}
	
	public T peek(){
		if(this.head==null)
			return null;
		
		return this.head.data;
	}
	
	public void push(T data){
		StackNode newNode = new StackNode(data);
		if(this.head == null)
				this.head = newNode;
		
		newNode.next = this.head;
		this.head = newNode;
	}
	
	public T pop(){
		if(this.head==null)
			return null;
		
		StackNode result = this.head;
		this.head = this.head.next;
		return result.data;
	}
}

public class QueueWithMaxTest {
	public static void main(String[] args){
		QueueWithMax<Integer> q1 = new QueueWithMax<Integer>();
		q1.enque(1);
		q1.enque(2);
		q1.enque(3);
		q1.enque(4);
		q1.enque(15);
		q1.enque(6);
		q1.enque(7);
		q1.enque(8);
		q1.enque(9);
		
		q1.display();
		q1.deque();
		q1.display();
		System.out.println(q1.max());
	}
}
