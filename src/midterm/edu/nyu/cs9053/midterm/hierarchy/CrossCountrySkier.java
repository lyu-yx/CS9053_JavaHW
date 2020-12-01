package midterm.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class CrossCountrySkier extends Skier {
    private int crossCountryNumber;

    public CrossCountrySkier() {}
    public CrossCountrySkier(String name, int age, int skiLength, int crossCountryNumber) {
        super(name, age, skiLength);
        this.crossCountryNumber = crossCountryNumber;
    }

    public int getCrossCountryNumber() {
        return crossCountryNumber;
    }
    public void setCrossCountryNumber(int crossCountryNumber) {
        this.crossCountryNumber = crossCountryNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        CrossCountrySkier that = (CrossCountrySkier) o;
        return crossCountryNumber == that.crossCountryNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), crossCountryNumber);
    }
}
