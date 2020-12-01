package midterm.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class Skier extends WinterSportPlayer{
    private int skiLength;

    public Skier() {}
    public Skier(String name, int age, int skiLength) {
        super(name, age);
        this.skiLength = skiLength;
    }

    public int getSkiLength() {
        return skiLength;
    }
    public void setSkiLength(int skiLength) {
        this.skiLength = skiLength;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Skier skier = (Skier) o;
        return skiLength == skier.skiLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skiLength);
    }
}
