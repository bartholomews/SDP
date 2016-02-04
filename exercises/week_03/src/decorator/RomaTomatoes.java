package decorator;

/**
 *
 */
public class RomaTomatoes extends PizzaDecorator {

    public RomaTomatoes(Pizza base) {
        super(base);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", Roma Tomatoes (5.20)";
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 5.20;
    }
}
