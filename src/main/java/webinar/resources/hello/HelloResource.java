package webinar.resources.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import webinar.HelloProperties;
import webinar.services.HelloService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    @NotNull
    private final HelloProperties properties;

    @NotNull
    public final HelloService service;

    private HttpServletRequest request;

    @Autowired
    public HelloResource(HelloProperties properties, HelloService service) {
        this.properties = properties;
        this.service = service;
    }

    @GET
    public Greeting getGreeting(@DefaultValue("") @QueryParam("to") String to,
                                @DefaultValue("") @QueryParam("from") String from) {

        String helloTo = to.equalsIgnoreCase("") ? properties.getTarget() : to;
        String helloFrom = from.equalsIgnoreCase("") ?  properties.getFrom() : from;

        String hello = service.getGreeting(properties.getTemplate(), helloTo, helloFrom);
        Greeting greeting = new Greeting(hello);

        return greeting;
    }

//    @GET
//    templates Greeting getGreeting(@DefaultValue("") @QueryParam("to") String to) {
//
//        String hello = service.getGreeting(properties.getTemplate(), properties.getFrom(), properties.getTarget());
//        Greeting greeting = new Greeting(hello);
//
//        return greeting;
//    }

//    @GET
//    @Path("/{id}")
//    templates Greeting getGreeting(@PathParam("to") String to) {
//    }

//    @POST
//    templates void post(@QueryParam("name") String name) {
//    }

}
