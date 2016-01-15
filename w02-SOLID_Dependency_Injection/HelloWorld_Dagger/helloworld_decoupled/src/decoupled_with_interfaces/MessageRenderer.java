package decoupled_with_interfaces;

/**
 * The interface enforces the necessity to use an abstraction of MessageProvider
 * instead of a concrete implementation so it will not create a tight binding.
 */
public interface MessageRenderer {

    public void render();

    public void setMessageProvider(MessageProvider mp);

    public MessageProvider getMessageProvider();

}
