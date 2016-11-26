package chandresh.practice.programs.sorting;

class SelectionSort<T> {
	
	public void sort(Comparable<T>[] inp){
		if(inp==null)
			return;
		
		for(int i=0;i<inp.length;i++){
			int min = i;
			
			//find the smallest element starting from ith index till the last element
			for(int j=i+1;j<inp.length;j++){
				if(inp[min].compareTo((T) inp[j])>0)
					min = j;
			}
			if(min!=i)
				exchange(i,min,inp);
		}
	}

	private void exchange(int i, int min, Comparable<T>[] inp) {
		Comparable<T> temp = inp[i];
		inp[i] = inp[min];
		inp[min] = temp;
	}
	
	public void display(Comparable<T>[] inp){
		for(Comparable<T> each:inp){
			System.out.print(each.toString() + " ");
		}
		System.out.println();
	}
	


}

public class SelectionSortTest{
	public static void main(String[] args){
		Integer[] arrInt = {2,5,8,3,6,10, 19, 43,1, 39};
		String[] arrString = {"A","V","R","B","H","C","T","G"};
		
		Comparable<Integer>[] inp1 = arrInt;
		Comparable<String>[] inp2 = arrString;
		
		SelectionSort<Integer> obj1 = new SelectionSort<Integer>();
		SelectionSort<String> obj2 = new SelectionSort<String>();
		obj1.sort(inp1);
		obj2.sort(inp2);
		
		obj1.display(inp1);
		obj2.display(inp2);
	}
}
