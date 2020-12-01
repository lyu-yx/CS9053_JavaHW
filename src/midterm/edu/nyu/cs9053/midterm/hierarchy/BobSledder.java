package midterm.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class BobSledder extends Sledder{
    private double bobSledderScore;

    public BobSledder() {}
    public BobSledder(String name, int age, String sledColor, double bobSledderScore) {
        super(name, age, sledColor);
        this.bobSledderScore = bobSledderScore;
    }

    public double getBobSledderScore() {
        return bobSledderScore;
    }
    public void setBobSledderScore(double bobSledderScore) {
        this.bobSledderScore = bobSledderScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BobSledder that = (BobSledder) o;
        return Double.compare(that.bobSledderScore, bobSledderScore) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bobSledderScore);
    }
}
