package chandresh.practice.programs.searching;

class FindSingle{
	
	public int findSingleFromDoublateArray(int[] inp){
		if(inp==null || inp.length==0)
			return Integer.MIN_VALUE;
		
		int result = 0;
		for(Integer each:inp){
			result = result^each;
		}
		
		return result;
	}
	
	/**
	 * @param inp
	 * @return: Number which appreared only one in an array whereas other numbers are repeated thrice.
	 * 
	 *
	 */
	public int findSingleFromTripletArray(int[] inp){
		if(inp==null || inp.length==0)
			return Integer.MIN_VALUE;
		int INT_LENGTH = 32;
		int[] result = new int[32];
		int temp=0;
		
		
		for(int i = 0; i<INT_LENGTH;i++){
			temp=0;
			for(int j=0;j<inp.length;j++){
				int bit = 1<<(INT_LENGTH-i-1);
				temp+=((inp[j] & bit)>0)?1:0;
			}
			result[i] = temp%3;
		}
		
		return convertToDecimal(result,INT_LENGTH);
	}

	private int convertToDecimal(int[] result, int iNT_LENGTH) {
		
		if(result==null)
			return -1;
		int number=0;
		for(int i=result.length-1;i>=0;i--){
			number += (result[i]*Math.pow(2, iNT_LENGTH-i-1));
		}
		
		return number;
	}
	
}

public class FindSingleTest {

	public static void main(String[] main){
		int[] inpDouble = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8};
		int[] inpTriple = {1,2,3,4,5,6,7,8,9,1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8};
		FindSingle fs = new FindSingle();
		System.out.println(fs.findSingleFromDoublateArray(inpDouble));
		System.out.println(fs.findSingleFromTripletArray(inpTriple));
	}
	
}
