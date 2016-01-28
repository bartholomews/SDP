package factory_method;

/**
 *
 */
public class Test {
    Application app;

    public Test() {
        app = new Application(new ConcreteCreator());
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.app.launch();
    }

}