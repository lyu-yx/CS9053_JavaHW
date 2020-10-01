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
        this.taste = taste;
        this.texture = texture;
        super.setColor(color);
        super.setRotten(rotten);
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

    public boolean equals(Apple apple) {
        if (apple.getColor() == super.getColor() && apple.isRotten() == super.isRotten())
            return true;
        else
            return false;
    }
}