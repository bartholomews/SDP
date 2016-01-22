package helloworld_dagger;

import javax.inject.Inject;

/**
 * TODO check why it doest compile .builder class _?
 * https://groups.google.com/forum/#!topic/dagger-discuss/STkfRUs_Wg0
 * http://google.github.io/dagger/
 * https://blog.gouline.net/2015/05/04/dagger-2-even-sharper-less-square/
 */
public class HelloWorld {
    @Inject MessageRenderer mr;
    @Inject MessageProvider mp;

    public void launch() {
        mr.setMessageProvider(mp);
        mr.render();
   //     DaggerHelloWorldComponent;
    }

}
