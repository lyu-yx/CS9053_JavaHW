package assignment5.part1.shapes;

public class Rectangle extends GeometricObject {
	private double width = 1.0;
	private double length = 1.0;
	
	public Rectangle() {
		this.width = 1.0;
		this.length = 1.0;
	}
	
	public Rectangle(double width, double length) {
		this.width = width;
		this.length = length;
	}
	
	public Rectangle(double width, double length,
						String color, boolean filled) {
		super(color,filled);
		this.width = width;
		this.length = length;
	}
	
	public double getWidth() {
		return this.width;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}
	
	public double getArea() {
		return this.width * this.length;
	}
	
	public double getPerimeter() {
		return 2*this.width + 2*this.length;
	}
	
	public String toString() {
		// the output of "A Rectangle with width=xxx and length=zzz, which is a subclass of yyy"
		// where yyy is the output of the toString() method from the superclass
		// is also acceptable
		return "Rectangle[" + super.toString() + 
				",width=" + this.width + ",length=" + this.length + "]";
	}
	
	public static void main(String[] args) {
		Rectangle rect1 = new Rectangle();
		System.out.println(rect1.toString());
		

		Rectangle rect2 = new Rectangle(2,3);
		System.out.println("rect2 length = "+ rect2.getLength());
		System.out.println("rect2 width = "+ rect2.getWidth());
		System.out.println("rect2 area = "+ rect2.getArea());
		System.out.println("rect2 perimeter = "+ rect2.getPerimeter());
		System.out.println(rect2);
		
		Rectangle rect3 = new Rectangle(3,4, "blue", false);
		System.out.println(rect3);
	}

}
