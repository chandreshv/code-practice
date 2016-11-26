package chandresh.practice.programs.sorting;

import java.util.Comparator;

class MergeSort<T>{
	public void sort(Comparable<T>[] inp){
		sort(inp,0,inp.length-1);
	}
	
	private void sort(Comparable<T>[] inp,int lo,int hi){
		if(hi<=lo)
			return;
		
		int mid = lo + ((hi-lo)/2);
		sort(inp,lo,mid);
		sort(inp,mid+1,hi);
		merge(inp,lo,mid,hi);
	}
	
	
	private void merge(Comparable<T>[] inp,int lo,int mid, int hi){
		Object[] temp = new Object[hi-lo+1];
		int first=lo,second=mid+1,index=0;
		
		while(first<=mid && second<=hi){
			if(inp[first].compareTo((T) inp[second])<=0){
				temp[index] = inp[first];
				first++;
			}else{
				temp[index] = inp[second];
				second++;
			}
			index++;
		}
		
		if(first<=mid){
			while(first<=mid){
				temp[index] = inp[first];
				first++;index++;
			}
		}
		if(second<=hi){
			while(second<=hi){
				temp[index]=inp[second];
				second++;index++;
			}
		}
		
		for(int i=lo,j=0;j<temp.length;j++,i++)
			inp[i]=(Comparable<T>) temp[j];
	}

	public void display(Comparable<T>[] inp){
		for(Comparable<T> each:inp){
			System.out.print(each.toString() + " ");
		}
		System.out.println();
	}
}

public class MergeSortTest {

	
	public static void main(String[] args){
		Integer[] arrInt = {2,5,8,3,6,10, 19, 43,1, 39};
		String[] arrString = {"A","V","R","B","H","C","T","G"};
		
		Comparable<Integer>[] inp1 = arrInt;
		Comparable<String>[] inp2 = arrString;
		
		MergeSort<Integer> obj1 = new MergeSort<Integer>();
		MergeSort<String> obj2 = new MergeSort<String>();
		obj1.sort(inp1);
		obj2.sort(inp2);
		
		obj1.display(inp1);
		obj2.display(inp2);
	}	
}
