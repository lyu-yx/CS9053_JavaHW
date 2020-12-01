package midterm;

public class test {
    public static void main(String[] args) {
        Object[] objs = new Object[10];
        System.out.println((new Object()).toString());

        objs[5] = new Integer(20);
        Object myObj = objs[5];
        System.out.println(myObj.toString());
    }
}
