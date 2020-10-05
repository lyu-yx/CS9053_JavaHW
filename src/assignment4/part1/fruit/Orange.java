package assignment4.part1.fruit;

public class Orange extends Citris{
    private String type;

    public Orange() {
        type = "defaultType";
        super.setColor("Orange");
    }

    public Orange(String type, String taste, boolean rotten) {
        super(taste, "Orange", rotten);
        this.type = type;
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


    public boolean equals(Object object) {
        if (object instanceof Orange) {
            if (super.equals((Citris) object) && (((Orange)object).getType()) == type)
                return true;
        }
        return false;
    }
}

