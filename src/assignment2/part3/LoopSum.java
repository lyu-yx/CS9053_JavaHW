package assignment2.part3;

import java.util.Scanner;

public class LoopSum {

	public static int sum100() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static int sumN() {
		int sum = 0;
		System.out.print("input N(should be an integer and larger than 1):");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if (n < 1) {
			System.out.println("invalid N");
			return -1;
		} else {
			for (int i = 1; i <= n; i++) {
				sum += i;
			}
			System.out.println("The sum of integers from 1 to " + n + " is: " + sum);
			return sum;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("The sum of the integers from 1 to 100 is:" + sum100());
		sumN();
	}
	
}
