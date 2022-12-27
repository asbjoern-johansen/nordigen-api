package nordigen.api.rest;

import nordigen.api.NordigenApiException;
import nordigen.model.AccessToken;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestGetAccessTokenAndRefresh {


    private NordigenRestApi api;
    private AccessToken accessToken;
    private int newAccessTokenCalled;
    private int refreshTokenCalled;


    @BeforeEach
    public void setup(){
        api = new NordigenRestApi("",""){
            @Override
            protected AccessToken getNewAccessToken() {
                newAccessTokenCalled++;
                return accessToken;
            }

            @Override
            protected AccessToken refreshAccessToken(){
                refreshTokenCalled++;
                return accessToken;
            }
        };

        newAccessTokenCalled = 0;
        refreshTokenCalled   = 0;

        accessToken = new AccessToken();
    }

    @Test
    public void firstAuthGetsANewAccessToken() throws NordigenApiException {
        //First call always gets a new Access Token
        api.getAuthorization();
        Assertions.assertEquals(1, newAccessTokenCalled);
    }

    @Test
    public void expiredAccessRefreshesAccessToken() throws NordigenApiException {
        //First call gets a new Access Token
        api.getAuthorization();
        Assertions.assertEquals(1, newAccessTokenCalled);
        //Expired accessToken refreshes accessToken
        accessToken.setAccessExpires(-1); //Expired one second ago
        api.getAuthorization();
        Assertions.assertEquals(1, refreshTokenCalled);
    }

    @Test
    public void expiredRefreshGetsNewAccessToken() throws NordigenApiException {
        //First call gets a new Access Token
        api.getAuthorization();
        Assertions.assertEquals(1, newAccessTokenCalled);
        //Expired refresh gets new accessToken
        accessToken.setRefreshExpires(-1); //Expired one second ago
        api.getAuthorization();
        Assertions.assertEquals(2, newAccessTokenCalled);
    }
}
