package helloworld.decoupled_with_interfaces;

/**
 * The implementation is making use of a MessageProvider interface
 * so it doesn't depend on a particular external concrete class.
 */
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider mp = null;

    @Override
    public void render() {
        if(mp == null) {
            throw new NullPointerException("MessageProvider not set\n" +
                        "for class " + this.getClass().getName());
        } else {
            System.out.println(mp.getMessage());
        }
    }

    @Override
    public void setMessageProvider(MessageProvider mp) {
        this.mp = mp;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return mp;
    }

}
