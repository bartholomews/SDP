package sample_code.springdi.di;

public class HelloWorldMessageProvider implements MessageProvider {

    @Override
    public String getMessage() {

        return "Hello World!";
    }

}