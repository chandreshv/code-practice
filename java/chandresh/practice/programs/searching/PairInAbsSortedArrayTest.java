package chandresh.practice.programs.searching;

/**
 * @author CHANDREV algorithm that takes an abs-sorted array and a number k, and
 *         returns a pair of indices of element in A that sums upto k.
 *    
 * 
 */
class PairInAbsSortedArray {
	public int[] findPair(int[] inp, int k) {
		int result[] = { -1, -1 };

		if (inp == null || inp.length == 0)
			return result;

		for (int i = 0; i < inp.length; i++) {
			int first = inp[i];
			int second = k - first;
			int index = search(inp, Math.abs(second), i + 1, inp.length - 1);
			if (index >= 0 && second==inp[index]) {
				result[0] = i;
				result[1] = index;
				return result;
			}
		}

		return result;
	}

	private int search(int[] inp, int num, int lo, int hi) {

		if (hi < lo)
			return -1;

		int mid = lo + (hi - lo) / 2;
		if (Math.abs(inp[mid]) == num)
			return mid;

		if (Math.abs(inp[mid]) > num)
			return search(inp, num, lo, mid - 1);
		else
			return search(inp, num, mid + 1, hi);
	}
}

public class PairInAbsSortedArrayTest {

	public static void main(String[] main) {
		int[] inp = { 1, 2, 3, -4, 5, 6, 7, -8, -9 };

		PairInAbsSortedArray absArr = new PairInAbsSortedArray();
		int[] result = absArr.findPair(inp, 10);
		System.out.println("Index are: " + result[0] + " " + result[1]);
		
		result = absArr.findPair(inp, -8);
		System.out.println("Index are: " + result[0] + " " + result[1]);
		
		result = absArr.findPair(inp, -98);
		System.out.println("Index are: " + result[0] + " " + result[1]);

	}
}
