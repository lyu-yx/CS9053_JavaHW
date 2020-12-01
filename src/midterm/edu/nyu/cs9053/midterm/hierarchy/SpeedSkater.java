package midterm.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class SpeedSkater extends IceSkater{
    private double speedSkaterTime;

    public SpeedSkater() {}
    public SpeedSkater(String name, int age, int skateSize, double speedSkaterTime) {
        super(name, age, skateSize);
        this.speedSkaterTime = speedSkaterTime;
    }

    public double getSpeedSkaterTime() {
        return speedSkaterTime;
    }
    public void setSpeedSkaterTime(double speedSkaterTime) {
        this.speedSkaterTime = speedSkaterTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        SpeedSkater that = (SpeedSkater) o;
        return Double.compare(that.speedSkaterTime, speedSkaterTime) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), speedSkaterTime);
    }
}
