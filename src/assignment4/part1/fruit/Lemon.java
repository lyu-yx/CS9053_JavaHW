package assignment4.part1.fruit;

public class Lemon extends Citris {
    private int sourness;

    public Lemon() {
        sourness = 0;
        super.setColor("Yellow");
    }
    public Lemon(int sourness, String taste, boolean rotten) {
        super(taste, "Yellow", rotten);
        this.sourness = sourness;
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

    public boolean equals(Object object) {
        if (object instanceof Lemon) {
            if (super.equals((Citris) object) && (((Lemon)object).getSourness()) == sourness)
                return true;
        }
        return false;
    }
}
