package sample_code.guice;

public class PaypalCreditCardProcessor implements CreditCardProcessor {
    public String toString(){
        return getClass().getName();
    }
}
