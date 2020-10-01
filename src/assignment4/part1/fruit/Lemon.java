package assignment4.part1.fruit;

public class Lemon extends Citris {
    private int sourness;

    public Lemon() {
        sourness = 0;
        super.setColor("Yellow");
    }
    public Lemon(int sourness, String taste, boolean rotten) {
        this();
        this.sourness = sourness;
        super.setTaste(taste);
        super.setRotten(rotten);
    }

    public int getSourness() {
        return sourness;
    }
    public void setSourness(int sourness) {
        this.sourness = sourness;
    }

    public String toString() {
        return "Lemon  color:" +  getColor() + "  isrotten:" + isRotten() + "  id:" +
                getId()+  "  taste:" + getTaste() + "  sourness:" + getSourness();
    }

    public boolean equals(Lemon lemon) {
        if (lemon.getColor() == super.getColor() &&
            lemon.isRotten() == super.isRotten() &&
            lemon.getTaste() == super.getTaste())
            return true;
        else
            return false;
    }
}
