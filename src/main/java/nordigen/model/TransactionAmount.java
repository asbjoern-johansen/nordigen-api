package nordigen.model;


import java.util.Currency;

public class TransactionAmount {

    private Double amount;
    private Currency currency;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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
