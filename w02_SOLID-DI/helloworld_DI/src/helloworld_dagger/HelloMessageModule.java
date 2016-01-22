package helloworld_dagger;

import dagger.Module;
import dagger.Provides;

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
