package nordigen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

    @JsonProperty("id")
    private String id;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("last_accessed")
    private Date lastAccessed;
    @JsonProperty("iban")
    private String iban;
    @JsonProperty("institution_id")
    private String institutionId;
    @JsonProperty("status")
    private String status;
    @JsonProperty("owner_name")
    private String ownerName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(Date lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", lastAccessed=" + lastAccessed +
                ", iban='" + iban + '\'' +
                ", institutionId='" + institutionId + '\'' +
                ", status='" + status + '\'' +
                ", ownerName='" + ownerName + '\'' +
                '}';
    }
}
