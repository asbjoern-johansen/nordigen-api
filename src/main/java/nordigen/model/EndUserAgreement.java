package nordigen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EndUserAgreement {

    @JsonProperty("id")
    private String id;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("max_historical_days")
    private Integer maxHistoricalDays = 90;
    @JsonProperty("access_valid_for_days")
    private Integer accessValidForDays = 90;
    @JsonProperty("access_scope")
    private List<AccessScope> accessScope;
    @JsonProperty("accepted")
    private Date accepted;
    @JsonProperty("institution_id")
    private String institutionId;

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

    public Integer getMaxHistoricalDays() {
        return maxHistoricalDays;
    }

    public void setMaxHistoricalDays(Integer maxHistoricalDays) {
        this.maxHistoricalDays = maxHistoricalDays;
    }

    public Integer getAccessValidForDays() {
        return accessValidForDays;
    }

    public void setAccessValidForDays(Integer accessValidForDays) {
        this.accessValidForDays = accessValidForDays;
    }

    public List<AccessScope> getAccessScope() {
        return accessScope;
    }

    public void setAccessScope(List<AccessScope> accessScope) {
        this.accessScope = accessScope;
    }

    public void addAccessScope(AccessScope ...accessScopes){
        Arrays.stream(accessScopes).forEach(scope -> this.accessScope.add(scope));
    }

    public Date getAccepted() {
        return accepted;
    }

    public void setAccepted(Date accepted) {
        this.accepted = accepted;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    @Override
    public String toString() {
        return "EndUserAgreement{" +
                "id='" + id + '\'' +
                ", created=" + created +
                ", maxHistoricalDays=" + maxHistoricalDays +
                ", accessValidForDays=" + accessValidForDays +
                ", accessScope=" + accessScope +
                ", accepted=" + accepted +
                ", institutionId='" + institutionId + '\'' +
                '}';
    }
}
