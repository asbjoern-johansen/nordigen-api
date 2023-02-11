package nordigen.api.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import nordigen.model.Transaction;
import nordigen.model.Transactions;

import java.io.IOException;
import java.util.List;

public class TransactionsDeserializer extends JsonDeserializer<Transactions> {

    @Override
    public Transactions deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {

        Transactions transactions = new Transactions();

        ObjectMapper mapper = (ObjectMapper) jsonParser.getCodec();
        JsonNode node = mapper.readTree(jsonParser);

        node = node.get("transactions");

        processTransactions(node,"booked",  transactions.getBooked(),  mapper);
        processTransactions(node,"pending", transactions.getPending(), mapper);

        return transactions;
    }

    private void processTransactions(JsonNode jsonNode, String element, List<Transaction> transactions, ObjectMapper mapper){
        jsonNode.get(element).elements().forEachRemaining(transactionNode -> transactions.add(
                readValue(mapper, transactionNode, Transaction.class)
        ));
    }


    private <T> T readValue(ObjectMapper mapper, JsonNode transactionNode, Class<T> clazz) {
        try {
            return mapper.readValue(transactionNode.toString(), clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
