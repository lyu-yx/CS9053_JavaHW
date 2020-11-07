package assignment8.PartII;

import java.util.HashSet;
import java.util.Set;

public class MathSet<E> extends HashSet<E> {

	public Set<E> intersection(Set<E> s2) {
        Set<E> resultSet = new HashSet<E>();
        for (E e : s2
             ) {
            if (this.contains(e)) {
                resultSet.add(e);
            }

        }
        return resultSet;
	}

	public Set<E> union(Set<E> s2) {
        Set<E> resultSet = new HashSet<E>();
	    for (E e : this
             ) {
            resultSet.add(e);
        }
        for (E e : s2
        ) {
            resultSet.add(e);
        }
        return resultSet;
	}

	public <T> Set<Pair<E,T>> cartesianProduct(Set<T> s2) {
        Set<Pair<E,T>> resultSet = new HashSet<>();

        E a = null;
        T b = null;

        for (E e1 : this
             ) {
            for (T e2 : s2
                 ) {
                Pair<E,T> pairTemp = new Pair<>(a, b);
                pairTemp.setA(e1);
                pairTemp.setB(e2);
                resultSet.add(pairTemp);
            }
        }
        return resultSet;
	}

	public static void main(String[] args) {
		// create two MathSet objects of the same type.
		// See if union and intersection works.
        MathSet<Integer> mathSet1 = new MathSet<>();
        MathSet<Integer> mathSet2 = new MathSet<>();
        mathSet1.add(1);
        mathSet1.add(2);
        mathSet1.add(3);

        mathSet2.add(1);
        mathSet2.add(2);
        mathSet2.add(3);

        System.out.println(mathSet1.union(mathSet2));
        System.out.println(mathSet1.intersection(mathSet2));
		// create another MathSet object of a different type
		// calculate the cartesian product of this set with one of the
		// above sets
        MathSet<String> mathSet3 = new MathSet<>();
        mathSet3.add("one");
        mathSet3.add("two");
        mathSet3.add("three");
        System.out.println(mathSet3.cartesianProduct(mathSet2));
	}
}
