package helloworld.dagger;

import helloworld.dagger.Module;
import helloworld.dagger.Provides;

/**
 *
 */

@Module
public class MessageRendererModule {
    @Provides MessageRenderer provideMessageRenderer(StandardOutMessageRenderer mr) {
        return mr;
    }

}
