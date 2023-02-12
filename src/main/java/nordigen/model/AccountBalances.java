package nordigen.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import nordigen.api.rest.AccountBalancesDeserializer;

import java.util.ArrayList;
import java.util.List;

@JsonDeserialize(using = AccountBalancesDeserializer.class)
public class AccountBalances {

    private List<AccountBalance> accountBalances = new ArrayList<>();

    public List<AccountBalance> getAccountBalances() {
        return accountBalances;
    }

    public void setAccountBalances(List<AccountBalance> accountBalances) {
        this.accountBalances = accountBalances;
    }

    @Override
    public String toString() {
        return "AccountBalances{" +
                "accountBalances=" + accountBalances +
                '}';
    }
}
