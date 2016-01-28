package decoupled;

/**
 * The functionality of MessageProvider is separated by the other classes to allow modularity;
 * Still this class should be an implementation of an interface, so that could be exposed to other classes.
 */
public class HelloWorldMessageProvider {

    public String getMessage() {
        return "Hello, World!";
    }

}