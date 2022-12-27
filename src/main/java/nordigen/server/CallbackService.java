package nordigen.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/callback")
public class CallbackService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String ping() {
        return "ping";
    }


    /*@GET
    @Produces(MediaType.TEXT_PLAIN)
    public String sayPlainTextHello(@QueryParam("code") String code, @QueryParam("state") String state) {
        System.out.println("code = " + code);
        System.out.println("state = " + state);
        return "Hello Jersey";
    }*/

}
