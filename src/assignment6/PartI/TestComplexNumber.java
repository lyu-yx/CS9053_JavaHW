package assignment6.PartI;

import java.util.Scanner;

public class TestComplexNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a = input.nextDouble();
        double b = input.nextDouble();
        ComplexNumber c1 = new ComplexNumber(a, b);

        System.out.print("Enter the second complex number: ");
        double c = input.nextDouble();
        double d = input.nextDouble();
        ComplexNumber c2 = new ComplexNumber(c, d);

        System.out.println("(" + c1 + ")" + " + " + "(" + c2 + ")" + " = " + c1.add(c2));
        System.out.println("(" + c1 + ")" + " - " + "(" + c2 + ")" + " = " + c1.subtract(c2));
        System.out.println("(" + c1 + ")" + " * " + "(" + c2 + ")" + " = " + c1.multiply(c2));
        System.out.println("(" + c1 + ")" + " / " + "(" + c2 + ")" + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "| = " + c1.abs());

        ComplexNumber c3 = null;
        try {
          c3 = (ComplexNumber)c1.clone();
        } catch (CloneNotSupportedException e) {
          e.printStackTrace();
        }
        System.out.println("c1, c3 have the same referance:  " + (c1 == c3));
        System.out.println(c3.getReal ());
        System.out.println(c3.getImaginary ());
      }
}
