package coffee_dagger;

import helloworld.dagger.Module;
import helloworld.dagger.Provides;
import javax.inject.Singleton;

@Module(includes = PumpModule.class)
class DripCoffeeModule {
    @Provides @Singleton Heater provideHeater() {
        return new ElectricHeater();
    }
}