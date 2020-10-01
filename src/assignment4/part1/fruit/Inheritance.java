package assignment4.part1.fruit;

public class Inheritance {

	public static void main(String[] args) {
		Fruit fruit = new Fruit();
		Citris citris = new Citris();
		Lemon lemon = new Lemon();
		Orange orange = new Orange();
		Orange orange1 = new Orange("beautiful", "very good", false);
		orange.setRotten(true);

		System.out.println(fruit.toString());
		System.out.println(citris.toString());
		System.out.println(lemon.toString());
		System.out.println(orange.toString());
		System.out.println(orange1.toString());
		System.out.println(orange1.equals(orange));
	}

}
