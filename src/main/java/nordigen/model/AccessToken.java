package nordigen.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class AccessToken {

    //access token
    @JsonProperty("access")
    private String access;

    //refresh token
    @JsonProperty("refresh")
    private String refresh;

    //Access token expires in seconds
    @JsonProperty("access_expires")
    private int accessExpires;

    //Refresh token expires in seconds
    @JsonProperty("refresh_expires")
    private int refreshExpires;

    //Expiry date in milliseconds since January 1, 1970, 00:00:00 GMT
    private long accessExpireTimeMillis = Long.MAX_VALUE;
    private long refreshExpireTimeMillis = Long.MAX_VALUE;;

    public AccessToken() {
    }

    public AccessToken(String access, String refresh, int accessExpires, int refreshExpires) {
        this.access = access;
        this.refresh = refresh;
        this.accessExpires = accessExpires;
        this.refreshExpires = refreshExpires;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public int getAccessExpires() {
        return accessExpires;
    }

    public void setAccessExpires(int accessExpires) {
        this.accessExpires = accessExpires;
        this.accessExpireTimeMillis = new Date().getTime() + accessExpires * 1000L;
    }

    public int getRefreshExpires() {
        return refreshExpires;
    }

    public void setRefreshExpires(int refreshExpires) {
        this.refreshExpires = refreshExpires;
        this.refreshExpireTimeMillis = new Date().getTime() + refreshExpires * 1000L;
    }

    public boolean isAccessExpired(){
        return new Date().getTime() > this.accessExpireTimeMillis;
    }

    public boolean isRefreshExpired() {
        return new Date().getTime() > this.refreshExpireTimeMillis;
    }

    @Override
    public String toString() {
        return "AccessToken{" +
                "access='" + access + '\'' +
                ", refresh='" + refresh + '\'' +
                ", accessExpires=" + accessExpires +
                ", refreshExpires=" + refreshExpires +
                '}';
    }


}
