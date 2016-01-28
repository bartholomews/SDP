package helloworld_guice;

/**
 *
 */
public class StandardOutMessageRenderer implements MessageRenderer {
    private MessageProvider mp;

    @Override
    public void setMessageProvider(MessageProvider mp) {
        this.mp = mp;
    }

    @Override
    public MessageProvider getMessageProvider() {
        return mp;
    }

    @Override
    public void render() {
        if(mp == null) {
            throw new NullPointerException("Message Provider not set for class " + this.getClass().getName());
        } else {
            System.out.println(mp.getMessage());
        }
    }
}
