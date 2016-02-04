package decorator;

/**
 *
 */
public class SimplyNonVegPizza implements Pizza {

    @Override
    public String getDesc() {
        return "SimplyNonVegPizza " + "(" + getPrice() + ")";
    }

    @Override
    public Double getPrice() {
        return 350.00;
    }
}
