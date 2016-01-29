package helloworld_dagger;

import javax.inject.Inject;

/**
 *
 */
public class StandardOutMessageRenderer implements MessageRenderer {
    @Inject private MessageProvider mp;

    @Override
    public void render() {
        if(mp == null) {
            throw new NullPointerException("MessageProvider not set for " + this.getClass().getName());
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
