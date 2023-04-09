package nordigen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Represents an ASPSP.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Institution {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("bic")
    private String bic;

    @JsonProperty("transaction_total_days")
    private String transactionTotalDays; //default: 90

    @JsonProperty("countries")
    private List<Country> countries;

    @JsonProperty("logo")
    private String logo;

    /*@JsonProperty("supported_payments")
    "supported_payments":{"single-payment":["SCT"]},
     */

    /*@JsonProperty("supported_features")
    "supported_features":["payments"]}
    */

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBic() {
        return bic;
    }

    public void setBic(String bic) {
        this.bic = bic;
    }

    public String getTransactionTotalDays() {
        return transactionTotalDays;
    }

    public void setTransactionTotalDays(String transactionTotalDays) {
        this.transactionTotalDays = transactionTotalDays;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Override
    public String toString() {
        return "Institution{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", bic='" + bic + '\'' +
                ", transactionTotalDays='" + transactionTotalDays + '\'' +
                ", countries=" + countries +
                ", logo='" + logo + '\'' +
                '}';
    }
}
