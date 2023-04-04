package nordigen.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum AccessScope {
    BALANCES("balances"), DETAILS("details"), TRANSACTIONS("transactions");

    private final String name;

    AccessScope(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName(){
        return name;
    }
}
