package singleton;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * If readResolve() is not implemented in the Singleton class, deserialization returns a new object,
 * breaking the Singleton pattern logic.
 *
 * Reflection also can break the Singleton pattern: reflective access can in fact set the private constructor accessible.
 *
 */
public class TestSingletonProtected {
    private static SingletonProtected INSTANCE = SingletonProtected.getInstance();

    private void serialize(File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(INSTANCE);
        oos.close();
    }

    private SingletonProtected deserialize(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        SingletonProtected instance = (SingletonProtected) ois.readObject();
        ois.close();
        return instance;
    }

    private void compareInstances(SingletonProtected s1, SingletonProtected s2) {
        System.out.println("First instance: " + s1);
        System.out.println("Second instance: " + s2);
        System.out.println("The two instances are " + ((s1==s2) ? "EQUAL" : "DIFFERENT"));
    }

    public void testSerializable() throws IOException, ClassNotFoundException {
        File file = new File("ser/serialized.ser");
        serialize(file);
        SingletonProtected s1 = deserialize(file);
        SingletonProtected s2 = deserialize(file);
        compareInstances(s1, s2);
    }

    /**
     * The IllegalStateException thrown by the Singleton constructor when it finds the instance already instantiated
     * causes an InvocationTargetException, in this way the Singleton pattern is protected by Reflection.
     */
    public void testReflection() throws Exception {
        Class cls = SingletonProtected.class;
        Constructor cons = cls.getDeclaredConstructor();
        cons.setAccessible(true);
        SingletonProtected broken1 = (SingletonProtected) cons.newInstance();
        SingletonProtected broken2 = (SingletonProtected) cons.newInstance();
        compareInstances(broken1, broken2);
    }

    public static void main(String[] args) throws Exception {
        TestSingletonProtected run = new TestSingletonProtected();
        run.testSerializable();
        run.testReflection();
    }

}
