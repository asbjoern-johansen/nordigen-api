package nordigen.api.rest;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Secret {

    @JsonProperty("secret_id")
    private String secretId;

    @JsonProperty("secret_key")
    private String secretKey;

    public Secret(String secretId, String secretKey) {
        this.secretId  = secretId;
        this.secretKey = secretKey;
    }


    public String getSecretId() {
        return secretId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
