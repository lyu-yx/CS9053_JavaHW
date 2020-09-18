package assignment2.part3;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		int val = 0;
		long factoralResult = 1;
		long preResultForOverflowDetect = 1;
		boolean overflowFlag = false;
		Scanner input = new Scanner(System.in);
		System.out.print("enter n(should be an integer and more than 0): ");
		int n = input.nextInt();
		if (n == 0) {
			val = 1;
			System.out.println("Factorial of 0 is 1");
		} else {
			for (int i = 1; i <= n; i++) {
				factoralResult *= i;
				if (preResultForOverflowDetect > factoralResult){
					System.out.println("OVERFLOW! Please choose a smaller n");
					overflowFlag = true;
					break;
				}
				preResultForOverflowDetect = factoralResult;
			}
			if (overflowFlag == false)
				System.out.println("Factorial of " + n + " is " + factoralResult);
			else
				System.out.println("exit!");
		}

	}
}
