package nordigen.server;

import org.glassfish.grizzly.Connection;
import org.glassfish.grizzly.http.server.*;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.junit.jupiter.api.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.io.IOException;
import java.net.URI;

public class CallbackServiceTest {

    private static final String BASE_URI = "http://localhost:8080/";

    public static void main(String[] args){

        HttpServer server = GrizzlyHttpServerFactory
                .createHttpServer(URI.create(BASE_URI), new CallbackApplication(), false);

        server.getServerConfiguration().getMonitoringConfig().getWebServerConfig()
                .addProbes(new HttpServerProbe.Adapter() {

                    @Override
                    public void onRequestReceiveEvent(
                            HttpServerFilter filter,
                            Connection connection,
                            Request request) {


                    }

                    @Override
                    public void onRequestCompleteEvent(
                            HttpServerFilter filter,
                            Connection connection,
                            Response response) {

                        System.out.println(response.getResponse());
                    }
                });



        try {
            server.start();
            System.out.println("Press any key to stop the server...");
            System.in.read();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    @Test
    public void testCallbackServer() throws IOException {

        //String TARGET = BASE_URI;
        String TARGET = "http://139.162.168.199:9999";

        Client client  = ClientBuilder.newClient();
        WebTarget target = client.target(TARGET);

        String response = target.path("callback")
                .queryParam("code", "<code>")
                .queryParam("state", "<state>")
                .request().get(String.class);
        System.out.println(response);

        System.out.println("Hej");

    }


}
