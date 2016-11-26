package chandresh.practice.programs.sorting;

import java.util.Random;

public class ArrayShuffleTest {

	private static void shuffle(int[] arr) {
		if(arr==null || arr.length<2)
			return;
		
		for(int i=1;i<arr.length;i++){
			//int random = (int) Math.random();
			Random random = new Random();
			int ind2 = random.nextInt(i);
			ArrayShuffleTest.exchange(i, ind2, arr);
		}
		
	}
	
	public static void display(int[] inp){
		for(int each:inp){
			System.out.print(each + " ");
		}
		System.out.println();
	}
	
	private static void exchange(int ind1, int ind2, int[] inp) {
		int temp = inp[ind1];
		inp[ind1] = inp[ind2];
		inp[ind2] = temp;
	}
	
	public static void main(String args[]){
		int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
		
		ArrayShuffleTest.shuffle(arr);
		ArrayShuffleTest.display(arr);
		ArrayShuffleTest.shuffle(arr);
		ArrayShuffleTest.display(arr);
		ArrayShuffleTest.shuffle(arr);
		ArrayShuffleTest.display(arr);
	}
}
