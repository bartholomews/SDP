package helloworld_guice;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 *
 */
public class TestHelloWorldGuice {

    public static void main(String[] args) {

        Injector injector = Guice.createInjector(new HelloStandardOutModule());

        HelloWorldGuice hw = injector.getInstance(HelloWorldGuice.class);
        hw.launch();

    }

}
