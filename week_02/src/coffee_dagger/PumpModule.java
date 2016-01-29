package coffee_dagger;

import helloworld.dagger.Module;
import helloworld.dagger.Provides;

@Module
class PumpModule {
    @Provides Pump providePump(Thermosiphon pump) {
        return pump;
    }
}