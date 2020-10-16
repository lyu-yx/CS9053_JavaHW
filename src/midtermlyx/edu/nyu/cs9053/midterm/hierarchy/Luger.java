package midtermlyx.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class Luger extends Sledder{
    private String lugeEquipmentBrand;

    public Luger() {}
    public Luger(String name, int age, String sledColor, String lugeEquipmentBrand) {
        super(name, age, sledColor);
        this.lugeEquipmentBrand = lugeEquipmentBrand;
    }


    public String getlugeEquipmentBrand() {
        return lugeEquipmentBrand;
    }

    public void setlugeEquipmentBrand(String lugeEquipmentBrand) {
        this.lugeEquipmentBrand = lugeEquipmentBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Luger luger = (Luger) o;
        return lugeEquipmentBrand.equals(luger.lugeEquipmentBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lugeEquipmentBrand);
    }
}
