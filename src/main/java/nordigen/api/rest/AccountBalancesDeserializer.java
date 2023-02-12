package nordigen.api.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nordigen.model.AccountBalance;
import nordigen.model.AccountBalances;

import java.io.IOException;
import java.util.List;

public class AccountBalancesDeserializer extends JsonDeserializer<AccountBalances> {

    @Override
    public AccountBalances deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();

        AccountBalances accountBalances = new AccountBalances();

        accountBalances.setAccountBalances(
                mapper.readValue(node.get("balances").toString(), new TypeReference<List<AccountBalance>>() {})
        );

        return accountBalances;
    }
}
