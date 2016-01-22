package factory_method;

/**
 * A particular implementation of Product
 */
public class ConcreteProduct implements Product {

    @Override
    public void produce() {
        System.out.println("Producing a " + this.getClass().getName());
    }

}
