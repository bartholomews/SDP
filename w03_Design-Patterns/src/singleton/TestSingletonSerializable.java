package singleton;

import java.io.*;

/**
 * Each deserialization creates a new instance of the Singleton: Serialization broke the pattern.
 */
public class TestSingletonSerializable {
    private static SingletonSerializable INSTANCE = SingletonSerializable.getInstance();

    public void serialize(File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
        oos.writeObject(INSTANCE);
        oos.close();
    }

    public SingletonSerializable deserialize(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        SingletonSerializable instance = (SingletonSerializable) ois.readObject();
        ois.close();
        return instance;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TestSingletonSerializable test = new TestSingletonSerializable();
        File file = new File("ser/serialized.ser");
        test.serialize(file);
        SingletonSerializable s1 = test.deserialize(file);
        SingletonSerializable s2 = test.deserialize(file);
        System.out.println("First instance deserialized: " + s1);
        System.out.println("Second instance deserialzied: " + s2);
        System.out.println("The two instances are " + ((s1==s2) ? "EQUAL" : "DIFFERENT"));
    }

}
