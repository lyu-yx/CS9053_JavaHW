package midterm.edu.nyu.cs9053.midterm.hierarchy;

import java.util.Objects;

public class MogulSkier extends Skier {
    private double mogulheight;
    private String mongulEquipmentBrand;

    public MogulSkier() {}
    public MogulSkier(String name, int age, int skiLength, double mogulheight, String mongulEquipmentBrand) {
        super(name, age, skiLength);
        this.mogulheight = mogulheight;
        this.mongulEquipmentBrand = mongulEquipmentBrand;
    }

    public double getMogulheight() {
        return mogulheight;
    }
    public void setMogulheight(double mogulheight) {
        this.mogulheight = mogulheight;
    }

    public String getMongulEquipmentBrand() {
        return mongulEquipmentBrand;
    }
    public void setMongulEquipmentBrand(String mongulEquipmentBrand) {
        this.mongulEquipmentBrand = mongulEquipmentBrand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MogulSkier that = (MogulSkier) o;
        return Double.compare(that.mogulheight, mogulheight) == 0 &&
                mongulEquipmentBrand.equals(that.mongulEquipmentBrand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mogulheight, mongulEquipmentBrand);
    }


}
