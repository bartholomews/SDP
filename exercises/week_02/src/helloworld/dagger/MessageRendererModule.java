package helloworld.dagger;

import dagger.Module;
import dagger.Provides;

/**
 *
 */

@Module
public class MessageRendererModule {
    @Provides
    MessageRenderer provideMessageRenderer(StandardOutMessageRenderer mr) {
        return mr;
    }

}
