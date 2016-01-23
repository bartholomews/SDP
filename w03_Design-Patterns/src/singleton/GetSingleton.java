package singleton;

/**
 * Runnable class for multi-threading which simply gets a Singleton instance and check its identityHashCode.
 */
public class GetSingleton implements Runnable {

    @Override
    public void run() {
        SingletonObject s = SingletonObject.getInstance();
        System.out.println(Integer.toHexString(System.identityHashCode(s)) + " returned");
    }

}
