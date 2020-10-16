package midtermlyx.edu.nyu.cs9053.midterm.hierarchy;

public class Testing {
    public static void main(String[] args) {
        //WinterSportPlayer is an abstract class and cannot instantiated.

        //1.Sledder testing
        System.out.println("Sledder test:");
        Sledder sledderPlayer1 = new Sledder("Mike",21, "Green");
        Sledder sledderPlayer2 = new Sledder("Bob",25, "Red");

        System.out.println("name: " + sledderPlayer1.getName() +
                           "  age:  " + sledderPlayer1.getAge() +
                           "  seldColor:  " + sledderPlayer1.getSledColor());
        System.out.println("sledderPlayer1 and sledderPlayer2 is equal:  " + sledderPlayer1.equals(sledderPlayer2));
        sledderPlayer2.setSledColor("Green");
        sledderPlayer2.setAge(21);
        sledderPlayer2.setName("Mike");
        System.out.println("After setting:");
        System.out.println("sledderPlayer1 and sledderPlayer2 is equal:  " + sledderPlayer1.equals(sledderPlayer2));
        System.out.println();

        //2.Luger testing
        System.out.println("Luger test:");
        Luger luger1 = new Luger("Mike",21, "Green", "Nike");
        Luger luger2 = new Luger("Bob",25, "Red","Adidas");
        System.out.println("Luger1 and Luger2 is equal:  " + luger1.equals(luger2));
        System.out.println("name: " + luger1.getName() +
                "  age:  " + luger1.getAge() +
                "  seldColor:  " + luger1.getSledColor() +
                "  lugEquipmentBrand:  " + luger1.getlugeEquipmentBrand());
        luger2.setSledColor("Green");
        luger2.setAge(21);
        luger2.setName("Mike");
        luger2.setlugeEquipmentBrand("Nike");
        System.out.println("After setting:");
        System.out.println("Luger1 and Luger2 is equal:  " + luger1.equals(luger2));
        System.out.println();

        //3.BobSlendder testing
        System.out.println("BobSlendder test:");
        BobSledder bobSledder1 = new BobSledder("Mike", 21, "Green", 40);
        BobSledder bobSledder2 = new BobSledder("Bob",25, "Red", 30);
        System.out.println("bobSledder1 and bobSledder2 is equal:  " + bobSledder1.equals(bobSledder2));
        System.out.println("name: " + bobSledder1.getName() +
                "  age:  " + bobSledder1.getAge() +
                "  seldColor:  " + bobSledder1.getSledColor() +
                "  getBobSledderScore:  " + bobSledder1.getBobSledderScore());
        bobSledder2.setSledColor("Green");
        bobSledder2.setAge(21);
        bobSledder2.setName("Mike");
        bobSledder2.setBobSledderScore(40);
        System.out.println("After setting:");
        System.out.println("BobSledder1 and BobSledder2 is equal:  " + bobSledder1.equals(bobSledder2));
        System.out.println();

        //4.CrossCountrySkier testing
        System.out.println("CrossCountrySkier test:");
        CrossCountrySkier crossCountrySkier1 = new CrossCountrySkier("Mike", 21, 50, 4);
        CrossCountrySkier crossCountrySkier2 = new CrossCountrySkier("Bob",25, 60, 3);
        System.out.println("crossCountrySkier1 and crossCountrySkier2 is equal:  " + crossCountrySkier1.equals(crossCountrySkier2));
        System.out.println("name: " + crossCountrySkier1.getName() +
                "  age:  " + crossCountrySkier1.getAge() +
                "  SkiLength:  " + crossCountrySkier1.getSkiLength() +
                "  getCrossCountryNumber:  " + crossCountrySkier1.getCrossCountryNumber());
        crossCountrySkier2.setCrossCountryNumber(4);
        crossCountrySkier2.setAge(21);
        crossCountrySkier2.setName("Mike");
        crossCountrySkier2.setSkiLength(50);
        System.out.println("After setting:");
        System.out.println("crossCountrySkier1 and crossCountrySkier2 is equal:  " + crossCountrySkier1.equals(crossCountrySkier2));
        System.out.println();

        //5.Curler testing
        System.out.println("Curler test:");
        Curler culer1 = new Curler("Mike", 21, "Stripe", 4);
        Curler culer2 = new Curler("Bob",25, "Camouflag", 3);
        System.out.println("culer1 and culer2 is equal:  " + culer1.equals(culer2));
        System.out.println("name: " + culer1.getName() +
                "  age:  " + culer1.getAge() +
                "  TrouserPattern:  " + culer1.getTrouserPattern() +
                "  BrushLength:  " + culer1.getBrushLength());
        culer2.setBrushLength(4);
        culer2.setAge(21);
        culer2.setName("Mike");
        culer2.setTrouserPattern("Stripe");
        System.out.println("After setting:");
        System.out.println("culer1 and culer2 is equal:  " + culer1.equals(culer2));
        System.out.println();

        //6.FigureSkater testing
        System.out.println("FigureSkater test:");
        FigureSkater figureSkate1 = new FigureSkater("Mike", 21, 5, 4);
        FigureSkater figureSkate2 = new FigureSkater("Bob",25, 4, 3);
        System.out.println("figureSkate1 and figureSkate2 is equal:  " + figureSkate1.equals(figureSkate2));
        System.out.println("name: " + figureSkate1.getName() +
                "  age:  " + figureSkate1.getAge() +
                "  IceSkateScore:  " + figureSkate1.getIceSkateScore() +
                "  SkateSize:  " + figureSkate1.getSkateSize());
        figureSkate2.setIceSkateScore(4);
        figureSkate2.setAge(21);
        figureSkate2.setName("Mike");
        figureSkate2.setSkateSize(5);
        System.out.println("After setting:");
        System.out.println("figureSkate1 and figureSkate2 is equal:  " + figureSkate1.equals(figureSkate2));
        System.out.println();

        //7.IceSkater testing
        System.out.println("IceSkater test:");
        IceSkater iceSkater1 = new IceSkater("Mike", 21, 20);
        IceSkater iceSkater2 = new IceSkater("Bob",25, 30);
        System.out.println("iceSkater1 and iceSkater2 is equal:  " + iceSkater1.equals(iceSkater2));
        System.out.println("name: " + iceSkater1.getName() +
                "  age:  " + iceSkater1.getAge() +
                "  SkateSize:  " + iceSkater1.getSkateSize());
        iceSkater2.setAge(21);
        iceSkater2.setName("Mike");
        iceSkater2.setSkateSize(30);
        System.out.println("After setting:");
        System.out.println("iceSkater1 and iceSkater2 is equal:  " + iceSkater1.equals(iceSkater2));
        System.out.println();

        //8.MogulSkier testing
        System.out.println("MogulSkier test:");
        MogulSkier mogulSkier1 = new MogulSkier("Mike", 21, 21, 66.3, "Nike");
        MogulSkier mogulSkier2 = new MogulSkier("Bob", 25, 20,36.2,"Adidas");
        System.out.println("mogulSkier1 and mogulSkier2 is equal:  " + mogulSkier1.equals(mogulSkier2));
        System.out.println("name: " + mogulSkier1.getName() +
                "  age:  " + mogulSkier1.getAge() +
                "  MongulEquipmentBrand:  " + mogulSkier1.getMongulEquipmentBrand() +
                "  Mogulheight:  " + mogulSkier1.getMogulheight() +
                "  SkiLength  " + mogulSkier1.getSkiLength());
        mogulSkier2.setMogulheight(66.3);
        mogulSkier2.setAge(21);
        mogulSkier2.setName("Mike");
        mogulSkier2.setSkiLength(21);
        mogulSkier2.setMongulEquipmentBrand("Nike");
        System.out.println("After setting:");
        System.out.println("mogulSkier1 and mogulSkier2 is equal:  " + mogulSkier1.equals(mogulSkier2));
        System.out.println();

        //9.Skier testing
        System.out.println("Skier test:");
        Skier skier1 = new Skier("Mike", 21, 30);
        Skier skier2 = new Skier("Bob",25, 40);
        System.out.println("skier1 and skier2 is equal:  " + skier1.equals(skier2));
        System.out.println("name: " + skier1.getName() +
                "  age:  " + skier1.getAge() +
                "  SkiLength:  " + skier1.getSkiLength());
        skier2.setSkiLength(30);
        skier2.setAge(21);
        skier2.setName("Mike");
        System.out.println("After setting:");
        System.out.println("skier1 and skier2 is equal:  " + skier1.equals(skier2));
        System.out.println();

        //10.SpeedSkater testing
        System.out.println("SpeedSkater test:");
        SpeedSkater speedSkater1 = new SpeedSkater("Mike", 21, 5, 10.32);
        SpeedSkater speedSkater2 = new SpeedSkater("Bob",25, 4, 11.25);
        System.out.println("speedSkater1 and speedSkater2 is equal:  " + speedSkater1.equals(speedSkater2));
        System.out.println("name: " + speedSkater1.getName() +
                "  age:  " + speedSkater1.getAge() +
                "  SpeedSkaterTime:  " + speedSkater1.getSpeedSkaterTime() +
                "  SkateSize:  " + speedSkater1.getSkateSize());
        speedSkater2.setSpeedSkaterTime(10.32);
        speedSkater2.setAge(21);
        speedSkater2.setName("Mike");
        speedSkater2.setSkateSize(5);
        System.out.println("After setting:");
        System.out.println("speedSkater1 and speedSkater2 is equal:  " + speedSkater1.equals(speedSkater2));
        System.out.println();
    }
}
