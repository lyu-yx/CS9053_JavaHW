package assignment2.part3;

import java.lang.String;
import java.util.Scanner;

public class NumberToEnglish {

	public static StringBuilder numberToEnglish(int num) {
		//Scanner input = new Scanner(System.in);
		String[] factors = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight",
				"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety",
				"hundred", "thousand", "million"};
		int[] factorsNum = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,
									30,40,50,60,70,80,90,100,1000,1000000};
		//System.out.print("Enter an number between -999,999,999 and 999,999,999:");
		//int amount = input.nextInt();
		int remainingNum = 0;
		int numberofCurrentFactor = 0;
		StringBuilder stringBuilder = new StringBuilder();
		if (num < 0) {
			stringBuilder.append("nagetive  ");
			num = -num;
		}
		remainingNum = num; //initialize remainingNum
		for (int i = 29; i >= 0; i--) {
			numberofCurrentFactor = remainingNum / factorsNum[i];
			remainingNum = remainingNum % factorsNum[i];
			stringBuilder.append(numberofCurrentFactor + "  " + factors[i] + ",  " );
		}
		stringBuilder.delete(stringBuilder.length() - 3,stringBuilder.length()); //delete the last ","
		stringBuilder.append(".");												 // and append "."
		return stringBuilder;
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		System.out.print("Enter a number: " );
		
		int number = in.nextInt();
		
		System.out.println("The number " + number + " in English is " + NumberToEnglish.numberToEnglish(number).toString());
	
	}
}
