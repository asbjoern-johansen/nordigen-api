package nordigen.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nordigen.api.rest.AmountDeserializer;

public class AccountBalance {

    @JsonDeserialize(using = AmountDeserializer.class)
    private Amount balanceAmount;
    private String balanceType;

    public Amount getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Amount balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String getBalanceType() {
        return balanceType;
    }

    public void setBalanceType(String balanceType) {
        this.balanceType = balanceType;
    }

    @Override
    public String toString() {
        return "AccountBalance{" +
                "balanceAmount=" + balanceAmount +
                ", balanceType='" + balanceType + '\'' +
                '}';
    }
}
