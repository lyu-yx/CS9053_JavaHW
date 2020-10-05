package assignment4.part1.fruit;

public class Citris extends Fruit{
    private String taste;
    public Citris() {
        taste = "defaultTaste";
    }
    public Citris(String taste, String color, boolean rotten) {
        /* this(); */
        super(color, rotten);
        this.taste = taste;

    }

    public String getTaste() {
        return taste;
    }

    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String toString() {
        return "Citris  color:" +  getColor() + "  isrotten:" + isRotten() + "  id:" +
                getId()+  "  taste:" + getTaste();
    }

    public boolean equals(Object object) {
        if (object instanceof Citris) {
            if (super.equals((Fruit) object) && (((Citris)object).getTaste()) == taste)
                return true;
        }
        return false;
    }
}

