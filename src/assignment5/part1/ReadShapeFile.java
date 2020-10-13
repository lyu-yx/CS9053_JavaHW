package assignment5.part1;

import assignment5.part1.shapes.Circle;
import assignment5.part1.shapes.GeometricObject;
import assignment5.part1.shapes.Rectangle;
import assignment5.part1.shapes.Square;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/* your tasks:
 * create a class called ShapeException
 * createShape should throw a ShapeException
 * in main(), you should catch the ShapeException
 *
 */
public class ReadShapeFile {

	public static GeometricObject createShape(String shapeName) throws ShapeException {
        /* if shapeName is "Circle" return Circle();
         * if shapeName is "Square" return Square();
         * if shapeName is "Rectangle" return Rectangle();
         * if it is not any one of these, it should throw
         * a ShapeException
         */
	    if (shapeName.equals("Circle"))
            return new Circle();
        else if (shapeName.equals("Square"))
            return new Square();
        else if (shapeName.equals("Rectangle"))
            return new Rectangle();
        else
            throw new ShapeException(shapeName);
    }

	public static void main(String[] args) {
		ArrayList<GeometricObject> shapeList = new ArrayList<GeometricObject>();
		File f = new File("D:\\NYU class\\Intro to Java\\javahw\\src\\assignment5\\shapes.txt");
        RandomAccessFile input = null;
		String inString = null;
        try {
            input = new RandomAccessFile(f, "r");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (true) {
            try {
                if (((inString = input.readLine()) == null)) break;
                try {
                    /* create a loop to read the file line-by-line */
                    GeometricObject shape = createShape(inString);
                    shapeList.add(shape);
                    System.out.println(inString);
                } catch (ShapeException e) {
                    System.out.println("Caught ShapeException");
                    continue;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
            System.out.println(shapeList.size());
	}
}
