package singleton;

import java.io.Serializable;

/**
 * Serialization breaks the singleton pattern because when deserialization is invoked
 * a new object is created, even if the constructor is private.
 */
public class SingletonSerializable implements Serializable {
    private static SingletonSerializable SINGLETON;

    private SingletonSerializable(){}

    public static SingletonSerializable getInstance() {
        if(SINGLETON==null) {
            synchronized (SingletonSerializable.class) {
                SINGLETON = new SingletonSerializable();
            }
        }
        return SINGLETON;
    }


}
