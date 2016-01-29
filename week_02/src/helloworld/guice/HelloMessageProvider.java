package helloworld.guice;

/**
 *
 */
public class HelloMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {
        return "Hello, World!";
    }

}
