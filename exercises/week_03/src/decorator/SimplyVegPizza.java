package decorator;

/**
 *
 */
public class SimplyVegPizza implements Pizza {

    @Override
    public String getDesc() {
        return "SimplyVegPizza " + "(" + getPrice() + ")";
    }

    @Override
    public Double getPrice() {
        return 230.00;
    }
}
