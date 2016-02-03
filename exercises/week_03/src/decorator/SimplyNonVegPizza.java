package decorator;

/**
 *
 */
public class SimplyNonVegPizza implements Pizza {

    @Override
    public String getDesc() {
        return "SimplyNonVegPizza";
    }

    @Override
    public Double getPrice() {
        Integer price = 350;
        return price.doubleValue();
    }
}
