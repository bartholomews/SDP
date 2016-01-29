package coffee_dagger;

import com.google.inject.Singleton;
import dagger.Component;

public class CoffeeApp {
    @Singleton
    @Component(modules = { DripCoffeeModule.class })
    public interface Coffee {
        CoffeeMaker maker();
    }

    public static void main(String[] args) {
  //      Coffee coffee = DaggerCoffeeApp.builder().build();    // TODO try to make it work
  //      coffee.maker().brew();
    }
}