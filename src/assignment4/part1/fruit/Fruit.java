package assignment4.part1.fruit;

public class Fruit {
    private String color;
    private boolean rotten;
    private int id;
    static private int next_id;

    public Fruit() {
        id = next_id;
        next_id++;
        color = "defaultColor";
        rotten = false;
    }

    public Fruit(String color, boolean rotten) {
        this();
        this.color = color;
        this.rotten = rotten;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRotten() {
        return rotten;
    }
    public void setRotten (boolean rotten) {
        this.rotten = rotten;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        return "Fruit  color:" + getColor() + "  isrotten:" + isRotten() + "  id:" + getId();
    }


    public boolean equals(Fruit fruit) {
        if (fruit.getColor() == color && fruit.isRotten() == rotten)
            return true;
        else
            return false;
    }

}