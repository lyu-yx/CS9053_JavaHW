package assignment2.part4;

public class CopyReverse {

	public static void main(String[] args) {
		
		int[] sourceArray = new int[50];
		int[] destArray = new int[50];

		/* initialize the source Array */
		for (int i = 0;i < sourceArray.length; i++) {
			sourceArray[i] = (int)(Math.random()*100);
		}
		for (int counter = 0; counter < sourceArray.length; counter++) {
			destArray[counter] = sourceArray[sourceArray.length - counter - 1];
		}
		/* destArray should have the contents of sourceArary
		 * but in reverse, eg:
		 * sourceArray[0] should have the same value of 
		 * destArray[destArray.length-1]
		 * sourceArray[1] should have the same value of 
		 * destArray[destArray.length-2]
		 * 
		 * and so on
		 */
		// testing
		for (int j = 0; j < 50; j++){
			System.out.println((boolean)(sourceArray[j] == destArray[49 - j]));// To check if the previous process is true
		}
	}
}
