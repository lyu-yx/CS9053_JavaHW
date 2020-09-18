package assignment2.part4;

public class ArrayStats {

	public static void main(String[] args) {
		int[] intArray = new int[50];
		
		int smallestValue = Integer.MAX_VALUE;
		int largestValue = Integer.MIN_VALUE;
		double sum = 0;
		double meanAverage = 0;
		
		/* initialize the source Array */
		for (int i = 0;i < intArray.length; i++) {
			intArray[i] = (int)(Math.random()*100);
		}

		for (int arrayItem : intArray) {
			if (smallestValue > arrayItem) {
				smallestValue = arrayItem;
			}
			if (largestValue < arrayItem) {
				largestValue = arrayItem;
			}
			sum += arrayItem;
		}

		meanAverage = sum / intArray.length;
		System.out.println("Smallest value in the array is " + 
							smallestValue);
		System.out.println("Largest value in the array is " + 
							largestValue);
		System.out.println("Mean average value of array elements is " + 
							meanAverage);
	}
}
