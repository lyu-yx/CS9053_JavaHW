package midtermlyx;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class  part1_3 {
    public static void main(String[] args) {
        FileReader file = null;
        try {
            file = new FileReader("data.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader fileInput = new BufferedReader(file);
        String inLine = null;
        try {
            inLine = fileInput.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (inLine!= null) {
            try {
                String[] numbers = inLine.split(" ");
                Integer a = Integer.parseInt(numbers[0]);
                Integer b = Integer.parseInt(numbers[1]);
                Integer c = a / b;
                System.out.println("result = " + c);
            } catch (ArithmeticException e) {
                e.printStackTrace();
            } catch (ArrayIndexOutOfBoundsException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
                try {
                    inLine = fileInput.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
    }
}
