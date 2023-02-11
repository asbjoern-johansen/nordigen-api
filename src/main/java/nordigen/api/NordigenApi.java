package nordigen.api;

import nordigen.model.*;

import java.util.List;

public interface NordigenApi {


    EndUserAgreement getEndUserAgreement(String id) throws NordigenApiException;
    EndUserAgreements getEndUserAgreements() throws NordigenApiException;
    EndUserAgreement createEndUserAgreement(EndUserAgreement endUserAgreement) throws NordigenApiException;
    void deleteEndUserAgreement(String id) throws NordigenApiException;
    List<Institution> getInstitutions() throws NordigenApiException;
    List<Institution> getInstitutions(Country country) throws NordigenApiException;
    Institution getInstitution(String id) throws NordigenApiException;
    Requisitions getRequisitions()  throws NordigenApiException ;
    Requisition getRequisition(String id) throws NordigenApiException;
    Requisition createRequisition(Requisition requisition) throws NordigenApiException;
    void deleteRequisition(String id) throws NordigenApiException;
    Account getAccount(String id) throws NordigenApiException;
    AccountDetails getAccountDetails(String id) throws NordigenApiException;
    Transactions getTransactions(String accountId) throws NordigenApiException;
}
