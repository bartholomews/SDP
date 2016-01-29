package factory_method;

/**
 * Abstract factory class to be extended by a subclass to override and create a particular Product object,
 * or creates a ConcreteProduct object by default;
 */
public abstract class Creator {

    public abstract Product createProduct();

    public Product produce() {
        return new ConcreteProduct();
    }

}