package adapter;

import lombok.Data;

/**
 *
 */

@Data
public class XpayImpl implements Xpay {
    private String creditCardNo;
    private String customerName;
    private String cardExpMonth;
    private String cardExpYear;
    private Short cardCVVNo;
    private Double amount;

    @Override
    public String getCreditCardNo() {
        return null;
    }

    @Override
    public void setCreditCardNo(String creditCardNo) {

    }

    @Override
    public String getCustomerName() {
        return null;
    }

    @Override
    public void setCustomerName(String customerName) {

    }

    @Override
    public String getCardExpMonth() {
        return null;
    }

    @Override
    public void setCardExpMonth(String cardExpMonth) {

    }

    @Override
    public String getCardExpYear() {
        return null;
    }

    @Override
    public void setCardExpYear(String cardExpYear) {

    }

    @Override
    public Short getCardCVVNo() {
        return null;
    }

    @Override
    public void setCardCVVNo(Short cardCVVNo) {

    }

    @Override
    public Double getAmount() {
        return null;
    }

    @Override
    public void setAmount(Double amount) {

    }
}
