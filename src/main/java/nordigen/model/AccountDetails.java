package nordigen.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nordigen.api.rest.AccountDetailsDeserializer;

@JsonDeserialize(using = AccountDetailsDeserializer.class)
public class AccountDetails {

    private String resourceId;
    private String iban;
    private String currency;
    private String ownerName;
    private String name;
    private String product;
    private String cashAccountType;

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCashAccountType() {
        return cashAccountType;
    }

    public void setCashAccountType(String cashAccountType) {
        this.cashAccountType = cashAccountType;
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "resourceId='" + resourceId + '\'' +
                ", iban='" + iban + '\'' +
                ", currency='" + currency + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", name='" + name + '\'' +
                ", product='" + product + '\'' +
                ", cashAccountType='" + cashAccountType + '\'' +
                '}';
    }
}
