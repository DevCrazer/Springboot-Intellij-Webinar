package webinar.resources;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import webinar.resources.hello.HelloResource;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class ResourceConfig extends org.glassfish.jersey.server.ResourceConfig {
    public ResourceConfig(){
        register(
            HelloResource.class
        );
    }
}
