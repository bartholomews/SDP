package singleton;

/**
 * @author federico.bartolomei
 */
public class Test {

    public static void main(String[] args) {
        Runnable r = new GetSingleton();
        Thread t1 = new Thread(r, "Thread1");
        Thread t2 = new Thread(r, "Thread2");
        t1.start();
        t2.start();
    }

}
