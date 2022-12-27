package nordigen.api.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import nordigen.model.AccountDetails;

import java.io.IOException;

public class AccountDetailsDeserializer extends StdDeserializer<AccountDetails> {

    public AccountDetailsDeserializer(){
        this(null);

    }

    protected AccountDetailsDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public AccountDetails deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        node = node.get("account");

        AccountDetails accountDetails = new AccountDetails();
        accountDetails.setResourceId(node.get("resourceId").asText());
        accountDetails.setIban(node.get("iban").asText());
        accountDetails.setCurrency(node.get("currency").asText());
        accountDetails.setOwnerName(node.get("ownerName").asText());
        accountDetails.setName(node.get("name") == null ? null : node.get("name").asText());
        accountDetails.setProduct(node.get("product").asText());
        accountDetails.setCashAccountType(node.get("cashAccountType") == null ?  null : node.get("cashAccountType").asText());

        return accountDetails;

    }
}
