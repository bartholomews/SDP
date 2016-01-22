package decoupled_with_interfaces;

/**
 * Introducing interfaces, the message rendering logic does not get affected
 * by the change in the message provider implementation;
 * still, in order to implement a different version (i.e. change the business logic)
 * it is necessary to rewrite the code as it is a direct assignment.
 *
 */
public class HelloWorldDecoupledInterface {

    public static void main(String[] args) {
        MessageProvider mp = new HelloWorldMessageProvider();
        MessageRenderer mr = new StandardOutMessageRenderer();

        mr.setMessageProvider(mp);
        mr.render();

    }

}
