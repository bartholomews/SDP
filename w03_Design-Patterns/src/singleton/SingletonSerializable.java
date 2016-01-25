package singleton;

import java.io.Serializable;

/**
 * Serialization breaks the Singleton pattern because when deserialization is invoked
 * a new object is created, even if the constructor is private.
 *
 * Introducing the readResolve() method, the Singleton instance will be returned after a de-serialization
 * instead of a new object, so that the Singleton pattern logic is valid.
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

    /**
     * This method is invoked on the new object created by the de-serialization process
     *
     * @return the Singleton instance, instead of a different de-serialized object.
     */
    private Object readResolve() {
        return SINGLETON;
    }




}
