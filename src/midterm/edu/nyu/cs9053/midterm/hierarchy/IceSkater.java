package midterm.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class IceSkater extends WinterSportPlayer{
    private int skateSize;

    public IceSkater() {}
    public IceSkater(String name, int age, int skateSize) {
        super(name, age);
        this.skateSize = skateSize;
    }

    public int getSkateSize() {
        return skateSize;
    }
    public void setSkateSize(int skateSize) {
        this.skateSize = skateSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        IceSkater iceSkater = (IceSkater) o;
        return skateSize == iceSkater.skateSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), skateSize);
    }
}
