package singleton;

import java.io.Serializable;

/**
 * Serialization breaks the Singleton pattern because when deserialization is invoked
 * a new object is created, even if the constructor is private.
 *
 * Introducing the readResolve() method, the Singleton instance will be returned after a de-serialization
 * instead of a new object, so that the Singleton pattern logic is valid.
 */
public class SingletonProtected implements Serializable, Cloneable {
    private static SingletonProtected SINGLETON;

    private SingletonProtected(){}

    public static SingletonProtected getInstance() {
        if(SINGLETON==null) {
            synchronized (SingletonProtected.class) {
                SINGLETON = new SingletonProtected();
            }
        }
        return SINGLETON;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
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
