package assignment2.part4;

public class LargestPairProduct {

	public static void main(String[] args) {
		
		int[] intArray = {17, 1, 3, 12, 39, 4, 76, 4, 31, 87};
		int product = -1;
		for (int i = 0; i < intArray.length; i++) {
			for (int j = i + 1; j < intArray.length; j++) {
				if (intArray[i] * intArray[j] > product) {
					product = intArray[i] * intArray[j];
				}
			}
		}
		System.out.println("Maximum product of all pairs in the array: " +
							product);
	}
}
