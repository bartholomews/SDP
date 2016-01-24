package singleton;

/**
 * Lazy implementation of the Singleton Pattern, with the first thread blocked for 100ms after entering new init routine;
 * without synchronization, there's a good chance that two threads will initialise two different instances
 * of the Singleton;
 *
 * (a) applying the synchronized keyword to the getInstance() method declaration, the Singleton is now thread-safe.
 * (b) the code has lost performance as only one thread at the time can enter the getInstance() routine;
 *     for the whole time a thread is blocked inside the method (as for the first thread in this example,
 *     but it would happen for any subsequent threads), all the others cannot create a new instance:
 * (c) if the Singleton is not causing a substantial overhead, having it initialised by the JVM when the class is first loaded
 *     (i.e. eager instantiation vs lazy) would probably be a better choice;
 * (d) with the "double-checked-locking" the synchronization happens only if the new instance is not yet initialised;
 *     in this case the second thread would still wait the first on the lock because the Singleton is not yet initialised,
 *     but after the first initialisation, multiple threads are not queued on the lock and can access the getInstance routine freely;
 *     the keyword "volatile" guarantees that if one thread updates the variable, all other threads will see it as the change
 *     will be written directly to main memory.
 *
 * @author federico.bartolomei
 */
public class SingletonObject {
    private volatile static SingletonObject singleton;
    private static boolean first = true;

    private SingletonObject() {
    }

    public static /* synchronized */ SingletonObject getInstance() {
        if(singleton==null) {
            synchronized (SingletonObject.class) {
                if (first) {
                    first = false;
                    System.out.println(Thread.currentThread().getName() + " ready to create a new Singleton");
                    try {
                        System.out.println(Thread.currentThread().getName() + " will sleep a little now...");
                        Thread.currentThread().sleep(10000);
                    } catch (InterruptedException ex) {
                        // do nothing
                    }
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
