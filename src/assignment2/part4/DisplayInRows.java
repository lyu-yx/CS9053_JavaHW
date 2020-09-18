package assignment2.part4;

public class DisplayInRows {

	static final int ROW_LENGTH = 10;
	
	public static void main(String[] args) {
		
		int[] intArray = new int[100];
		int count = 0;
		for (int i=0;i< intArray.length;i++) {
			intArray[i] = (int)(Math.random()*100);
		}
		for (int j = 0; j < intArray.length; j++) {
			if (count / 10 == 1) {
				System.out.println();
				count = 0;
			}
			count++;
			System.out.printf("%4d  ",intArray[j]);
		}
		
	}
}
