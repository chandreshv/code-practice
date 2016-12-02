package chandresh.practice.programs.ds;

class BinaryHeap<T>{
	int heapSize = 0;
	
	private void heapify(Comparable<T>[] inp, int index){
		if(index>=this.heapSize/2)
			return;
		
		int left = index*2 +1;
		int right = index*2 +2;
		if(left>this.heapSize && right>this.heapSize)
			return;
		
		int largest = index;
		
		if(left<this.heapSize && inp[index].compareTo((T) inp[left])<0)
			largest=left;
		if(right<this.heapSize && inp[largest].compareTo((T) inp[right])<0)
			largest=right;
		
		if(largest!=index){
			exchange(index, largest, inp);
			heapify(inp, largest);
		}else 
			return;
	}
	
	public void display(Comparable<T>[] inp){
		for(Comparable<T> each:inp){
			System.out.print(each.toString() + " ");
		}
		System.out.println();
	}
	
	private void exchange(int ind1, int ind2, Comparable<T>[] inp) {
		Comparable<T> temp = inp[ind1];
		inp[ind1] = inp[ind2];
		inp[ind2] = temp;
	}
	
	public void buildHeap(Comparable<T>[] inp){
		this.heapSize = inp.length;
		for(int i = this.heapSize/2;i>=0;i--)
			heapify(inp, i);
	}
}

public class BinaryHeapTest {

	public static void main(String[] args){
		Integer[] i = {12,54,7,8,32,1,56,678,44,3,98,5};
		BinaryHeap<Integer> b = new BinaryHeap<Integer>();
		b.buildHeap(i);
		b.display(i);
	}
}
