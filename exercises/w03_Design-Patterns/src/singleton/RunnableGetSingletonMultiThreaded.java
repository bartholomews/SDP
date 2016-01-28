package singleton;

/**
 * Runnable class for multi-threading which simply gets a Singleton instance and check its identityHashCode.
 *
 * @author federico.bartolomei
 */
public class RunnableGetSingletonMultiThreaded implements Runnable {

    @Override
    public void run() {
        SingletonMultiThreaded s = SingletonMultiThreaded.getInstance();
        System.out.println(Integer.toHexString(System.identityHashCode(s)) + " returned");
    }

}
