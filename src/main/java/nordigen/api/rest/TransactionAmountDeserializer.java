package nordigen.api.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import nordigen.model.TransactionAmount;

import java.io.IOException;
import java.util.Currency;

public class TransactionAmountDeserializer extends JsonDeserializer<TransactionAmount> {

    @Override
    public TransactionAmount deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        TransactionAmount transactionAmount = new TransactionAmount();
        transactionAmount.setAmount(Double.parseDouble(node.get("amount").asText()));
        transactionAmount.setCurrency(Currency.getInstance(node.get("currency").asText()));
        return transactionAmount;
    }
}
