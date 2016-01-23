package singleton;

/**
 * Lazy implementation of the Singleton Pattern, with the first thread blocked for 100ms after entering new init routine;
 * without synchronization, there's a good chance that two threads will initialise two different instances
 * of the Singleton;
 * (a) applying the synchronized keyword to the getInstance() method declaration, the Singleton is now thread-safe.
 */
public class SingletonObject {
    private static SingletonObject singleton;
    private static boolean first = true;

    private SingletonObject() {
    }

    public static synchronized SingletonObject getInstance() {
        if(singleton==null) {
            if (first) {
                first = false;
                System.out.println(Thread.currentThread().getName() + " ready to create a new Singleton");
                try {
                    System.out.println(Thread.currentThread().getName() + " will sleep a little now...");
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException ex) {
                    // do nothing
                }
            }
            singleton = new SingletonObject();
            System.out.print(Thread.currentThread().getName() + " created instance ");
            System.out.println(Integer.toHexString(System.identityHashCode(singleton)));
        }
        System.out.println(Thread.currentThread().getName() + " returning " + Integer.toHexString(System.identityHashCode(singleton)));
        return singleton;
    }

}
