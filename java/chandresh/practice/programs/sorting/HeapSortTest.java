package chandresh.practice.programs.sorting;

class HeapSort<T>{
	int heapSize = 0;
	
	public void sort(Comparable<T>[] inp){
		if(inp==null || inp.length<2)
			return;
		
		this.buildMaxHeap(inp);
		
		for(int i=this.heapSize-1;i>0;i--){
			this.exchange(0, i, inp);
			this.heapSize -=1;
			this.heapify(inp, 0);
		}
		
	}
	
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
	
	public void buildMaxHeap(Comparable<T>[] inp){
		this.heapSize = inp.length;
		for(int i = this.heapSize/2;i>=0;i--)
			heapify(inp, i);
	}
}

public class HeapSortTest {
	public static void main(String[] args){
		Integer[] arrInt = {2,5,8,3,6,10, 19, 43,1, 39};
		String[] arrString = {"A","V","R","B","H","C","T","G"};
		
		Comparable<Integer>[] inp1 = arrInt;
		Comparable<String>[] inp2 = arrString;
		
		HeapSort<Integer> obj1 = new HeapSort<Integer>();
		HeapSort<String> obj2 = new HeapSort<String>();
		obj1.sort(inp1);
		obj2.sort(inp2);
		
		obj1.display(inp1);
		obj2.display(inp2);
	}
}
