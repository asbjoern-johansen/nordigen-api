package nordigen.api.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import nordigen.model.CurrencyExchange;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Currency;

public class CurrencyExchangeDeserializer extends JsonDeserializer<CurrencyExchange> {
    ;
    private DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public CurrencyExchange deserialize(JsonParser jsonParser, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        //For some reason this is represented as a list
        node = node.elements().next();

        CurrencyExchange currencyExchange = new CurrencyExchange();
        currencyExchange.setSourceCurrency(Currency.getInstance(node.get("sourceCurrency").asText()));
        currencyExchange.setExchangeRate(Double.parseDouble(node.get("exchangeRate").asText()));
        currencyExchange.setUnitCurrency(Currency.getInstance(node.get("unitCurrency").asText()));
        currencyExchange.setTargetCurrency(Currency.getInstance(node.get("targetCurrency").asText()));
        try {
            currencyExchange.setQuotationDate(dateFormat.parse(node.get("quotationDate").asText()));
        } catch (ParseException e) {
            throw new IOException(e);
        }

        return currencyExchange;
    }
}
