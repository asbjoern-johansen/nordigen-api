package nordigen.api;
import nordigen.api.rest.NordigenRestApi;
import nordigen.model.*;
import org.junit.Ignore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


//https://nordigen.com/en/docs/account-information/integration/parameters-and-responses/
@Ignore("Integration Test")
public class TestApi {

    private NordigenApi nordigenApi;
    private String accountId = "e25a75ea-b224-4539-85a8-ba750e739200";

    @BeforeEach
    public void setup() throws IOException {
        SecretProperties secretProperties = new SecretProperties("http/http-client.private.env.json");

        NordigenApiFactory.setFactory(
                new NordigenApiFactory() {
                    @Override
                    protected NordigenApi create() {
                        return new NordigenRestApi(secretProperties.getSecretId(), secretProperties.getSecretKey());
                    }
                }
        );

        nordigenApi = NordigenApiFactory.getApi();
    }

    @Test
    public void testGetEndUserAgreements() throws NordigenApiException {
        //Fetch All Enduser Agreements and fetch individual agreement
        for (EndUserAgreement endUserAgreement : nordigenApi.getEndUserAgreements().getResults()) {
            //endUserAgreement =  nordigenApi.getEndUserAgreement(endUserAgreement.getId());
        }
    }

    @Test
    public void testDeleteEnduserAgreement() throws NordigenApiException {
        nordigenApi.deleteEndUserAgreement("8735f0ef-5ad5-4a08-9561-c9cba4011216");
    }

    @Test
    public void testDeleteRequisition() throws NordigenApiException {
        nordigenApi.deleteRequisition("6e837d44-20d8-417e-bbb8-888732e9b6fc");
    }

    @Test
    public void testCreateEndUserAgreementAndRequisition() throws NordigenApiException {
        EndUserAgreement endUserAgreement = new EndUserAgreement();
        endUserAgreement.addAccessScope(AccessScope.balances, AccessScope.details, AccessScope.transactions);
        endUserAgreement.setInstitutionId("NORDEA_NDEADKKK");
        endUserAgreement.setAccessValidForDays(90);
        endUserAgreement.setMaxHistoricalDays(90);

        endUserAgreement = nordigenApi.createEndUserAgreement(endUserAgreement);
        System.out.println(endUserAgreement);

        Requisition requisition = new Requisition();
        requisition.setRedirect("http://139.162.168.199:9999/callback");
        requisition.setInstitutionId("NORDEA_NDEADKKK");
        requisition.setAgreement(endUserAgreement.getId());
        requisition.setReference("123123");
        //requisition.setSsn      ("1803781067");
        requisition.setUserLanguage(Country.GB.getLanguageCode());

        requisition = nordigenApi.createRequisition(requisition);
        System.out.println(requisition);
    }

    @Test
    public void testGetRequisitions() throws NordigenApiException {

        /*for(Requisition requisition : nordigenApi.getRequisitions().getResults()){
            requisition = nordigenApi.getRequisition(requisition.getId());
        }*/

        System.out.println(nordigenApi.getRequisition("6e837d44-20d8-417e-bbb8-888732e9b6fc"));
    }

    @Test
    public void testGetAccount() throws NordigenApiException {
        Account account = nordigenApi.getAccount(accountId);
        AccountDetails accountDetails = nordigenApi.getAccountDetails(accountId);
        System.out.println(accountDetails);
    }

    @Test
    public void testGetAccountBalances() throws NordigenApiException {
        AccountBalances accountBalances = nordigenApi.getAccountBalances(accountId);
        System.out.println(accountBalances);
    }


    @Test
    public void testGetInstitutions() throws NordigenApiException {
        for (Institution institution : nordigenApi.getInstitutions(Country.DK)) {
            institution = nordigenApi.getInstitution(institution.getId());
            System.out.println(institution);
        }
    }

    @Test
    public void getTransactions() throws NordigenApiException {
        Transactions transactions = nordigenApi.getTransactions(accountId);

        transactions.getBooked().forEach(System.out::println);
        transactions.getPending().forEach(System.out::println);
    }

    @Test
    public void getTransactionsByDate() throws NordigenApiException {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        Date start = calendar.getTime();
        calendar.add(Calendar.MONTH, 1);
        Date end = calendar.getTime();

        System.out.println("Start: "+ start);
        System.out.println("End: " + end);

        Transactions transactions = nordigenApi.getTransactions(accountId, start, end);

        transactions.getBooked().forEach(System.out::println);
        transactions.getPending().forEach(System.out::println);

    }
}
