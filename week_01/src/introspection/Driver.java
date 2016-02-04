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

        Class baCls = BankAccount.class;
        try {
          //  Object myAccount = baCls.newInstance();

            /**
             * 4. Now the Storage.setValue(BankAccount)
             * method compiles (as it sees a BankAccount type),
             * but the assignment does not: the Object created
             * cannot be directly converted to a newInstance of
             * different type.
             */
            BankAccount myAccount = baCls.newInstance();
            /**
             * 3. The compiler complains because the variable
             * myAccount is of type Object and it cannot
             * be converted to BankAccount
            */
             aStorage.setValue(myAccount);

            // Deposit
            myAccount.deposit(15);
        } catch (InstantiationException e) {
            // ...
        } catch (IllegalAccessException e) {
            // ...
        }


    }

}
