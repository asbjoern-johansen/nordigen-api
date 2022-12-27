package nordigen.api.rest;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RefreshRequest {

    //refresh token
    @JsonProperty("refresh")
    private String refresh;

    public RefreshRequest(String refresh) {
        this.refresh = refresh;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }
}
