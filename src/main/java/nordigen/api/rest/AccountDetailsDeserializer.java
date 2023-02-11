package nordigen.api.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import nordigen.model.AccountDetails;

import java.io.IOException;
import java.util.Currency;

public class AccountDetailsDeserializer extends JsonDeserializer<AccountDetails> {

    @Override
    public AccountDetails deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        node = node.get("account");

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setResourceId(node.get("resourceId").asText());
        accountDetails.setIban(node.get("iban").asText());
        accountDetails.setCurrency(Currency.getInstance(node.get("currency").asText()));
        accountDetails.setOwnerName(node.get("ownerName").asText());
        accountDetails.setName(node.get("name") == null ? null : node.get("name").asText());
        accountDetails.setProduct(node.get("product").asText());
        accountDetails.setCashAccountType(node.get("cashAccountType") == null ?  null : node.get("cashAccountType").asText());

        return accountDetails;

    }
}
