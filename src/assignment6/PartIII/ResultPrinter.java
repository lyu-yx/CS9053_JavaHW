package assignment6.PartIII;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collection;

public class ResultPrinter {

	MathOperation op;
	MathOperation addition = (double a, double b) -> a + b;


	private double operate(double a, double b, MathOperation mathOperation){
		return mathOperation.operation(a, b);
	}

	public ResultPrinter(MathOperation op) {
		this.op = addition;
	}

	public void go(double a, double b) {
		 System.out.println("result is " + op.operation(a, b));
	}

	public static void go(double a, double b, MathOperation op) {
		 System.out.println("result is " + op.operation(a, b));
	}
	
	public static void go(Collection<Pair<Double,Double>> c, MathOperation op) {
		c.forEach((pair) -> System.out.println("result is " + op.operation(pair.getKey(), pair.getValue())));

	}
	
	public static void main(String[] args) {
		MathOperation addition = (double a, double b) -> a + b;
		MathOperation multiplication = (double a, double b) -> ( a * b );
		ResultPrinter rp = new ResultPrinter(multiplication);
		System.out.println("------------------go(double a, double b) part ------------------");
		rp.go(3.0, 4.0);
		System.out.println("--------go(double a, double b, MathOperation op) part -------------");
		ResultPrinter.go(4.0, 2.0, multiplication);
		System.out.println("--------go(Collection<Pair<Double,Double>> c, MathOperation op) part -------------");
		ArrayList<Pair<Double,Double>> al = new ArrayList<Pair<Double,Double>>();
		Pair<Double, Double> p = new Pair<Double, Double>(3.0, 4.0);
		al.add(p);
		p = new Pair<Double, Double>(5.0, 6.0);
		al.add(p);
		p = new Pair<Double, Double>(7.0, 8.0);
		al.add(p);

		System.out.println("multiplication:");
		ResultPrinter.go(al, multiplication);
		System.out.println("addition:");
		ResultPrinter.go(al, addition);
		
	}
}
