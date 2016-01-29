package helloworld.guice;

import com.google.inject.AbstractModule;

/**
 *
 */
public class HelloStandardOutModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(MessageProvider.class).to(HelloMessageProvider.class);

        bind(MessageRenderer.class).to(StandardOutMessageRenderer.class);

    }
}
