package assignment1.part2input;

import java.util.Scanner;

public class GetNameConsole {
    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
 //     String name = new Scanner(System.in).nextLine();
        System.out.println("Hello," + name + "!");
    }
}
