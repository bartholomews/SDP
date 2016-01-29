package helloworld.dagger;

import helloworld.dagger.Component;

/**
 *
 */

@Component (modules = HelloMessageModule.class)
public interface HelloWorldComponent {
    HelloWorld get();
}
