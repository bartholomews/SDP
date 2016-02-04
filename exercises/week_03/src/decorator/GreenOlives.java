package decorator;

/**
 *
 */
public class GreenOlives extends PizzaDecorator {

    public GreenOlives(Pizza base) {
        super(base);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", Green Olives (5.47)";
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 5.47;
    }

}
