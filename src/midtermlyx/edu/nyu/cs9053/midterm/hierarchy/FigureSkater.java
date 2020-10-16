package midtermlyx.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class FigureSkater extends IceSkater {
    private double iceSkateScore;

    public FigureSkater() {}
    public FigureSkater(String name, int age, int skateSize, double iceSkateScore) {
        super(name, age, skateSize);
        this.iceSkateScore = iceSkateScore;
    }

    public double getIceSkateScore() {
        return iceSkateScore;
    }
    public void setIceSkateScore(double iceSkateScore) {
        this.iceSkateScore = iceSkateScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        FigureSkater that = (FigureSkater) o;
        return Double.compare(that.iceSkateScore, iceSkateScore) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), iceSkateScore);
    }
}
