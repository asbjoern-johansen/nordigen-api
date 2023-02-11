package nordigen.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import nordigen.model.Transactions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class TestTransactionsDeserializer {
    private String json = "{\n" +
            "  \"transactions\": {\n" +
            "    \"booked\": [\n" +
            "      {\n" +
            "        \"transactionId\": \"H07235926740000004462\",\n" +
            "        \"bookingDate\": \"2023-02-07\",\n" +
            "        \"valueDate\": \"2023-02-07\",\n" +
            "        \"transactionAmount\": {\n" +
            "          \"amount\": \"-480.00\",\n" +
            "          \"currency\": \"DKK\"\n" +
            "        },\n" +
            "        \"creditorName\": \"2000\",\n" +
            "        \"creditorAccount\": {\n" +
            "          \"iban\": \"4393113648\"\n" +
            "        },\n" +
            "        \"remittanceInformationUnstructured\": \"Bgs Jpop\",\n" +
            "        \"remittanceInformationStructured\": \"Jpop\",\n" +
            "        \"additionalInformation\": \"BGS\",\n" +
            "        \"internalTransactionId\": \"ff55d9dbf53f0cdede02f1b54e7066f2\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"transactionId\": \"H07235926740000004461\",\n" +
            "        \"bookingDate\": \"2023-02-07\",\n" +
            "        \"valueDate\": \"2023-02-07\",\n" +
            "        \"transactionAmount\": {\n" +
            "          \"amount\": \"-1517.58\",\n" +
            "          \"currency\": \"DKK\"\n" +
            "        },\n" +
            "        \"creditorAccount\": {\n" +
            "          \"iban\": \"0\"\n" +
            "        },\n" +
            "        \"remittanceInformationUnstructured\": \"Bs betaling ANDEL ENERGI A/S\",\n" +
            "        \"additionalInformation\": \"BS BETALING\",\n" +
            "        \"internalTransactionId\": \"8eaff1549a9c567b2d6f381fdf1e5d16\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"pending\": []\n" +
            "  }\n" +
            "}";


    @Test
    public void testDeserialization() throws IOException {
        Transactions transactions = new ObjectMapper().readValue(json, Transactions.class);
        System.out.println(transactions);
    }

}
