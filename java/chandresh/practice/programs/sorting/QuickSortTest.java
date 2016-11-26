package chandresh.practice.programs.sorting;

import java.util.Random;

class QuickSort<T>{

	public void sort(Comparable<T>[] inp) {
		if(inp==null || inp.length<2)
			return;
		shuffle(inp);
		sort(inp,0,inp.length-1);
		
	}
	
	private void sort(Comparable<T>[] inp, int lo, int hi) {
		if(lo>=hi)
			return;
		int mid = partition(inp,lo,hi);
		sort(inp,lo,mid-1);
		sort(inp,mid+1,hi);
		
	}

	private int partition(Comparable<T>[] inp, int lo, int hi) {
		int i=lo,j=hi;
		i++;
		while(i<j){
			while(inp[i].compareTo((T) inp[lo])<0){
				i++;
				if(i==hi)
					break;
			}
			while(inp[j].compareTo((T) inp[lo])>0){
				j--;
				if(j==lo)
					break;
			}
			
			if(i>=j)
				break;
			
			exchange(i, j, inp);
		}
		exchange(j, lo, inp);
		return j;
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

public class QuickSortTest {
	
	public static void main(String[] args){
		Integer[] arrInt = {2,5,8,3,6,10, 19, 43,1, 39};
		String[] arrString = {"A","V","R","B","H","C","T","G"};
		
		Comparable<Integer>[] inp1 = arrInt;
		Comparable<String>[] inp2 = arrString;
		
		QuickSort<Integer> obj1 = new QuickSort<Integer>();
		QuickSort<String> obj2 = new QuickSort<String>();
		obj1.sort(inp1);
		obj2.sort(inp2);
		
		obj1.display(inp1);
		obj2.display(inp2);
	}

}
