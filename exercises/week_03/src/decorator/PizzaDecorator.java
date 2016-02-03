package decorator;

/**
 *
 */
public abstract class PizzaDecorator implements Pizza {
    private Pizza base;

    public PizzaDecorator(Pizza base) {
        this.base = base;
    }

    @Override
    public String getDesc() {
        return base.getDesc();
    }

    @Override
    public Double getPrice() {
        return base.getPrice();
    }



}
