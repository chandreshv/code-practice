package chandresh.practice.programs.searching;

class BinarySearch{
	public int search(int[] inp, int num){
		if(inp.length<1)
			return -1;
		
		return search(inp,num,0,inp.length-1);
	}

	private int search(int[] inp, int num, int lo, int hi) {
		
		if(hi<lo)
			return -1;
		
		int mid = lo + (hi-lo)/2;
		if(inp[mid]==num)
			return mid;
		
		if(inp[mid]>num)
			return search(inp, num,lo,mid-1);
		else
			return search(inp,num,mid+1,hi);
	}
}

public class BinarySearchTest {

	public static void main(String[] args){
		//input should be sorted
		int[] inp = {1,2,3,4,5,6,7,8,9,10};
		BinarySearch bs = new BinarySearch();
		System.out.println("Index of value 3 is : " + bs.search(inp, 3));
		System.out.println("Index of value 12 is : " + bs.search(inp, 11));
		
	}
}
