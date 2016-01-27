package singleton;

import java.io.Serializable;

/**
 * Serialization breaks the Singleton pattern because when deserialization is invoked
 * a new object is created, even if the constructor is private.
 * Introducing the readResolve() method, the Singleton instance will be returned after a de-serialization
 * instead of a new object, so that the Singleton pattern logic is valid.
 *
 * Cloning should be prevented in a Singleton class: if the class must implement Cloneable,
 * it should explicitly throw an exception in the clone() method;
 */
public class SingletonProtected implements Serializable, Cloneable {
    private static SingletonProtected SINGLETON;

    private SingletonProtected() {
        /**
         * To protect the Singleton from an use of Reflection which could create multiple instances,
         * the constructor will throw an exception if violated (called after the Singleton is already instantiated).
         */
        if(SINGLETON != null) {
            throw new IllegalStateException("Singleton instance already created");
        }
    }

    public static SingletonProtected getInstance() {
        if(SINGLETON==null) {
            synchronized (SingletonProtected.class) {
                SINGLETON = new SingletonProtected();
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

    /**
     * The cloning of object is restricted.
     *
     * @throws CloneNotSupportedException
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }



}
