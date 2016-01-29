package helloworld.guice;

/**
 *
 */
public interface MessageRenderer {

    public void setMessageProvider(MessageProvider mp);

    public MessageProvider getMessageProvider();

    public void render();

}
