package assignment2.part4;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		
		int[][] twoDimArray = new int[2][5];
		int[] arrayOne = {5, 9, 55, 23, 89};
		int[] arrayTwo = {15, 3, 23, 19, 64};
		
		/* copy arrayOne and arrayTwo into twoDimArray */
		/* print out the first list of 5 numbers in twoDimArray
		 * on one line, and the second list of 5 numbers in twoDimArray
		 * on the next line
		 */
		
		/* the solution should use nested loops: one loop to loop over
		 * each array in twoDimArray, and one loop to loop over each element
		 * in that array
		 */
		for (int i = 0; i < twoDimArray.length; i++) {
			for (int j = 0; j < twoDimArray[0].length; j++) {
				if (i == 0) {
					twoDimArray[0][j] = arrayOne[j];
				} else {
					twoDimArray[1][j] = arrayTwo[j];
				}
			}
		}

		for (int i = 0; i < twoDimArray.length; i++) {
			for (int j = 0; j < twoDimArray[0].length; j++) {
				if (i == 0) {
					System.out.printf("%5d",twoDimArray[0][j]);
				} else {
					System.out.printf("%5d",twoDimArray[1][j]);
				}
				if (j == 4)
					System.out.println();
			}
		}
	}
}
