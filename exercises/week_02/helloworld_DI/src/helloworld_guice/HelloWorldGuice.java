package helloworld_guice;

import com.google.inject.Inject;

/**
 *
 */
public class HelloWorldGuice {
    private final MessageProvider mp;
    private final MessageRenderer mr;

    @Inject
    public HelloWorldGuice(MessageProvider mp, MessageRenderer mr) {
        this.mp = mp;
        this.mr = mr;
    }

    public void launch() {
        mr.setMessageProvider(mp);
        mr.render();
    }

}
