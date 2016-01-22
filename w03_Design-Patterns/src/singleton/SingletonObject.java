package singleton;

/**
 * Lazy implementation of the Singleton Pattern.
 */
public class SingletonObject {
    private static SingletonObject singleton;

    private SingletonObject() {
    }

    public static SingletonObject getInstance() {
        if(singleton==null) {
            singleton = new SingletonObject();
        }
        return singleton;
    }

}
