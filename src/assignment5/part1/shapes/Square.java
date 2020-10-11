package assignment5.part1.shapes;

public class Square extends Rectangle {
	public Square() {
		super(1.0,1.0);
	}
	
	public Square(double side) {
		super(side, side);
	}
	
	public Square(double side, String color, boolean filled) {
		super(side, side, color, filled);
	}
	
	public void setSide(double side) {
		super.setLength(side);
		super.setWidth(side);		
	}
	
	public double getSide() {
		return this.getLength();
	}
	
	public String toString() {
		//"A Square with side=xxx, which is a subclass of yyy", 
		// where yyy is the output of the toString() method from the superclass.
		// is also acceptable
		return "Square[" + super.toString()  + "]";
	}
	
	/* override these to prevent any code from violating the square geometry */
	
	public void setWidth(double width) {
		this.setSide(width);
	}
	
	public void setLength(double length) {
		this.setSide(length);
	}
	
	public static void main(String[] args) {
		Square sq1 = new Square();
		System.out.println("sq1: " + sq1);
		
		Square sq2 = new Square(5);
		System.out.println("sq2 side = " + sq2.getSide());
		System.out.println("sq2 area = " + sq2.getArea());
		System.out.println("sq2 perim = " + sq2.getPerimeter());
		System.out.println(sq2);
		
		sq2.setSide(8);
		System.out.println(sq2);

		sq2.setWidth(7);
		System.out.println(sq2);
		
		sq2.setWidth(6);
		System.out.println(sq2);
		
		Square sq3 = new Square(3, "gray", false);
		System.out.println("sq3: " + sq3);
	}

}
