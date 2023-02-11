package nordigen.model;

import java.util.Currency;
import java.util.Date;

public class CurrencyExchange {
    private Currency sourceCurrency;
    private Double exchangeRate;
    private Currency unitCurrency;
    private Currency targetCurrency;
    private Date quotationDate;

    public Currency getSourceCurrency() {
        return sourceCurrency;
    }

    public void setSourceCurrency(Currency sourceCurrency) {
        this.sourceCurrency = sourceCurrency;
    }

    public Double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(Double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public Currency getUnitCurrency() {
        return unitCurrency;
    }

    public void setUnitCurrency(Currency unitCurrency) {
        this.unitCurrency = unitCurrency;
    }

    public Currency getTargetCurrency() {
        return targetCurrency;
    }

    public void setTargetCurrency(Currency targetCurrency) {
        this.targetCurrency = targetCurrency;
    }

    public Date getQuotationDate() {
        return quotationDate;
    }

    public void setQuotationDate(Date quotationDate) {
        this.quotationDate = quotationDate;
    }

    @Override
    public String toString() {
        return "CurrencyExchange{" +
                "sourceCurrency=" + sourceCurrency +
                ", exchangeRate=" + exchangeRate +
                ", unitCurrency=" + unitCurrency +
                ", targetCurrency=" + targetCurrency +
                ", quotationDate=" + quotationDate +
                '}';
    }
}
