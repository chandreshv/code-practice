package chandresh.practice.programs.sorting;

class InsertionSort<T>{
	public void sort(Comparable<T>[] inp){
		if(inp==null || inp.length==1)
			return;
		
		for(int i=0;i<inp.length;i++){
			int j=i;
			while(true){
				
				//Terminating conditions:
				// 1. if we have reached the 1st element of the input.
				// 2. If the element previous to the current index (j) is less than current index
				if(j==0 || inp[j].compareTo((T) inp[j-1])>0)
					break;
				if(inp[j].compareTo((T) inp[j-1])<0)
					exchange(j, j-1, inp);
				j--;
				
			}
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

public class InsertionSortTest {

	public static void main(String[] args){
		Integer[] arrInt = {2,5,8,3,6,10, 19, 43,1, 39};
		String[] arrString = {"A","V","R","B","H","C","T","G"};
		
		Comparable<Integer>[] inp1 = arrInt;
		Comparable<String>[] inp2 = arrString;
		
		InsertionSort<Integer> obj1 = new InsertionSort<Integer>();
		InsertionSort<String> obj2 = new InsertionSort<String>();
		obj1.sort(inp1);
		obj2.sort(inp2);
		
		obj1.display(inp1);
		obj2.display(inp2);
	}
}
