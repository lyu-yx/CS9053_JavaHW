package assignment4.part1.fruit;

public class Apple extends Fruit{
    private String taste;
    private String texture;

    public Apple() {
        taste = "defaultTaste";
        texture = "defaultTexture";
    }
    public Apple(String taste, String texture, String color, boolean rotten) {
        /* this(); */
        super(color, rotten);
        this.taste = taste;
        this.texture = texture;
    }

    public String getTaste() {
        return taste;
    }
    public void setTaste(String taste) {
        this.taste = taste;
    }

    public String getTexture() {
        return texture;
    }
    public void setTexture(String texture) {
        this.texture = texture;
    }

    public String toString() {
        return "Apple  " + "color:" + getColor() + "  isrotten:" + isRotten() + "  id:" +
                getId()+  "  taste:" +getTaste() + "  texture:" + getTexture();
    }


    public boolean equals(Object object) {
        if (object instanceof Apple) {
            if (super.equals((Fruit) object) && (((Apple)object).getTaste()) == taste && ((Apple)object).getTexture() == texture)
                return true;
        }
        return false;
    }
}
