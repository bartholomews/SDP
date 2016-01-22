package helloworld_dagger;

import dagger.Component;

/**
 *
 */

@Component (modules = HelloMessageModule.class)
public interface HelloWorldComponent {
    HelloWorld get();
}
