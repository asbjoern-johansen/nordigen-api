package nordigen.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Requisition {

    @JsonProperty("id")
    private String id;

    @JsonProperty("created")
    private Date created;

    @JsonProperty("redirect")
    private String redirect;

    //"status": "CR",
    @JsonProperty("status")
    private String status;

    @JsonProperty("institution_id")
    private String institutionId;

    @JsonProperty("agreement")
    private String agreement;

    @JsonProperty("reference")
    private String reference;

    @JsonProperty("accounts")
    private List<String> accounts;

    @JsonProperty("user_language")
    private String userLanguage;

    @JsonProperty("link")
    private String link;

    @JsonProperty("ssn")
    private String ssn;

    @JsonProperty("account_selection")
    private boolean accountSelection;

    @JsonProperty("redirect_immediate")
    private boolean redirectImmediate;

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

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public List<String> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<String> accounts) {
        this.accounts = accounts;
    }

    public String getUserLanguage() {
        return userLanguage;
    }

    public void setUserLanguage(String userLanguage) {
        this.userLanguage = userLanguage;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public boolean isAccountSelection() {
        return accountSelection;
    }

    public void setAccountSelection(boolean accountSelection) {
        this.accountSelection = accountSelection;
    }

    public boolean isRedirectImmediate() {
        return redirectImmediate;
    }

    public void setRedirectImmediate(boolean redirectImmediate) {
        this.redirectImmediate = redirectImmediate;
    }
}
