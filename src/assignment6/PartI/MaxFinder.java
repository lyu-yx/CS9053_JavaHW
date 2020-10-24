package assignment6.PartI;

import java.util.ArrayList;

public class MaxFinder<T extends Number> {

        private ArrayList<T> arrayList;
        private T returnObject;
        public MaxFinder(){
                arrayList = new ArrayList<T>();
        }

        public T max(){

                if (arrayList.size() == 0) {
                        System.out.println("Collection is empty");
                        return null;
                }
                returnObject = arrayList.get(0);
                for (T num : arrayList) {
                        if (num.doubleValue() > returnObject.doubleValue()) {
                                returnObject = num;
                        }

                }
                return returnObject;
        }

        public void add(T t) {
                arrayList.add(t);

        }

public static void main (String[] args) {
        MaxFinder<Number> m = new MaxFinder<Number>();
        ComplexNumber n1 = new ComplexNumber(1,5);
        Integer a = new Integer(5);
        Double d= new Double(3.2);
        m.add(n1);
        m.add(a);
        m.add(d);
        Number max = m.max();
        System.out.println("max for m is "+ max);



        MaxFinder<Integer> m1 = new MaxFinder<Integer>();
        Integer b = new Integer(10);
        Integer c = new Integer(20);
        m1.add(b);
        m1.add(c);
        Integer max1 = m1.max();
        System.out.println("max for m1 is "+ max1);

}

}
