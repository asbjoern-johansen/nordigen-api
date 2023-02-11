package nordigen.model;

public class CreditorAccount {

    private String iban;

    public CreditorAccount() {
    }

    public CreditorAccount(String iban) {
        this.iban = iban;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "CreditorAccount{" +
                "iban='" + iban + '\'' +
                '}';
    }
}
