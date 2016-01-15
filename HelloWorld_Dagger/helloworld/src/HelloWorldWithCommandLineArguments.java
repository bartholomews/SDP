/**
 * This version externalises the message content and read it in at runtime,
 * from the command line argument: the message can be changed without
 * refactoring and recompiling the code: anyway this solution doesn't solve
 * possible implementation-level dependencies.
 */
public class HelloWorldWithCommandLineArguments {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println(args[0]);
        } else {
            System.out.println("Hello World!");
        }
    }
}