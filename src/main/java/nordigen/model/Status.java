package nordigen.model;

public enum Status {

    CR(1, "CREATED",                   "Requisition has been successfully created"),
    GC(2, "GIVING_CONSENT",            "End-user is giving consent at Nordigen's consent screen"),
    UA(3, "UNDERGOING_AUTHENTICATION",	"End-user is redirected to the financial institution for authentication"),
    RJ(4, "REJECTED",	                "Either SSN verification has failed or end-user has entered incorrect credentials"),
    SA(5, "SELECTING_ACCOUNTS",        "End-user is selecting accounts"),
    GA(6, "GRANTING_ACCESS",	        "End-user is granting access to their account information"),
    LN(7, "LINKED",                    "Account has been successfully linked to requisition"),
    SU(8, "SUSPENDED",	                "Requisition is suspended due to numerous consecutive errors that happened while accessing its accounts"),
    EX(9, "EXPIRED",	                "Access to accounts has expired as set in End User Agreement");

    private int     stage;
    private String  status;
    private String  description;

    Status(int stage, String status, String description) {
        this.stage = stage;
        this.status = status;
        this.description = description;
    }

    public int getStage() {
        return stage;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}
