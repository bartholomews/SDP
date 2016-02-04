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

        //Class baCls = BankAccount.class;

        /**
         * 6. The code compiles fine without errors, as the type
         * later instantiated is correct. About the role of generics,
         * it suggests that the behaviour at runtime will be the same
         * as before, and at compile time it confirms additional
         * type safety.
         */
        Class<BankAccount> baCls = BankAccount.class;

        try {

            /**
             * 3. The compiler complains because the variable
             * myAccount is of type Object and it cannot
             * be converted to BankAccount
            */
            //  Object myAccount = baCls.newInstance();

            /**
             * 4. Now the Storage.setValue(BankAccount)
             * method compiles (as it sees a BankAccount type),
             * but the assignment does not: the Object created
             * cannot be directly converted to a newInstance of
             * unknown Class type: this is because the compiler cannot
             * know which type of Class will have baCl at runtime,
             * so it cannot safely accept the assignment.
             */
            // BankAccount myAccount = baCls.newInstance();

            /**
             * 5. With dynamic cast, the Object can be 'converted',
             * in this case it just 'confirms' that the instance
             * created is of type BankAccount: the compiler will trust
             * this assignment which will be dynamically performed
             * at runtime by the JVM. It is not type safe: any casting
             * to a subclass of BankAccount will be accepted by the
             * compiler and will throw a ClassCastException at runtime
             */
            BankAccount myAccount = (BankAccount) baCls.newInstance();

             aStorage.setValue(myAccount);

            // Deposit
            myAccount.deposit(15);
        } catch (InstantiationException e) {
            // ...
        } catch (IllegalAccessException e) {
            // ...
        }

        /**
         * 7. It will print:
         *  115.0 // balance is set at 100 once created, +15 with after deposit()
         *  EQUAL   // both are object of class Storage, this is the type of both classes at runtime:
         *   // runtime does not deals with generics, as the compiler applies type erasure before runtime.
         */
        System.out.println(aStorage.getValue().showBalance());
        if(aStorage.getClass() == sStorage.getClass()) {
            System.out.println("EQUAL:");
        } else {
            System.out.println("NOT EQUAL");
        }


    }

}
