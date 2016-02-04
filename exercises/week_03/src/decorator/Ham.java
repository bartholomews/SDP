package decorator;

/**
 *
 */
public class Ham extends PizzaDecorator {

    public Ham(Pizza base) {
        super(base);
    }

    @Override
    public String getDesc() {
        return super.getDesc() + ", Ham (18.12)";
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + 18.12;
    }
}
