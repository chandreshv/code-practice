package chandresh.practice.programs.ds.queue;

class Queue<T> {

	private Node head;
	private Node tail;

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
			return;
		}
		this.tail.next = n;
		this.tail = n;
	}
	
	public T deque(){
		if(this.head==null)
			return null;
		
		T result = this.head.data;
		this.head = this.head.next;
		return result;
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

public class QueueTest {
	
	public static void main(String[] args){
		Queue<Integer> q1 = new Queue<Integer>();
		q1.enque(1);
		q1.enque(2);
		q1.enque(3);
		q1.enque(4);
		q1.enque(5);
		q1.enque(6);
		q1.enque(7);
		q1.enque(8);
		q1.enque(9);
		
		q1.display();
		q1.deque();
		q1.display();
	}

}
