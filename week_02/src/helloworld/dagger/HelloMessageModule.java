package helloworld.dagger;

import helloworld.dagger.Module;
import helloworld.dagger.Provides;

import javax.inject.Singleton;

/**
 *
 */

@Module (includes = MessageRendererModule.class)
public class HelloMessageModule {
    @Provides @Singleton MessageProvider provideMessageProvider(HelloMessageProvider mp) {
        return mp;

    }

}
