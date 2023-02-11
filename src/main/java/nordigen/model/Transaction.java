package nordigen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nordigen.api.rest.CurrencyExchangeDeserializer;
import nordigen.api.rest.TransactionAmountDeserializer;

import java.util.Date;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Transaction {

    private String transactionId;
    private Date bookingDate;
    private Date valueDate;
    @JsonDeserialize(using = TransactionAmountDeserializer.class)
    private TransactionAmount transactionAmount;
    @JsonDeserialize(using = CurrencyExchangeDeserializer.class)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private CurrencyExchange currencyExchange;
    private String creditorName;
    private CreditorAccount creditorAccount;
    private String remittanceInformationUnstructured;
    private String remittanceInformationStructured;
    private String additionalInformation;
    private String internalTransactionId;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getValueDate() {
        return valueDate;
    }

    public void setValueDate(Date valueDate) {
        this.valueDate = valueDate;
    }

    public TransactionAmount getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(TransactionAmount transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public CurrencyExchange getCurrencyExchange() {
        return currencyExchange;
    }

    public void setCurrencyExchange(CurrencyExchange currencyExchange) {
        this.currencyExchange = currencyExchange;
    }

    public String getCreditorName() {
        return creditorName;
    }

    public void setCreditorName(String creditorName) {
        this.creditorName = creditorName;
    }

    public CreditorAccount getCreditorAccount() {
        return creditorAccount;
    }

    public void setCreditorAccount(CreditorAccount creditorAccount) {
        this.creditorAccount = creditorAccount;
    }

    public String getRemittanceInformationUnstructured() {
        return remittanceInformationUnstructured;
    }

    public void setRemittanceInformationUnstructured(String remittanceInformationUnstructured) {
        this.remittanceInformationUnstructured = remittanceInformationUnstructured;
    }

    public String getRemittanceInformationStructured() {
        return remittanceInformationStructured;
    }

    public void setRemittanceInformationStructured(String remittanceInformationStructured) {
        this.remittanceInformationStructured = remittanceInformationStructured;
    }

    public String getAdditionalInformation() {
        return additionalInformation;
    }

    public void setAdditionalInformation(String additionalInformation) {
        this.additionalInformation = additionalInformation;
    }

    public String getInternalTransactionId() {
        return internalTransactionId;
    }

    public void setInternalTransactionId(String internalTransactionId) {
        this.internalTransactionId = internalTransactionId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", bookingDate=" + bookingDate +
                ", valueDate=" + valueDate +
                ", transactionAmount=" + transactionAmount +
                ", currencyExchange=" + currencyExchange +
                ", creditorName='" + creditorName + '\'' +
                ", creditorAccount=" + creditorAccount +
                ", remittanceInformationUnstructured='" + remittanceInformationUnstructured + '\'' +
                ", remittanceInformationStructured='" + remittanceInformationStructured + '\'' +
                ", additionalInformation='" + additionalInformation + '\'' +
                ", internalTransactionId='" + internalTransactionId + '\'' +
                '}';
    }
}
