package sample_code.di.decoupledwithfactory;

public interface MessageRenderer {
    void render();
    MessageProvider getMessageProvider();
    void setMessageProvider(MessageProvider provider);
}
