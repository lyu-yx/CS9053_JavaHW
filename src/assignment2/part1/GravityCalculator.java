package assignment2.part1;

import java.util.Scanner;

public class GravityCalculator {

    public static double calculatePosition() {
        double a = -9.81;

        Scanner input = new Scanner(System.in);
        System.out.println("enter time:");
        double t = input.nextDouble();
        System.out.println("enter initial velocity:");
        double initialVelocity = input.nextDouble();
        System.out.println("enter initial positon:");
        double initialPosition = input.nextDouble();

        double position = initialPosition + initialVelocity * t
                        + 0.5 * a * t * t;


        return position;
    }

    public static void main(String[] args) {
        System.out.println("The fianl position is" + calculatePosition());
    }
}
