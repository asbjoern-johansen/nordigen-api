package nordigen.model;


import java.math.BigDecimal;
import java.util.Currency;

public class Amount {

    private BigDecimal amount;
    private Currency currency;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "TransactionAmount{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }
}
