package assignment3.part1;

public class Ellipse {
	private static int nextId;
	private int id;
	private double semiMajorAxis = 2.0;
	private double semiMinorAxis = 1.0;

	public Ellipse() {
        Ellipse.nextId++;
    }

    public Ellipse(double a, double b) {
        this();
	    this.semiMajorAxis = a;
	    this.semiMinorAxis = b;
    }

    public double getSemiMajorAxis() {
	    return semiMajorAxis;
    }

    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    public double getArea() {
	    return semiMajorAxis * semiMinorAxis * Math.PI;
    }

    public int getId() {
        id = nextId;

	    return id;
    }
}

//Testing code
//    public static void main(String[] args) {
//        Ellipse ellipseTest = new Ellipse(5,2);
//        System.out.println("id:" + ellipseTest.getId());
//        Ellipse ellipseTestDupli = new Ellipse(4,2);
//        System.out.println("id:" + ellipseTestDupli.getId() + "Area: " + ellipseTestDupli.getArea());
//        System.out.println("getSemiMajorAxis():" + ellipseTestDupli.getSemiMajorAxis() +
//                "getSemiMinorAxis: " + ellipseTestDupli.getSemiMinorAxis());
//    }