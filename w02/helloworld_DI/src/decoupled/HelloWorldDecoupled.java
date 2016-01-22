package decoupled;

/**
 * For this version, the message provider logic and the message renderer logic
 * are separated from the rest of the code (Separation of concerns/modularity in SOLID);
 * provider and renderer can change without affecting the rest of the application.
 */
public class HelloWorldDecoupled {

    public static void main(String[] args) {
        StandardOutMessageRenderer mr = new StandardOutMessageRenderer();
        HelloWorldMessageProvider mp = new HelloWorldMessageProvider();
        mr.setMessageProvider(mp);
        mr.render();
    }

}