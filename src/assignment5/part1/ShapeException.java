package assignment5.part1;

public class ShapeException extends Exception {
    public ShapeException() {
        super();
    }
    public ShapeException(String illegalShape) {
        System.out.println("Illegalshape name is: " + illegalShape);
    }
}
