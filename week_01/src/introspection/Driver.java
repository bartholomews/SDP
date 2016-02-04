package introspection;

/**
 *
 */
public class Driver {

    /**
     * 1. What are the reasons for using generics here?
     *    To be able to encapsulate different classes
     *    into a generic one;
     * 2. What are the benefits?
     *    It avoids code repetition (common functionality
     *    can be called just from Storage, in this case
     *    getters and setters) and allows more flexibility;
     */
    public static void main(String[] args) {
        Storage<BankAccount> aStorage = new Storage<>();
        Storage<String> sStorage = new Storage<>();
    }

}
