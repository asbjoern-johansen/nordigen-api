package nordigen.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import nordigen.model.AccountDetails;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestAccountDetailsDeserializer {

    @Test
    public void testCustomDeserializer() throws IOException {
        String json = "{\n" +
                "  \"account\": {\n" +
                "    \"resourceId\": \"string\",\n" +
                "    \"iban\": \"string\",\n" +
                "    \"currency\": \"string\",\n" +
                "    \"ownerName\": \"string\",\n" +
                "    \"name\": \"string\",\n" +
                "    \"product\": \"string\",\n" +
                "    \"cashAccountType\": \"string\"\n" +
                "  }\n" +
                "}";

        AccountDetails accountDetails = new ObjectMapper().readValue(json, AccountDetails.class);
        System.out.println(accountDetails);
        Assertions.assertEquals("string", accountDetails.getResourceId());
    }
}
