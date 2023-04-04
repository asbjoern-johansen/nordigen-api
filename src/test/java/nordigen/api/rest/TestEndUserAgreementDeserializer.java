package nordigen.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import nordigen.model.EndUserAgreement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestEndUserAgreementDeserializer {

    @Test
    public void test() throws IOException {
        String json = "{\n" +
                "  \"id\": \"6b10eaa6-13fa-40eb-9a08-6e1996fb568c\",\n" +
                "  \"created\": \"2022-10-25T21:04:42.796473Z\",\n" +
                "  \"max_historical_days\": 180,\n" +
                "  \"access_valid_for_days\": 30,\n" +
                "  \"access_scope\": [\n" +
                "    \"balances\",\n" +
                "    \"details\",\n" +
                "    \"transactions\"\n" +
                "  ],\n" +
                "  \"accepted\": null,\n" +
                "  \"institution_id\": \"NORDEA_NDEADKKK\"\n" +
                "}";

        System.out.println(json);

        EndUserAgreement endUserAgreement = new ObjectMapper().readValue(json, EndUserAgreement.class);
        System.out.println(endUserAgreement);
        Assertions.assertEquals("NORDEA_NDEADKKK", endUserAgreement.getInstitutionId());

    }
}
