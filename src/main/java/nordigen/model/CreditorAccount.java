package nordigen.model;

public class CreditorAccount {

    private String iban;

    private String bban;

    public CreditorAccount() {
    }

    public CreditorAccount(String iban, String bban) {
        this.iban = iban;
        this.bban = bban;
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

    public String getBban() {
        return bban;
    }

    public void setBban(String bban) {
        this.bban = bban;
    }
}
