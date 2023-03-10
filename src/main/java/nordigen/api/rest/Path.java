package nordigen.api.rest;

public enum Path {
    TOKEN_NEW("/token/new/"),
    TOKEN_REFRESH("/token/refresh/"),
    INSTITUTION("/institutions/%s/"),
    INSTITUTIONS("/institutions/"),
    ENDUSERAGREEMENT("/agreements/enduser/%s/"),
    ENDUSERAGREEMENTS("/agreements/enduser/"),
    REQUISITION("/requisitions/%s/"),
    REQUISITIONS("/requisitions/"),
    ACCOUNT("/accounts/%s/"),
    ACCOUNT_DETAILS("/accounts/%s/details"),
    ACCOUNT_BALANCES("/accounts/%s/balances"),
    ACCOUNT_TRANSACTIONS_ALL("/accounts/%s/transactions/"),
    ACCOUNT_TRANSACTIONS_BY_DATE("/accounts/%s/transactions/?date_from=%s&date_from=%s");

    public static final String basePath = "https://ob.nordigen.com/api/v2";
    
    private String path;

    Path(String path) {
        this.path = basePath + path;
    }

    public String getPath() {
        return path;
    }
}
