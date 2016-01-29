package decoupled_with_interfaces;

/**
 *
 */
public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello, World!";
    }

}

