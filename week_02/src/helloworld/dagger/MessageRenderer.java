package helloworld.dagger;

/**
 *
 */
public interface MessageRenderer {

    public void render();

    public void setMessageProvider(MessageProvider mp);

    public MessageProvider getMessageProvider();

}
