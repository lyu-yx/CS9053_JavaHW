package assignment5.part1.shapes;

import java.util.Date;

public class GeometricObject {
	private static int next_id = 0;
	private int id;
	private String color;
	private boolean filled;
	private Date dateCreated;
	
	public GeometricObject() {

		this.color = "green";
		this.filled = true;
		this.dateCreated = new Date();
		this.id = next_id;
		next_id++;
	}
	
	public GeometricObject(String color, boolean filled) {
		this();
		this.color = color;
		this.filled = filled;		
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	protected boolean isFilled() {
		return this.filled;
	}
	
	public void setFilled(boolean filled) {
		this.filled = filled;
	}
	
	public Date getDateCreated() {
		return this.dateCreated;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return super.toString() + ": GeometricObject[color=" + this.color + ", filled=" + this.filled + "]";
	}
	
	
	public static void main (String[] args) {
		GeometricObject s1 = new GeometricObject();
		System.out.println(s1.toString());
		s1.setColor("brown");
		s1.setFilled(false);
		System.out.println(s1.toString());
		System.out.println("s1 color is " + s1.getColor());
		System.out.println("s1 filled is " + s1.isFilled());
		
		GeometricObject s2 = new GeometricObject("purple", true);
		System.out.println(s2.toString());
	}

}
