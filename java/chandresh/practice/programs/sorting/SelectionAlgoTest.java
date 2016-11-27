package chandresh.practice.programs.sorting;

import java.util.Random;

class SelectionAlgo<T>{
	
	public T findKthLargestElement(Comparable<T>[] inp,int k){
		if(k<1 || k>inp.length)
			return null;
		
		shuffle(inp);
		return findKthLargestElement(inp,0,inp.length-1,inp.length-k+1);
	}
	
	private T findKthLargestElement(Comparable<T>[] inp, int lo, int hi,int k) {
		if(lo>hi)
			return null;
		
		int  mid = partition(inp,lo,hi);
		if(k==mid+1)
			return (T) inp[mid];
		else if((mid+1)>k)
			return findKthLargestElement(inp, lo, mid-1, k);
		else
			return findKthLargestElement(inp, mid+1, hi, k);
	}

	private int partition(Comparable<T>[] inp, int lo, int hi) {
		int from=lo+1,end=hi;
		
		while(from<end){
			while(inp[lo].compareTo((T) inp[from])>0){
				from++;
				if(from==hi)
					break;
			}
			
			while(inp[lo].compareTo((T) inp[end])<0){
				end--;
				if(end==lo)
					break;
			}
			
			if(from>=end)
				break;
			
			exchange(from,end,inp);
		}
		exchange(lo, end, inp);
		return end;
	}

	private void shuffle(Comparable<T>[] inp) {
		if(inp==null || inp.length<2)
			return;
		
		for(int i=1;i<inp.length;i++){
			//int random = (int) Math.random();
			Random random = new Random();
			int ind2 = random.nextInt(i);
			exchange(i, ind2, inp);
		}
		
	}
	
	private void exchange(int ind1, int ind2, Comparable<T>[] inp) {
		Comparable<T> temp = inp[ind1];
		inp[ind1] = inp[ind2];
		inp[ind2] = temp;
	}
	
	public void display(Comparable<T>[] inp){
		for(Comparable<T> each:inp){
			System.out.print(each.toString() + " ");
		}
		System.out.println();
	}

	
}

public class SelectionAlgoTest {
	
	public static void main(String[] args){
		Integer[] arrInt = {2,5,8,3,6,10, 19, 43,1, 39};
		
		Comparable<Integer>[] inp1 = arrInt;
		
		SelectionAlgo<Integer> obj1 = new SelectionAlgo<Integer>();
		System.out.println("Largest element is: " + obj1.findKthLargestElement(inp1, 1));
		System.out.println("Smallest element is: " + obj1.findKthLargestElement(inp1, inp1.length));
		System.out.println("Third Largest element is: " + obj1.findKthLargestElement(inp1, 3));
		
	}

}
