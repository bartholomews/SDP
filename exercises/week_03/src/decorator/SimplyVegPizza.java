package decorator;

/**
 *
 */
public class SimplyVegPizza implements Pizza {

    @Override
    public String getDesc() {
        return "SimplyVegPizza";
    }

    @Override
    public Double getPrice() {
        Integer price = 230;
        return price.doubleValue();
    }
}
