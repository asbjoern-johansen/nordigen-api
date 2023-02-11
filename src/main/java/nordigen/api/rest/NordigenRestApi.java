package nordigen.api.rest;

import nordigen.api.NordigenApi;
import nordigen.api.NordigenApiException;
import nordigen.model.*;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.logging.LoggingFeature;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;

import static nordigen.api.rest.Path.*;

public class NordigenRestApi implements NordigenApi {

    private static final String BEARER = "Bearer ";

    private String secretId;
    private String secretKey;

    private Client      client      = null;
    private AccessToken accessToken = null;


    public NordigenRestApi(String secretId, String secretKey) {
        this.secretId  = secretId;
        this.secretKey = secretKey;

        this.client = ClientBuilder.newClient(loggingClient());
    }

    private Invocation.Builder requestBuilder(String uri, HashMap<String, String> parameters) throws NordigenApiException {
        WebTarget webTarget = client.target(uri);

        for(String key : parameters.keySet()){
            webTarget = webTarget.queryParam(key, parameters.get(key));
        }

        return webTarget
                .request()
                .accept(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION, getAuthorization());
    }

    private Invocation.Builder requestBuilder(String uri) throws NordigenApiException {
        return this.requestBuilder(uri, new HashMap<>());
    }

    @Override
    public EndUserAgreement createEndUserAgreement(EndUserAgreement endUserAgreement) throws NordigenApiException {
        Response response = requestBuilder(ENDUSERAGREEMENTS.getPath()).post(Entity.json(endUserAgreement));
        return checkForError(response).readEntity(EndUserAgreement.class);

    }

    @Override
    public void deleteEndUserAgreement(String id) throws NordigenApiException {
        Response response = requestBuilder(String.format(ENDUSERAGREEMENT.getPath(), id))
                .delete();
        checkForError(response);
    }

    @Override
    public EndUserAgreement getEndUserAgreement(String id) throws NordigenApiException {
        Response response = requestBuilder(String.format(ENDUSERAGREEMENT.getPath(), id))
                .get();
        return checkForError(response).readEntity(EndUserAgreement.class);
    }

    @Override
    public EndUserAgreements getEndUserAgreements() throws NordigenApiException {
        Response response = requestBuilder(ENDUSERAGREEMENTS.getPath())
                .get();

        return checkForError(response).readEntity(EndUserAgreements.class);
    }

    @Override
    public Requisitions getRequisitions()  throws NordigenApiException {
        Response response = requestBuilder(REQUISITIONS.getPath())
                .get();

        return checkForError(response).readEntity(Requisitions.class);
    }

    @Override
    public Requisition getRequisition(String id) throws NordigenApiException {
        Response response = requestBuilder(String.format(REQUISITION.getPath(), id))
                .get();

        return checkForError(response).readEntity(Requisition.class);
    }

    @Override
    public Requisition createRequisition(Requisition requisition) throws NordigenApiException {
        Response response = requestBuilder(REQUISITIONS.getPath()).post(Entity.json(requisition));
        return checkForError(response).readEntity(Requisition.class);
    }

    @Override
    public void deleteRequisition(String id) throws NordigenApiException {
        Response response = requestBuilder(String.format(REQUISITION.getPath(), id))
                .delete();
        checkForError(response);
    }

    @Override
    public Account getAccount(String id) throws NordigenApiException {
        Response response = requestBuilder(String.format(ACCOUNT.getPath(), id))
                .get();
        return checkForError(response).readEntity(Account.class);
    }

    @Override
    public AccountDetails getAccountDetails(String id) throws NordigenApiException {
        Response response = requestBuilder(String.format(ACCOUNTDETAILS.getPath(), id))
                .get();
        return checkForError(response).readEntity(AccountDetails.class);
    }

    @Override
    public Institution getInstitution(String id) throws NordigenApiException {
        Response response = requestBuilder(String.format(INSTITUTION.getPath(), id))
                .get();
        return checkForError(response).readEntity(Institution.class);
    }

    @Override
    public List<Institution> getInstitutions() throws NordigenApiException {
        Response response = requestBuilder(INSTITUTIONS.getPath())
                .get();
        return checkForError(response).readEntity(new GenericType<List<Institution>>(){});
    }

    @Override
    public List<Institution> getInstitutions(Country country) throws NordigenApiException {
        Response response = requestBuilder(INSTITUTIONS.getPath(), new HashMap<>(){{
            put("country", country.name());
        }}).get();

        return checkForError(response).readEntity(new GenericType<List<Institution>>(){});
    }

    @Override
    public Transactions getTransactions(String accountId) throws NordigenApiException {
        Response response = requestBuilder(String.format(ACCOUNT_TRANSACTIONS_ALL.getPath(), accountId))
                .get();
        return checkForError(response).readEntity(Transactions.class);
    }

    ////////////////////////////////////////////////////////////////////////

    protected AccessToken getNewAccessToken() throws NordigenApiException {
        Response response =
                client.target(TOKEN_NEW.getPath())
                        .request()
                        .accept(MediaType.APPLICATION_JSON)
                        .post(Entity.json(new Secret(secretId, secretKey)));

        checkForError(response);

        return response.readEntity(AccessToken.class);
    }

    protected AccessToken refreshAccessToken() throws NordigenApiException {
        Response response =
                client.target(TOKEN_REFRESH.getPath())
                        .request()
                        .accept(MediaType.APPLICATION_JSON)
                        .post(Entity.json(new RefreshRequest(accessToken.getRefresh())));

        checkForError(response);

        return response.readEntity(AccessToken.class);
    }

    protected String getAuthorization() throws NordigenApiException {
        if(accessToken == null || accessToken.isRefreshExpired() ){
            accessToken = getNewAccessToken();

        }else if (accessToken.isAccessExpired() ) {
            accessToken = refreshAccessToken();
        }

        return BEARER + accessToken.getAccess();
    }

    protected Response checkForError(Response response) throws NordigenApiException {
        boolean valid = response.getStatus() == Response.Status.OK.getStatusCode() ||
                        response.getStatus() == Response.Status.CREATED.getStatusCode();

        if(valid == false){
            throw response.readEntity(ErrorResponseException.class);
        }
        return response;
    }


    // this configures the client to log all rest data to stdout
    private ClientConfig loggingClient() {
        ClientConfig config = new ClientConfig();
        config.register(new LoggingFeature(java.util.logging.Logger.getLogger(LoggingFeature.DEFAULT_LOGGER_NAME),
                Level.INFO, LoggingFeature.Verbosity.PAYLOAD_TEXT, 100000));
        return config;
    }
}
