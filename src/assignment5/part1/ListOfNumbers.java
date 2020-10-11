package assignment5.part1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;



public class ListOfNumbers {
	
    private List<Integer> list;
    private String inFile;



    public ListOfNumbers () {
        list = new ArrayList<Integer>();
    }


    public ListOfNumbers (String inFile) {
    	this();
    	this.inFile = inFile;
    }
    
    public void readList() {
        try {
            FileReader f = new FileReader("D:\\NYU class\\Intro to Java\\javahw\\src\\assignment5\\numberfile.txt");
            BufferedReader in = new BufferedReader(f);
            String ln = in.readLine();
            while (ln != null) {
                list.add(Integer.parseInt(ln));
                System.out.println(ln);
                ln = in.readLine();
            }
        } catch (FileNotFoundException fex) {
            System.err.println("Caught FileNotFoundException: " + fex.getMessage());
        } catch (IOException ioex) {
            System.err.println("Caught IOException: " + ioex.getMessage());
        }
    }
    
    public void writeList() {
        PrintWriter out = null;
        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("D:\\NYU class\\Intro to Java\\javahw\\src\\assignment5\\outFile.txt"));
            for (int i = 0; i < list.size(); i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                                 e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }
    
    public static void cat(String fileName) {
        RandomAccessFile input = null;
        String line = null;
        File file = new File(fileName);

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            return;
        } catch (FileNotFoundException e) {
            System.err.println("Caught FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    System.err.println("Caught IOException: " + e.getMessage());
                }
            }
        }
    }
    
    public static void main(String[] args) {
    	ListOfNumbers listOfNumbers = new ListOfNumbers("D:\\NYU class\\Intro to Java\\javahw\\src\\assignment5\\numberfile.txt");
    	ListOfNumbers.cat("D:\\NYU class\\Intro to Java\\javahw\\src\\assignment5\\numberfile.txt");
    	listOfNumbers.readList();
    	listOfNumbers.writeList();

    }

}
