package assignment8.PartII;

public class Pair<S, T> {

	private S a;
	private T b;
	
	public Pair(S a, T b) {
		this.a = a;
		this.b = b;
	}
	
	public S getA() {
		return this.a;
	}
	
	public T getB() {
		return this.b;
	}
	
	public void setA(S a) {
		this.a = a;
	}
	
	public void setB(T b) {
		this.b = b;
	}
	
	public String toString() {
		return "[Pair: " + this.a.toString() + ", " + this.b.toString() + "]";
	}
}
