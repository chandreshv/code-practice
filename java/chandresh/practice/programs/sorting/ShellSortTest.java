package chandresh.practice.programs.sorting;

class ShellSort<T>{
	public void sort(Comparable<T>[] inp){
		if(inp==null)
			return;
		
		//Use 3X+1 series to do the h-sorting
		int h = 1;
		while(h<inp.length)
			h = (h*3)+1;
		
		h/=3;
		
		while (h > 0) {
			for(int i=0;i<inp.length;i++){
				int j=i;
				while(j-h>=0){
					if(j==0 || inp[j].compareTo((T) inp[j-h])>0)
						break;
					if(inp[j].compareTo((T) inp[j-h])<0)
						exchange(j, j-h, inp);
					j-=h;
				}
			}
			
			h/=3;
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

public class ShellSortTest {

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
