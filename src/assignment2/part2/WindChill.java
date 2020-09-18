package assignment2.part2;

import java.util.Scanner;

public class WindChill {

	public static double windChill(double temp, double windSpeed) {
		double windChillTemp = 35.74 + 0.6215 * temp
				             + (0.4275 * temp - 35.75) * Math.pow(windSpeed,0.16);
		return windChillTemp;
	}
	
	public static void main(String[] args) {
		
		double temp;
		double windSpeed;
		
		double windChillTemp;

		Scanner input = new Scanner(System.in);
		System.out.println("enter the temperature in Fahrenheit: ");
		temp = input.nextDouble();
		System.out.println("enter the wind speed in miles per hour: ");
		windSpeed = input.nextDouble();



		if ((temp > -50 && temp < 50) && (windSpeed >3 && windSpeed < 110)){
			// if the wind chill is valid:
			System.out.println("For a temperature of " + temp +
					" with wind speed of " + windSpeed +
					", the wind chill is " + windChill(temp, windSpeed));
		} else {
			// if the wind chill is not valid:
			System.out.println("Cannot calculate a valid wind chill for this temperate and/or wind speed");
		}
	}
}
