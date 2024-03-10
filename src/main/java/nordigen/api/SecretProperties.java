package nordigen.api;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;

public class SecretProperties {

    private String secretId  = "";
    private String secretKey = "";

    public SecretProperties() throws IOException {
        this("http/http-client.private.env.json");
    }

    public SecretProperties(String path) throws IOException {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
        JsonNode devNode        = new ObjectMapper().readTree(inputStream).path("dev");

        this.secretId  = devNode.path("secret_id").asText();
        this.secretKey = devNode.path("secret_key").asText();

    }

    public String getSecretId(){
        return secretId;
    }

    public String getSecretKey(){
        return secretKey;
    }

}
