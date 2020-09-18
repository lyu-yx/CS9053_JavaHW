package assignment2.part2;

import java.util.Scanner;

public class MuayThai {

	public static int getMinWeight(int weight) {
		// this takes a weight and returns the "min weight" for the
		// weight class
		if (weight > 0 && weight < 112) {
			return 0;
		} else if (weight >= 112 && weight < 115) {
			return 112;
		} else if (weight >= 115 && weight < 118) {
			return 115;
		} else if (weight >= 118 && weight < 122) {
			return 118;
		} else if (weight >= 122 && weight < 126) {
			return 122;
		} else if (weight >= 126 && weight < 130) {
			return 126;
		} else if (weight >= 130 && weight < 135) {
			return 130;
		} else if (weight >= 135 && weight < 140) {
			return 135;
		} else if (weight >= 140 && weight < 147) {
			return 140;
		} else if (weight >= 154 && weight < 160) {
			return 154;
		} else if (weight >= 160 && weight < 167) {
			return 160;
		} else if (weight >= 167 && weight < 175) {
			return 167;
		} else if (weight >= 175 && weight < 183) {
			return 175;
		} else if (weight >= 183 && weight < 190) {
			return 183;
		} else if (weight >= 190 && weight < 220) {
			return 190;
		} else if (weight >= 220) {
			return 220;
		} else {
			return -1;
		}

	}
	
	public static String getWeightClass(int minWeight) {
		// use a switch statement to assign the correct
		// value to weightClass and return the result
		switch (minWeight) {
			case 0: return "Flyweight";
			case 112: return "Super flyweight";
			case 115: return "Bantamweight";
			case 118: return "Super bantamweight";
			case 122: return "Featherweight";
			case 126: return "Super featherweight";
			case 130: return "Lightweight";
			case 135: return "Super lightweight";
			case 140: return "Welterweight";
			case 147: return "Super welterweight";
			case 154: return "Middleweight";
			case 160: return "Super middleweight";
			case 167: return "Light heavyweight";
			case 175: return "Super light heavyweight";
			case 183: return "Cruiserweight";
			case 190: return "Heavyweight";
			case 220: return "Super heavyweight";
		}
		return "unknown case";
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Input weight in pounds: ");
		int pounds = in.nextInt();

		int minWeight = getMinWeight(pounds);
		// if pounds is greater than zero
		if (minWeight != -1)
			System.out.println("Weight class for " + pounds + " is " + getWeightClass(minWeight));
		
		// if for some reason you put in a negative number of pounds:
		else
			System.out.println("Invalid weight value");
	}
}
