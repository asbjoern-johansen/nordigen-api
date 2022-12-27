package nordigen.server;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/*
https://stackoverflow.com/questions/45625925/what-exactly-is-the-resourceconfig-class-in-jersey-2

'services', '/services', or '/services/*'
is all the same. Jersey will change it to be '/services/*'

 */
@ApplicationPath("/")
public class CallbackApplication extends ResourceConfig {
    public CallbackApplication() {
        packages("nordigen.server");
    }



}
