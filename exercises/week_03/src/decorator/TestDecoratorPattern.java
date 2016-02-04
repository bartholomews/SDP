package decorator;

import java.text.DecimalFormat;

/**
 *
 */
public class TestDecoratorPattern {
    private static DecimalFormat dformat;

    static {
        dformat = new DecimalFormat("#.##");
    }

    public static void main(String[] args) {
        Pizza pizza = new SimplyVegPizza();
        pizza = new RomaTomatoes(pizza);
        pizza = new GreenOlives(pizza);
        pizza = new Spinach(pizza);
        print(pizza);

        pizza = new SimplyNonVegPizza();
        pizza = new Meat(pizza);
        pizza = new Cheese(pizza);
        pizza = new Ham(pizza);
        print(pizza);
    }

    private static void print(Pizza pizza) {
        System.out.println("Desc: " + pizza.getDesc());
        System.out.println("Price: " + dformat.format(pizza.getPrice()));
    }
}