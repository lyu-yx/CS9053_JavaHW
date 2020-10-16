package midtermlyx.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class Curler extends WinterSportPlayer {
    private String trouserPattern;
    private int brushLength;

    public Curler() {}
    public Curler(String name, int age, String trouserPattern, int brushLength) {
        super(name, age);
        this.trouserPattern = trouserPattern;
        this.brushLength = brushLength;
    }

    public void setBrushLength(int brushLength) {
        this.brushLength = brushLength;
    }
    public int getBrushLength() {
        return brushLength;
    }

    public void setTrouserPattern(String trouserPattern) {
        this.trouserPattern = trouserPattern;
    }
    public String getTrouserPattern() {
        return trouserPattern;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Curler curler = (Curler) o;
        return brushLength == curler.brushLength &&
                trouserPattern.equals(curler.trouserPattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), trouserPattern, brushLength);
    }
}
