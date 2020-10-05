package assignment4.part2.arraylists;

import assignment4.part1.fruit.Apple;
import assignment4.part1.fruit.Fruit;
import assignment4.part1.fruit.Lemon;
import assignment4.part1.fruit.Orange;

import java.util.ArrayList;
import java.util.List;

public class Functions {
    public static double avarLemonSourness(List<Fruit> list) {
        int sum = 0;
        int lemonCnt = 0;
        double avarLemonSournessResult = -1;
        for (Fruit fruit : list) {
            if (fruit instanceof Lemon) {
                Lemon tempLemon = (Lemon)fruit;
                sum += tempLemon.getSourness();
                lemonCnt++;
            }
        }
        System.out.println("sum = " + sum + "   lemonCnt = " + lemonCnt);
        avarLemonSournessResult = sum / lemonCnt;
        return avarLemonSournessResult;
    }

    public static Apple findFirstRottenGreenApple(List<Fruit> list) {
        Apple firstRottenGreenApple = null;
        for (Fruit fruit : list) {
            if (fruit instanceof Apple) {
                Apple tempApple = (Apple)fruit;
                if (tempApple.isRotten() == true && tempApple.getColor() == "green") {
                    firstRottenGreenApple = tempApple;
                    return firstRottenGreenApple;
                }
            }
        }
        System.out.println("There is no firstRottenGreenApple in this list");
        return null;
    }

    public static void removeTargetIndex(List<Fruit> list, List<Fruit> deleteTargetList) {
        list.removeAll(deleteTargetList);
    }

    public static void removeMatchingObject(List<Fruit> list) {
        Apple firstRottenGreenApple = Functions.findFirstRottenGreenApple(list);
        int length = list.size();
        List<Fruit> deleteTargetList = new ArrayList<>();
        for (Fruit fruit : list) {
            if (fruit instanceof Apple) {
                Apple tempApple = (Apple)fruit;
                if (tempApple == firstRottenGreenApple) {
                    System.out.println("No." + list.indexOf(fruit) + "  is the same object with retained apple");
                } else if(tempApple.isRotten() == firstRottenGreenApple.isRotten() &&
                          tempApple.getColor() == firstRottenGreenApple.getColor() &&
                          tempApple.getTexture() == firstRottenGreenApple.getTexture() &&
                          tempApple.getTaste() == firstRottenGreenApple.getTaste())
                {
                    System.out.println("No." + tempApple.getId() + "  have the same value with retained apple which is:");
                    System.out.println(tempApple.toString());
                    deleteTargetList.add(fruit);
                }
            }
        }
        removeTargetIndex(list, deleteTargetList);
        System.out.println();
        System.out.println( length - list.size() + " apple is removed.");
    }

    public static void printFruitList(List<Fruit> list) {
        for (Fruit fruit : list) {
            if (fruit instanceof Apple) {
                System.out.println(((Apple)fruit).toString());
            } else if (fruit instanceof Lemon) {
                System.out.println(((Lemon)fruit).toString());
            } else {
                System.out.println(((Orange)fruit).toString());
            }
        }
    }

}
