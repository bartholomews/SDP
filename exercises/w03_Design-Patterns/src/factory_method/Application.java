package factory_method;

/**
 * The application code is not bound to a particular implementation of Product or the factory class Creator;
 * it gets an implementation of the factory class Creator and calls its method createProduct(), which
 * returns the particular implementation of Product as defined by the factory method.
 */
public class Application {
    Creator creator;

    public Application(Creator creator) {
        this.creator = creator;
    }

    public void launch() {
        Product p = creator.createProduct();
        p.produce();
    }

}