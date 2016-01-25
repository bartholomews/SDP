package singleton;

import java.io.*;

/**
 * If readResolve() is not implemented in the Singleton class, deserialization returns a new object,
 * breaking the Singleton pattern logic.
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

    public void testSerializable() throws IOException, ClassNotFoundException {
        File file = new File("ser/serialized.ser");
        serialize(file);
        SingletonProtected s1 = deserialize(file);
        SingletonProtected s2 = deserialize(file);
        System.out.println("First instance deserialized: " + s1);
        System.out.println("Second instance deserialized: " + s2);
        System.out.println("The two instances are " + ((s1==s2) ? "EQUAL" : "DIFFERENT"));
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSingletonProtected run = new TestSingletonProtected();
        run.testSerializable();
    }

}
