package decorator;

/**
 *
 */
public class Cheese extends PizzaDecorator {

    public Cheese(Pizza base) {
        super(base);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", Cheese (20.72)";
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 20.72;
    }

}
