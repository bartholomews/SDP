package helloworld.decoupled;

/**
 * This class is still dependent on the particular implementation HelloWorldMessageProvider:
 * it should refer to an abstract MessageProvider interface rather than a concrete class.
 */
public class StandardOutMessageRenderer {
    private HelloWorldMessageProvider mp = null;

    public void render() {
        if(mp == null) {
            throw new RuntimeException("Message provider not set\n" +
                    "for class " + StandardOutMessageRenderer.class.getName());
        }
        System.out.println(mp.getMessage());
    }

    public void setMessageProvider(HelloWorldMessageProvider mp) {
        this.mp = mp;
    }

    public HelloWorldMessageProvider getMessageProvider() {
        return mp;
    }

}