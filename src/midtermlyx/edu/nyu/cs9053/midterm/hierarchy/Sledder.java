package midtermlyx.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class Sledder extends WinterSportPlayer{
    private String sledColor;

    public Sledder(){}
    public Sledder(String name, int age, String sledColor) {
        super(name, age);
        this.sledColor = sledColor;
    }

    public String getSledColor() {
        return sledColor;
    }
    public void setSledColor(String sledColor) {
        this.sledColor = sledColor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Sledder sledder = (Sledder) o;
        return sledColor.equals(sledder.sledColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), sledColor);
    }
}
