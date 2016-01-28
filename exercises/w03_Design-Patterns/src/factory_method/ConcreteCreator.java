package factory_method;

/**
 * Factory class which returns a particular implementation of Product
 */
public class ConcreteCreator extends Creator {

    @Override
    public Product createProduct() {
        return new ConcreteProduct();
    }
}
