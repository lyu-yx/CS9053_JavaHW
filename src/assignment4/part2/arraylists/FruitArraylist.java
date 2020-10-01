package assignment4.part2.arraylists;
import assignment4.part1.fruit.Apple;
import assignment4.part1.fruit.Fruit;
import assignment4.part1.fruit.Lemon;
import assignment4.part1.fruit.Orange;

import java.util.ArrayList;
import java.util.Arrays;


public class FruitArraylist {

	public static void main(String[] args) {

        Apple redApple1 = new Apple("sweet", "crisp", "red", false);
        Apple greenApple2 = new Apple("tart", "soft", "green", true);
        Lemon lemon1 = new Lemon(80, "sour", false);
        Orange orange1 = new Orange("mandarin", "sweet", true);
        Apple greenApple3 = new Apple("tart", "soft", "green", true);
        Apple greenApple4 = new Apple("tart", "soft", "red", true);
        Apple greenApple5 = new Apple("tart", "soft", "green", false);
        Apple greenApple6 = new Apple("tart", "soft", "yellow", true);
        Apple greenApple7 = new Apple("tart", "soft", "green", true);
        Orange orange2 = new Orange("mandarin", "sweet", true);
		// this is the variable you should retain to compare
		// to the other objects in the arraylist
		Fruit[] array = {redApple1, greenApple2, lemon1, greenApple3, greenApple4, greenApple5, greenApple6, greenApple7, orange1, orange2};
        ArrayList<Fruit> fruitArrayList = new ArrayList<Fruit>(Arrays.asList(array));

        System.out.println(Functions.avarLemonSourness(fruitArrayList));

        Functions.removeMatchingObject(fruitArrayList);

        System.out.println(fruitArrayList);
	}
}
