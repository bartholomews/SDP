package decorator;

/**
 *
 */
public class Meat extends PizzaDecorator {

    public Meat(Pizza base) {
        super(base);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", Meat (14.25)";
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 14.25;
    }
}
