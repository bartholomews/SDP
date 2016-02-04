package decorator;

/**
 *
 */
public class Spinach extends PizzaDecorator {

    public Spinach(Pizza base) {
        super(base);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", Spinach (7.92)";
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 7.92;
    }
}
