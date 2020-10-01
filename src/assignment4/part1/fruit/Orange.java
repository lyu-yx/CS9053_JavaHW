package assignment4.part1.fruit;

public class Orange extends Citris{
    private String type;

    public Orange() {
        type = "defaultType";
        super.setColor("Orange");
    }

    public Orange(String type, String taste, boolean rotten) {
        this();
        this.type = type;
        super.setTaste(taste);
        super.setRotten(rotten);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString() {
        return "Orange  color:" +  getColor() + "  isrotten:" + isRotten() + "  id:" +
                getId()+  "  taste:" + getTaste();
    }

    public boolean equals(Orange orange) {
        if (orange.getColor() == super.getColor() &&
            orange.isRotten() == super.isRotten() &&
            orange.getTaste() == super.getTaste())
            return true;
        else
            return false;
    }

}
