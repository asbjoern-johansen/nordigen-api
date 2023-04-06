package nordigen.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import nordigen.model.Requisition;
import nordigen.model.Transactions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestRequisitionDeserializer {
    private String json = "{\n" +
            " \"id\": \"781b7121-c1f8-45c7-b64a-6e39ab4dfa0a\",\n" +
            " \"created\": \"2022-07-19T21:51:05.060134Z\",\n" +
            " \"redirect\": \"http://139.162.168.199:9999/callback\",\n" +
            " \"status\": \"CR\",\n" +
            " \"institution_id\": \"NORDEA_NDEADKKK\",\n" +
            " \"agreement\": \"aa5ef477-4962-4c06-b123-b0763bdf7735\",\n" +
            " \"reference\": \"12345\",\n" +
            " \"accounts\": [],\n" +
            " \"user_language\": \"EN\",\n" +
            " \"link\": \"https://ob.nordigen.com/psd2/start/781b7121-c1f8-45c7-b64a-6e39ab4dfa0a/NORDEA_NDEADKKK\",\n" +
            " \"ssn\": null,\n" +
            " \"account_selection\": false,\n" +
            " \"redirect_immediate\": false\n" +
            "}";


    @Test
    public void testDeserialization() throws IOException {
        Requisition requisition = new ObjectMapper().readValue(json, Requisition.class);
        System.out.println(requisition);
    }

}
