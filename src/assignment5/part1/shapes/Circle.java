package assignment5.part1.shapes;

public class Circle extends GeometricObject {
	private double radius = 1.0;
	
	public Circle() {
		this.radius = 1.0;
	}
	
	public Circle(double radius) {
		this.radius = radius;
	}
	
	public Circle(double radius, String color, boolean filled) {
		super(color, filled);
		this.radius = radius;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double getArea() {
		return Math.PI*this.radius*this.radius;
	}
	
	public double getPerimeter() {
		return Math.PI*2*this.radius;
	}
	
	public double getDiameter() {
		return 2*this.radius;
	}
	
	public String toString() {
		// the output of "A Circle with radius=xxx, which is a subclass of yyy", 
		// where yyy is the output of the toString() method from the superclass
		// is also acceptable
		return "Circle[" + super.toString() + ", radius=" + this.radius + "]";
	}
	
	public String toString(String msg) {
		
		return msg;
	}
	
	public boolean equals(Object c) {
		if (c  instanceof Circle) {
			if ((this.radius == ((Circle)c).getRadius()) &&
					(this.getColor() == ((Circle)c).getColor()) &&
					(this.isFilled() == ((Circle)c).isFilled())) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Circle c1 = new Circle();
		System.out.println(c1.toString());
		System.out.println("radius = " + c1.getRadius());
		System.out.println("area = " + c1.getArea());
		System.out.println("perimeter = " + c1.getPerimeter());
		

		Circle c2 = new Circle(3.5);
		System.out.println(c2.toString());
		
		Circle c3 = new Circle(2.5, "magenta", false);
		System.out.println("c3 is " + c3.toString());
		System.out.println("c3 is " + c3.toString("this is the overloaded method"));
		
	}

}
